package math;

// Abstraction layer to handle most of our Mathematics.

import Engine.Wall;

public class Math {

	
	// Think of this as a RotationMatrix (Not really)
	public static void rotate(double point, double rotationspeed) {
		double radius = 50; // X and Y = Radius
		
		
	}

    // Squareroot (May not be fully accurate so use at your own risk..)
    // Or just use Math.sqrt like the rest of us.
    public static double Sqrt(double value) {
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