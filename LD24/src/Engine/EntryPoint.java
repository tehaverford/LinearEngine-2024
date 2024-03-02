package Engine;

import java.awt.*;
import java.awt.image.DataBufferInt;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class EntryPoint extends Canvas implements Runnable {
    public final static int WIDTH = 800;
    public final static int HEIGHT = 600;
    public static boolean IsRunning = false;
    public final static String TITLE = "Maple Engine [Alpha 1.0]";

    static Thread thread;
    public static BufferedImage img;
    public static int[] pixels;
    static Camera camera;

    // Size of Our Map. (Important for Wall Detection)
    static int MapWidth = 200;
    static int MapHeight = 200;

    public static File log;
    public static Screen screen;

    public static Graphics2D g2d;
    public static Render render;

    // Map.
    // TODO: Store maps in files and read from them.

    public EntryPoint() throws IOException {
        // Objects.
		thread = new Thread(this);
        camera = new Camera(3, 3, 5, 5, 70);
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        g2d = (Graphics2D) img.getGraphics();
        screen = new Screen(camera, WIDTH, HEIGHT);
        render = new Render();

		JFrame frame = new JFrame();

        frame.setFocusable(true);

        frame.addKeyListener(camera);
        frame.add(render);
        frame.pack();
        frame.requestFocus();
        frame.setTitle(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);

        System.out.println("[DEBUG] Camera Initalized!");

        // log.createNewFile();
		start();
    }

    public static void main(String[] args) throws IOException {
        // Objects.
		EntryPoint Game = new EntryPoint();
    }

    public void start() {
        if (IsRunning) return;

        IsRunning = true;

        thread.start(); // -> Run();
    }

    public void stop() {
        if (!IsRunning) return;

        IsRunning = false;

        try {
            thread.join(0);
        } catch (Exception err) {
            err.printStackTrace();
            System.exit(0);
        }
    }

    public void Render() {
        camera.update();
        // Constant Checks for Walls within
        // Our Field Of View if there is any.
        // Render if so.
        screen.WallDetection(g2d, MapWidth, MapHeight);
    }

    public void Tick() { }

    public void run() {
        // Load our Level and its context.
        // Then by default should load our
        // Level data for 3D Space to Render. (Render.class)
        Level.Load("C:\\Users\\thomas\\Documents\\Level.txt");

        while (IsRunning) {
            Render();
            Tick();
        }
    }
}