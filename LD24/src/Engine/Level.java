package Engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Level {
    public static Sectors sect1;

    // Painfully inefficent :/ (But it works!)
    public static Wall Wall1;
    public static Wall Wall2;
    public static Wall Wall3;
    public static Wall Wall4;

    public static String contents;

    public static void Load(String PathToFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PathToFile));

            while ((contents = br.readLine()) != null) {
                // Parse Data here.
                // System.out.println(contents);
                Parse(contents);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public static void Parse(String Contents) {
        // TODO: Load Level from a txt file.

        // For now lets manually assign stuff.
        sect1 = new Sectors(1, 0, 4, 600.0, 50.0);

        // Walls.
        Wall1 = new Wall(10, 1, 400, 10, 1);
        Wall2 = new Wall(5, 5, 4, 1, 1);
        Wall3 = new Wall(5, 5, 5, 2, 1);
        Wall4 = new Wall(4, 5, 5, 3, 1);
    }
}
