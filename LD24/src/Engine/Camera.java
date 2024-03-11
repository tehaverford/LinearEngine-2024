package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener {
    public double xPos;
    public double yPos;
    public double xDir;
    public double yDir;


    public final double FOV;

    public boolean FORWARD, BACK, RIGHT, LEFT, ROTATELEFT, ROTATERIGHT;
    public double ROTATE_SPEED = 10;
    public static double MOVE_SPEED = 1.0;

    public static double angle;
    Screen screen;

    public Camera(int x, int y, double xDir, double yDir, int fov) {
        xPos = x;
        yPos = y;

        this.yDir = yDir;
        this.xDir = xDir;

        this.angle = angle;
        this.screen = screen;
        FOV = fov;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    public void update() {
        // TODO: Rotation? (\_(''/)_/)

        if (FORWARD) {
            Move.MoveWallsW(MOVE_SPEED);
        }
        if (BACK) {
            Move.MoveWallsS(MOVE_SPEED);
        }
        if (RIGHT) {
            Move.MoveWallsD(MOVE_SPEED);
        }
        if (LEFT) {
            Move.MoveWallsA(MOVE_SPEED);
        }
        if (ROTATELEFT) {
            Move.RotateWallsLeft(ROTATE_SPEED);
        }
        if (ROTATERIGHT) {
            Move.RotateWallsRight(ROTATE_SPEED);
        }
        EntryPoint.render.repaint();
    }

    @Override
    public void keyPressed(KeyEvent key) {
        if ((key.getKeyCode() == KeyEvent.VK_A))
            LEFT = true;
        if ((key.getKeyCode() == KeyEvent.VK_D))
            RIGHT = true;
        if ((key.getKeyCode() == KeyEvent.VK_W))
            FORWARD = true;
        if ((key.getKeyCode() == KeyEvent.VK_S))
            BACK = true;
        if ((key.getKeyCode() == KeyEvent.VK_RIGHT))
            ROTATERIGHT = true;
        if ((key.getKeyCode() == KeyEvent.VK_LEFT))
            ROTATELEFT = true;
    }

    @Override
    public void keyReleased(KeyEvent key) {
        if((key.getKeyCode() == KeyEvent.VK_A))
            LEFT = false;
        if((key.getKeyCode() == KeyEvent.VK_D))
            RIGHT = false;
        if((key.getKeyCode() == KeyEvent.VK_W))
            FORWARD = false;
        if((key.getKeyCode() == KeyEvent.VK_S))
            BACK = false;
        if((key.getKeyCode() == KeyEvent.VK_RIGHT))
            ROTATERIGHT = false;
        if ((key.getKeyCode() == KeyEvent.VK_LEFT))
            ROTATELEFT = false;
    }
}
