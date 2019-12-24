import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
public class Game implements Runnable{
    @Override
    public void run() {
        final JFrame frame = new JFrame("TOP LEVEL FRAME");
        frame.setLocation(900, 700);

        // Status panel
        final JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);
        final JLabel instructions = new JLabel("SNAYK");
        panel.add(instructions);
        final JLabel scoreLabel = new JLabel("Score: 0");

        // Main playing area
        final GameCourt court = new GameCourt(scoreLabel);
        frame.add(court, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.start();
            }
        });
        control_panel.add(start);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        court.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());

    }

}

