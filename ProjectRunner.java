package towerofhanoi;

public class ProjectRunner 
{

    
    public static void main(String[] arg)
    {
        int discs = 5;
        if (arg.length == 1)
        {
            discs = Integer.parseInt(arg[0]);
        }
        
        HanoiSolver han = new HanoiSolver(discs);
        GameWindow game = new GameWindow(han);
        
    }
}
