package Engine;

public class Timer 
{
    double LastLoopTime;

    public void Init()
    {
        LastLoopTime = GetTime();
    }

    public double GetTime()
    {
        return System.nanoTime() / 1000000000.0;
    }

    public float GetElapsedTime()
    {
        double Time = GetTime();

        float ElapsedTime = (float) (Time - LastLoopTime);

        LastLoopTime = Time;

        return ElapsedTime;
    }

    public double GetLastLoopTime()
    {
        return LastLoopTime;
    }
}