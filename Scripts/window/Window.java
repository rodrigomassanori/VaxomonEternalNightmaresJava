package window;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window 
{
    long win;

    int ScreenWidth;

    int ScreenHeight;

    boolean Resized;

    boolean Sync;

    final String GameTitle;

    public Window(String Title, int Width, int Height, boolean Sync)
    {
        this.GameTitle = Title;

        this.ScreenWidth = Width;

        this.ScreenHeight = Height;

        this.Sync = Sync;

        this.Resized = false;
    }

    public void Start()
    {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit())
        {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);

        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);

        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

        win = glfwCreateWindow(ScreenWidth, ScreenHeight, GameTitle, NULL, NULL);

        if (win == NULL)
        {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetFramebufferSizeCallback(win, (window, width, height) ->
        {
            this.ScreenWidth = width;

            this.ScreenHeight = height;

            this.SetResized(true);
        });

        glfwSetKeyCallback(win, (win, key, scancode, action, mods) ->
        {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
            {
                glfwSetWindowShouldClose(win, true);
            }
        });

        GLFWVidMode VideoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(win, (VideoMode.width() - ScreenWidth) / 2, (VideoMode.height() - ScreenHeight) / 2);

        glfwMakeContextCurrent(win);

        if (IsSync())
        {
            glfwSwapInterval(1);
        }

        glfwShowWindow(win);

        GL.createCapabilities();

        glClearColor(0.0f, 1.0f, 1.0f, 0.0f);
    }

    public void setClearColor(float R, float G, float B, float Alpha)
    {
        glClearColor(R, G, B, Alpha);
    }

    public boolean IsKeyPressed(int KeyCode)
    {
        return glfwGetKey(win, KeyCode) == GLFW_PRESS;
    }

    public boolean WindowShouldClose()
    {
        return glfwWindowShouldClose(win);
    }

    public String GetTitle()
    {
        return GameTitle;
    }

    public int GetWidth()
    {
        return ScreenWidth;
    }

    public int GetHeight()
    {
        return ScreenHeight;
    }

    public boolean IsResized()
    {
        return Resized;
    }

    public void SetResized(boolean Resized)
    {
        this.Resized = Resized;
    }

    public boolean IsSync()
    {
        return Sync;
    }

    public void SetvSync(boolean Sync)
    {
        this.Sync = Sync;
    }

    public void Update()
    {
        glfwSwapBuffers(win);

        glfwPollEvents();
    }
}