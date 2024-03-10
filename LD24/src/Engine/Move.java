package Engine;

// Handles all things, Movement.
// The world is moved around the player
// Instead of the player moving around the
// World but it will look the same.

// So in other words.. The World does revolve
// Around you.

public class Move {
    public static void MoveWallsW(double MOVE_SPEED) {
        // We Subtract the Y axis to make the wall closer
        // to the player appearing like its moving towards.
        Level.Wall1.Y -= MOVE_SPEED;
        Level.Wall1.Y1 -= MOVE_SPEED;
    }

    public static void MoveWallsS(double MOVE_SPEED) {
        Level.Wall1.Y += MOVE_SPEED;
        Level.Wall1.Y1 += MOVE_SPEED;
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

        EntryPoint.render.update();
    }

    public static void RotateWallsLeft(double rotationAmount) {
        Level.Wall1.X1 += rotationAmount;
        Level.Wall1.Y += rotationAmount;
        // Trigger redraw
        EntryPoint.render.update();
    }

    public static void RotateWallsRight(double rotationAmount) {
        Level.Wall1.X1 -= rotationAmount;
        Level.Wall1.Y -= rotationAmount;

        EntryPoint.render.update();
    }
}
