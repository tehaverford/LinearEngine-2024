package math;

// Abstraction layer to handle most of our Mathematics.

import Engine.Wall;

public class Math {

    // Vectors used to form the triangle.
    public static Vector Vector1;
    public static Vector Vector2;
    public static Vector Vector3;
    public static Vector Vector4;
    public static Vector VectorDir;

    // Initalize our "360" Triangle for Trigometry.
    // Drawn on the X and Y Axis by Vectors.
    public static void InitalizeTrig() {
        Vector1 = new Vector(-5, 5, 0, 5);
        Vector2 = new Vector(5,5, 0, 5);

        Vector3 = new Vector(-5, -5, 0, -5);
        Vector4 = new Vector(5, -5, 0, -5);
        Vector4 = new Vector(-5, -5,0,-5);
    }

    // Get Player Angle Point.

    public static int SetAngle(int v) {
        // Find the Squareroot for Each Vector
        // Create our Circle.

        int radius = 50; // Radius (Size of Circle.)
        int y = radius; // y Tiles of Circle.

        return 5;
    }

    // Squareroot (May not be fully accurate so use at your own risk..)
    // Or just use Math.sqrt like the rest of us.
    public static int Sqrt(double value) {
        int i = 0;
        int ii = 0;

        while (ii < value) {
            if (i * ii == value) {
                if (i == 1) {
                    continue;
                }
                else {
                    return i;
                }
            }

            i++;
            ii++;
        }

        return i + ii;
    }
}