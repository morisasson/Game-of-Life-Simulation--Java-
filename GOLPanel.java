package Ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class GOLPanel extends JPanel {
    private GOLMatrix matrix;
    private JButton cmdGo;
    private JButton cmdNext;
    private JButton cmdClear;
    private JButton cmdFaster;
    private JButton cmdSlower;
    private JLabel lblGenerations;
    private Timer timer;
    private int interval;

    public GOLPanel(int worldSize) {
        matrix = new GOLMatrix(worldSize);
        interval = 200;

        cmdGo = new JButton("Go");
        cmdNext = new JButton("Next");
        cmdClear = new JButton("Clear");
        cmdFaster = new JButton("Faster");
        cmdSlower = new JButton("Slower");
        lblGenerations = new JLabel("Number of generations: 0");

        cmdNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix.nextGeneration();
                repaint();
                lblGenerations.setText("Number of generations: " + matrix.getGenerations());
            }
        });

        cmdGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cmdGo.getText().equals("Go")) {
                    cmdGo.setText("Stop");
                    cmdNext.setEnabled(false);
                    cmdClear.setEnabled(false);
                    cmdFaster.setEnabled(true);
                    cmdSlower.setEnabled(true);
                    timer.start();

                } else {
                    cmdGo.setText("Go");
                    cmdNext.setEnabled(true);
                    cmdClear.setEnabled(true);
                    cmdFaster.setEnabled(false);
                    cmdSlower.setEnabled(false);
                    timer.stop();
                }
            }
        });

        cmdClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix.clearWorld();
                repaint();
                lblGenerations.setText("Number of generations: " + matrix.getGenerations());
            }
        });

        cmdFaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (interval > 100) {
                    interval -= 20;
                    timer.setDelay(interval);
                }
            }
        });

        cmdSlower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (interval < 1000) {
                    interval += 20;
                    timer.setDelay(interval);
                }
            }
        });

        timer = new Timer(interval, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix.nextGeneration();
                repaint();
                lblGenerations.setText("Number of generations: " + matrix.getGenerations());
            }
        });

        setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(cmdGo);
        buttonsPanel.add(cmdNext);
        buttonsPanel.add(cmdClear);
        buttonsPanel.add(cmdFaster);
        buttonsPanel.add(cmdSlower);
        buttonsPanel.add(lblGenerations);
        add(buttonsPanel, BorderLayout.NORTH);


        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int yOffset = 60;
                int squareSize = 20;
                int xOffset = (getWidth() - matrix.getWorld()[0].length * squareSize) / 2; // Calculate the x-offset

                int row = (evt.getY() - 5 - yOffset) / squareSize;
                int col = (evt.getX() - 5 - xOffset) / squareSize;
                matrix.flipCell(row, col);
                repaint();
            }
        });
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean[][] world = matrix.getWorld();
        int squareSize = 20;
        int yOffset = 60;
        int xOffset = (getWidth() - world[0].length * squareSize) / 2; // Calculate the x-offset

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                // Draw the square
                if (world[i][j]) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * squareSize + xOffset, i * squareSize + yOffset, squareSize, squareSize);

                // Draw the border
                g.setColor(Color.BLACK);
                g.drawRect(j * squareSize + xOffset, i * squareSize + yOffset, squareSize, squareSize);
            }
        }
    }
}