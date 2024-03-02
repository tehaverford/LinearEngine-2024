package Engine;

import java.awt.*;

public class Screen {
    public Camera camera;

    public int WIDTH;
    public int HEIGHT;

    Render test;

    boolean WallDetected = false;

    public Screen(Camera camera, int WIDTH, int HEIGHT) {
        this.camera = camera;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        test = new Render();
    }

    // This will Calculate Realitive Position to the camera.
    public void relative() {
        
    }
    
    // A Function to Detect Where the wall is
    // On the Map Grid to detect where walls are
    // if they are inside the FOV.
    public void inside(int i, int mapW, int mapH) {
        for (int x = 0; x < mapW; x++) {
            double xOffset = x + i;

            for (int y = 0; y < mapH; y++) {

                // Detect A X or X1 of the wall.
                if (xOffset == Level.Wall1.X) {
                    WallDetected = true;
                    break;
                }
                if (xOffset == Level.Wall1.X1) {
                    WallDetected = true;
                    break;
                }
            }
        }
    }

    public void WallDetection(Graphics2D g, int mapW, int mapH) {
        // int FOV = (int) camera.xDir + (int) camera.yDir;

        int FOV = 800;

        int mapX = (int) camera.xPos;
        int mapY = (int) camera.yPos;

        double WallX = Level.Wall1.X;
        double WallY = Level.Wall1.Y;

        double WallX1 = Level.Wall1.X1;
        double WallY1 = Level.Wall1.Y1;

        // Get Our WallSize.
        double WallSize = WallX + WallX1;

        for (int i = 0; i < FOV; i++) {
            // Detect If Wall Coordnates is between xDir and yDir.
            inside(i, mapW, mapH);

            if (WallDetected) {
                // System.out.println("Wall Detected!");

                // Find the proper coordnate according to Screen Size
                // To Place Our Good Old wall(s).

                test.DrawWall(g, Level.Wall1.X, Level.Wall1.Y, Level.Wall1.X1, Level.Wall1.Y1, Level.Wall1.X + Level.Wall1.X1);
                WallDetected = false;
            }
            else {
                // System.out.println("No Wall.");
            }
        }
    }
}