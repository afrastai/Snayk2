import java.awt.Graphics;

public class Board {
    public static final int WIDTH = 45;
    public static final int HEIGHT = 35;
    private final boolean[][] board = new boolean[WIDTH][HEIGHT];
    private final Snayk snayk;
    private Fuud fuud;

    public Board (Snayk snayk, Fuud fuud) {
        this.snayk = snayk;
        this.fuud = fuud;

        for (BodyPart bp: snayk.getBody()) {
            board[bp.getX()][bp.getY()] = true;
        }
        board[fuud.getX()][fuud.getY()] = true;
    }

    public void advance () throws Exception {
        for (int j = 0; j < WIDTH; j++) {
            for (int k = 0; k < HEIGHT; k++) {
                board[j][k] = false;
            }
        }
        snayk.move();

        for (BodyPart bp: snayk.getBody()) {
            board[bp.getX()][bp.getY()] = true;
        }
        board[fuud.getX()][fuud.getY()] = true;
    }

    public void draw (Graphics g) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (board[x][y] == true) {
                    if (x == fuud.getX() && y == fuud.getY()) {
                        fuud.draw(g);
                    }
                    else {
                        BodyPart bp = snayk.getBodyPart(x, y);
                        bp.draw(g);
                    }
                }
            }
        }
    }
    public void setFuud(Fuud fuud) {
        this.fuud = fuud;
    }

    public void setFalse (int x, int y) {
        board[x][y] = false;
    }
}
