package Engine;

// Handles all things related to our Log for debugging purposes.

import javax.imageio.stream.FileCacheImageOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class log {
    public static File log;
    public static FileOutputStream fos;

    public static void CreateLog() throws Exception {
        log = new File("Log.txt");

        if (log.createNewFile()) {
            System.out.println("Log file created..");
        }
    }

    public static void write(String buffer) throws IOException {
        fos = new FileOutputStream("Log.txt");

        if (!buffer.contains("\\n")) {
            buffer += "\n";
        }

        fos.write(buffer.getBytes());
    }
}
