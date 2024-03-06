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
                double yOffset = y + i;

                // Detect A X or X1 of the wall.
                if (xOffset == Level.Wall1.X && yOffset == Level.Wall1.Y) {
                    // Make sure the point is Infront of the player.
                    // Otherwise do not render.
                    if (Level.Wall1.Y <= camera.yPos || Level.Wall1.Y1 <= camera.yPos) {
                        WallDetected = true;
                        break;
                    }
                }
                if (xOffset == Level.Wall1.X1 && yOffset == Level.Wall1.Y1) {
                    if (Level.Wall1.Y <= camera.yPos || Level.Wall1.Y1 <= camera.yPos) {
                        WallDetected = true;
                        break;
                    }
                }
            }
        }
    }

    public void WallDetection(Graphics2D g, int mapW, int mapH) {
        // int FOV = (int) camera.xDir + (int) camera.yDir;

        int FOV = 800;

        int mapX = (int) camera.xPos;
        int mapY = (int) camera.yPos;

        double RenderDistence = 70;

        double WallX = Level.Wall1.X;
        double WallY = Level.Wall1.Y;

        double WallX1 = Level.Wall1.X1;
        double WallY1 = Level.Wall1.Y1;

        // Get Our WallSize.
        double WallSize = WallX + WallX1;

        for (int i = 0; i < FOV; i++) {
            // Detect If Wall Coordinates is between xDir and yDir.
            inside(i, mapW, mapH);

            if (WallDetected) {
                System.out.println("Wall Detected!");

                // Find the proper coordnate according to Screen Size
                // To Place Our Good Old wall(s).

                test.DrawWall(g, Level.Wall1.X, Level.Wall1.Y, Level.Wall1.X1, Level.Wall1.Y1, Level.Wall1.X + Level.Wall1.X1);

                // Without this the wall rendering is laggy due to it repainting
                // Not very frequiently. For key input.
                camera.update();
                WallDetected = false;
            }
            else {
                // System.out.println("No Wall.");
                /*
                System.out.println("Y: " + WallY);
                System.out.println("Y1: " + WallY1);
                */
            }

            EntryPoint.render.update();
        }
    }
}