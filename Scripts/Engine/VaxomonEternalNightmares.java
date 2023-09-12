package Engine;

import window.Window;
import Render.Render;
import static org.lwjgl.glfw.GLFW.*;

public class VaxomonEternalNightmares implements IGameLogic
{
    int Direction;

    final Render render;

    float Color = 0.0f;

    public VaxomonEternalNightmares()
    {
        render = new Render();
    }

    @Override
    public void Init(Window window) throws Exception 
    {
        render.Init(window);
    }

    @Override
    public void Input(Window window) 
    {
        if (window.IsKeyPressed(GLFW_KEY_W))
        {
            Direction = 1;
        }

        else if (window.IsKeyPressed(GLFW_KEY_S))
        {
            Direction = -1;
        }

        else
        {
            Direction = 0;
        }
    }

    @Override
    public void Update(float Interval) 
    {
        Color += Direction * 0.01f;

        if (Color > 1)
        {
            Color = 1.0f;
        }

        else if (Color < 0)
        {
            Color = 0.0f;
        }
    }

    @Override
    public void Render(Window window) 
    {
        window.setClearColor(Color, Color, Color, 0.0f);
    }

    @Override
    public void CleanUp() 
    {
        render.CleanUp();
    }
}