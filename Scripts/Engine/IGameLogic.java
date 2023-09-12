package Engine;

import window.Window;

public interface IGameLogic 
{
    void Init(Window window) throws Exception;

    void Input(Window window);

    void Update(float Interval);

    void Render(Window window);

    void CleanUp();
}