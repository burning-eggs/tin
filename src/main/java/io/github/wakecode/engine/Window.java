package io.github.wakecode.engine;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_MAXIMIZED;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private int width;
    private int height;
    private String title;
    private long glfwWindow;


    private static Window window = null;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Tin Engine";
    }

    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void run() {
        System.out.println("[TIN DEBUG] LWJGL " + Version.getVersion());

        init();
        loop();
    }

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set(); // error callback

        if (!glfwInit()) {
            throw new IllegalStateException("[TIN ERROR] Failed to initialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // default: true
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // default: true
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE); // default: false

        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL); // window
    }

    public void loop() {

    }
}
