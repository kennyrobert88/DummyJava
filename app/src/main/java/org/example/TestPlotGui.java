package org.example;

import javax.swing.*;
import java.awt.*;

public class TestPlotGui extends JPanel {
    // Sample data
    private final int[] data = {20, 80, 40, 60, 100, 75, 30};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // Background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);

        // Axes
        g2.setColor(Color.BLACK);
        g2.drawLine(50, height - 50, width - 50, height - 50); // X-axis
        g2.drawLine(50, 50, 50, height - 50); // Y-axis

        // Title
        g2.drawString("Simple Line Plot", width / 2 - 40, 30);

        // Plot data
        g2.setColor(Color.BLUE);
        int stepX = (width - 100) / (data.length - 1);
        int maxData = 100;

        for (int i = 0; i < data.length - 1; i++) {
            int x1 = 50 + i * stepX;
            int y1 = height - 50 - (data[i] * (height - 100) / maxData);
            int x2 = 50 + (i + 1) * stepX;
            int y2 = height - 50 - (data[i + 1] * (height - 100) / maxData);
            g2.drawLine(x1, y1, x2, y2);
        }

        // Optional: Draw points
        g2.setColor(Color.RED);
        for (int i = 0; i < data.length; i++) {
            int x = 50 + i * stepX;
            int y = height - 50 - (data[i] * (height - 100) / maxData);
            g2.fillOval(x - 3, y - 3, 6, 6);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Plot Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setContentPane(new TestPlotGui());
            frame.setVisible(true);
        });
    }
}
