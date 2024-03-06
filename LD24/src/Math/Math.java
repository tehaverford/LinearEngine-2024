package Math;

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
    public static void InitalizeTrig(int angle) {
        Vector1 = new Vector(-5, 5, 0, 5);
        Vector2 = new Vector(5,5, 0, 5);

        Vector3 = new Vector(-5, -5, 0, -5);
        Vector4 = new Vector(5, -5, 0, -5);
        Vector4 = new Vector(-5, -5,0,-5);
    }

    // Get Player Angle Point.
    public static void point(int value) {

    }

    // Squareroot (May not be fully accurate so use at your own risk..)
    // Or just use Math.sqrt like the rest of us.
    public static int Sqrt(int value) {
        int i = 0;
        int ii = 0;

        while (ii != value) {
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