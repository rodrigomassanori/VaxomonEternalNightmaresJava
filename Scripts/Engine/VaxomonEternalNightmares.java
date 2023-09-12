package Engine;

import window.Window;
import Render.Render;
import static org.lwjgl.glfw.GLFW.*;

public class VaxomonEternalNightmares implements IGameLogic
{
    int Direction;

    final Render render;

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
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public void Render(Window window) 
    {
        throw new UnsupportedOperationException("Unimplemented method 'Render'");
    }

    @Override
    public void CleanUp() 
    {
        throw new UnsupportedOperationException("Unimplemented method 'CleanUp'");
    }
}