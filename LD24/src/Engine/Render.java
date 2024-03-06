package Engine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

// Handles all things, rendering.

public class Render extends JPanel {
    public static double xIndex = 0;
    public static double  xIndex1 = 0;

    public static boolean WireFrame = true;

    public void DrawWall(Graphics g, double X, double Y, double X1, double Y1, double WallSize) {
        // Walls are Rendered using Vertical Scanlines with consideration for angled walls.

        // Render Lines Vertically
        g.setColor(Color.white);

        // TODO: Transformations remember terry davis's way.

        g.drawRect((int) X, (int) X1, (int) X1, (int) Y1);
    }

    public void clearScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clearScreen(g);
        DrawWall(g, Level.Wall1.X, Level.sect1.CeilingLevel, Level.Wall1.X1, Level.sect1.CeilingLevel, 200);
    }

    public void update() {
        repaint();
    }
}