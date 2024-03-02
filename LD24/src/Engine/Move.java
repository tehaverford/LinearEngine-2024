package Engine;

// Handles all things, Movement.
// The world is moved around the player
// Instead of the player moving around the
// World but it will look the same.

// So in other words.. The World does revolve
// Around you.

public class Move {
    public static void MoveWallsW(double MOVE_SPEED) {
        Level.Wall1.X += 1;
        Level.Wall1.X1 += 1;
    }

    public static void MoveWallsD(double MOVE_SPEED) {
        // ERROR: Maybe something to do with this and WallSize calculations??
        // System.out.println("D Key: " + MOVE_SPEED);
        Level.Wall1.X += MOVE_SPEED;
        Level.Wall1.X1 += MOVE_SPEED;

        EntryPoint.render.update(); // Trigger redraw
    }

    public static void MoveWallsA(double MOVE_SPEED) {
        Level.Wall1.X -= MOVE_SPEED;
        Level.Wall1.X1 -= MOVE_SPEED;
    }

    public static void RotateWallsLeft(double rotationAmount) {
       Level.Wall1.Y -= rotationAmount;

        // Trigger redraw
        EntryPoint.render.update();
    }
}
