package Engine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

// Handles all things, rendering.

public class Render extends JPanel {
    public static double xIndex = 0;
    public static double  xIndex1 = 0;

    public static boolean WireFrame = false; // TODO: For Later.

    public void DrawWall(Graphics g, double X, double Y, double X1, double Y1, double WallSize) {
        // Walls are Rendered using Vertical Scanlines with consideration for angled walls.

        // Render Lines Vertically
        g.setColor(Color.white);

        // TODO: Transformations remember terry davis's way.

        // Get Player Angle.

        /*
        for (int i = 0; i < 200; i++) {
            g.drawLine((int) X + i, (int) Y, (int) X + i, (int) Y1);
        }
        */

        math.Math mt = new math.Math();

        int wallangle = (int) Level.Wall1.Y + (int) Level.Wall1.Y1;
        int wallsize = (int) mt.Sqrt(Level.Wall1.X + Level.Wall1.X1);
        
        for (int i = 0; i < wallsize; i++) {
            int[] x = {(int) X + i, (int) X + i};
            int[] y = {(int) Y + i * (int) Level.Wall1.Y, (int) Y1 - i * (int) Level.Wall1.Y1};

            System.out.println((int)-Level.Wall1.Y);
            
            Polygon p = new Polygon(x, y, 2);
            g.drawPolygon(p);
        }
    }

    public void clearScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clearScreen(g);
        DrawWall(g, Level.Wall1.X, Level.sect1.CeilingLevel, Level.Wall1.X1, Level.sect1.FloorLevel, 200);
    }

    public void update() {
        repaint();
    }
}