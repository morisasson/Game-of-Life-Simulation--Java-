package Ex5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeSimulation {
    public static void main(String[] args) {

        testGOLMatrix();


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void testGOLMatrix() {
        System.out.println("Testing GOLMatrix class:");

        GOLMatrix matrix = new GOLMatrix(3);
        matrix.flipCell(0, 4);
        matrix.flipCell(1, 0);
        matrix.flipCell(1, 1);
        matrix.flipCell(2, 0);
        matrix.flipCell(2, 1);
        matrix.flipCell(3, 1);

        boolean[][] world = matrix.getWorld();
        System.out.println("Initial World:");
        printWorld(world);

        matrix.nextGeneration();
        world = matrix.getWorld();
        System.out.println("After 1 Generation:");
        printWorld(world);

        matrix.nextGeneration();
        world = matrix.getWorld();
        System.out.println("After 2 Generations:");
        printWorld(world);

        matrix.clearWorld();
        world = matrix.getWorld();
        System.out.println("After Clearing World:");
        printWorld(world);
        System.out.println("Generations: " + matrix.getGenerations());
    }

    public static void printWorld(boolean[][] world) {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                System.out.print(world[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Game of Life");
        GOLPanel panel = new GOLPanel(5); // Set the desired world size here
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(2000,2000);
        frame.setVisible(true);
    }
}
