package Engine;

import window.Window;

public class GameEngine implements Runnable
{
    public static final int FPS = 60;

    public static final int UPS = 90;

    final Window window;

    final IGameLogic gameLogic;

    final Timer timer;

    public GameEngine(String WindowTitle, int Width, int Height, boolean Sync, IGameLogic gameLogic)
    {
        window = new Window(WindowTitle, Width, Height, Sync);

        this.gameLogic = gameLogic;

        this.timer = new Timer();
    }

    @Override
    public void run()
    {
        try
        {
            Start();

            GameLoop();
        }

        catch (Exception Excp)
        {
            Excp.printStackTrace();
        }
    }

    protected void Start() throws Exception
    {
        window.Start();

        timer.Init();

        gameLogic.Init(window);
    }

    protected void GameLoop()
    {
        float ElapsedTime;

        float Accumulator = 0f;

        float Interval = 1f / UPS;

        boolean Running = true;

        while (!(!Running || window.WindowShouldClose()))
        {
            ElapsedTime = timer.GetElapsedTime();

            Accumulator += ElapsedTime;

            Input();

            while (Accumulator >= Interval)
            {
                Update(Interval);

                Accumulator -= Interval;
            }

            Render();

            if (!window.IsSync())
            {
                Sync();
            }
        }
    }

    void Sync()
    {
        float LoopSlot = 1f / FPS;

        double EndTime = timer.GetLastLoopTime() + LoopSlot;

        while (timer.GetTime() < EndTime)
        {
            try
            {
                Thread.sleep(1);
            }

            catch (InterruptedException I)
            {

            }
        }
    }

    protected void Render()
    {
        gameLogic.Render(window);

        window.Update();
    }

    protected void Input()
    {
        gameLogic.Input(window);
    }

    protected void Update(float Interval)
    {
        gameLogic.Update(Interval);
    }
}