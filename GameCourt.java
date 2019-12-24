import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class GameCourt extends JPanel {
    private Board board;
    private Snayk snayk;
    private Fuud fuud;
    private int score = 0;
    private int time = 0;
    private LinkedList<String> moves;

    public boolean playing = false;
    private JLabel scoreLabel;

    public static final int COURT_WIDTH = 900;
    public static final int COURT_HEIGHT = 700;

    // Update interval for timer, in milliseconds
    public static int interval = 75;

    public GameCourt(JLabel scoreLabel) {
        moves = new LinkedList<>();
        add(scoreLabel);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Timer timer = new Timer(interval, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tick();
                } catch (Exception e1) {
                }
            }
        });
        timer.start();

        setFocusable(true);

        // This key listener allows the snake to move as long as an arrow key is pressed, by
        // changing the snake's velocity accordingly. (The tick method below actually moves the
        // snake.)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    moves.addLast("left");

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    moves.addLast("right");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    moves.addLast("down");
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    moves.addLast("up");
                }
            }


        });
        this.scoreLabel = scoreLabel;
    }

    public void start() {
        snayk = new Snayk();
        Random r = new Random();
        fuud = new Fuud(r.nextInt(44), r.nextInt(34), Color.RED);
        board = new Board(snayk, fuud);
        playing = true;
        score = 0;
        scoreLabel.setText("Score: " + score);
        requestFocusInWindow();
    }

    void tick() throws Exception {
        if (playing) {
            if (moves.size() != 0) {
                String currentMove = moves.pollFirst();
                if (currentMove.equals("left")) {
                    if (!snayk.getDirection().equals("right")) {
                        snayk.setDirection("left");
                    }
                } else if (currentMove.equals("right")) {
                    if (!snayk.getDirection().equals("left")) {
                        snayk.setDirection("right");
                    }
                } else if (currentMove.equals("down")) {
                    if (!snayk.getDirection().equals("up")) {
                        snayk.setDirection("down");
                    }
                } else if (currentMove.equals("up")) {
                    if (!snayk.getDirection().equals("down")) {
                        snayk.setDirection("up");
                    }
                }
            }
            time++;
            if (fuud.getColor().equals(Color.BLUE) && time % 35 == 0) {
                fuud.changePosition();
            }
            // advance the snake in its current direction.
            board.advance();

            if (snayk.getHead().intersects(fuud)) {
                if (fuud.getColor().equals(Color.RED)) {
                    snayk.addBodyPart();
                    board.setFalse(fuud.getX(), fuud.getY());
                    score++;
                    if (score % 5 == 0) {
                        fuud.setColor(Color.BLUE);
                    }
                    fuud.changePosition();
                } else if (fuud.getColor().equals(Color.BLUE)) {
                    snayk.addBodyPart();
                    board.setFalse(fuud.getX(), fuud.getY());
                    score += 2;
                    fuud.setColor(Color.RED);
                    fuud.changePosition();
                }
                scoreLabel.setText("Score: " + score);
            }

            if (snayk.intersectsBody()) {
                playing = false;
                scoreLabel.setText("GAME OVER! FINAL SCORE: " + score);
            }

        }
        // update the display
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }

}
