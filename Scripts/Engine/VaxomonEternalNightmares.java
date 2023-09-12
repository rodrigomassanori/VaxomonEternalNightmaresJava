package Engine;

import window.Window;
import Render.Render;

public class VaxomonEternalNightmares implements IGameLogic
{
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
        throw new UnsupportedOperationException("Unimplemented method 'Input'");
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