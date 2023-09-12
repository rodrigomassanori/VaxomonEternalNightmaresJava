import Engine.GameEngine;
import Engine.IGameLogic;
import Engine.VaxomonEternalNightmares;

public class Game 
{
    public static void main(String[] args) 
    {
        try
        {
            boolean Sync = true;

            IGameLogic gameLogic = new VaxomonEternalNightmares();

            GameEngine gameEngine = new GameEngine("Vaxomon Eternal Nightmares", 1440, 960, Sync, gameLogic);

            gameEngine.run();
        }

        catch (Exception E)
        {
            E.printStackTrace();

            System.exit(-1);
        }
    }
}