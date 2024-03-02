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
        Image image = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;
        // Read Our Image
        try {
            image = ImageIO.read(new File("C:\\Users\\thomas\\Desktop\\Linear\\res\\ball.png"));
            image2 = ImageIO.read(new File("C:\\Users\\thomas\\Desktop\\Linear\\res\\ball2.png"));
            image3 = ImageIO.read(new File("C:\\Users\\thomas\\Desktop\\Linear\\res\\ball3.png"));
            image4 = ImageIO.read(new File("C:\\Users\\thomas\\Desktop\\Linear\\res\\ball4.png"));
        } catch (Exception err) {
            err.printStackTrace();
            System.exit(0);
        }

        // Render Lines Vertically
        g.setColor(Color.white);

        // TODO: Transformations remember terry davis's way.
        
        int xStart = (int) X;
        int yStart = (int) Y;
        int xEnd = (int) X1;
        int yEnd = (int) Y1;
        
        // for (int i = 0; i < WallSize; i++) {
            g.drawImage(image, (int) X, (int) 0.0, (int) X1 - (int) X, 600, null, null);
                          // TODO: Detect the angle the wall is facing.
        // }
    }

    public void clearScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clearScreen(g);
        DrawWall(g, Level.Wall1.X, Level.Wall1.Y, Level.Wall1.X1, Level.Wall1.Y1, 200);
    }

    public void update() {
        repaint();
    }
}