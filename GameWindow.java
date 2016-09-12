package towerofhanoi;
import CS2114.Window;
import CS2114.WindowSide;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import CS2114.Button;
import CS2114.Shape;
/**
 * creates the window where we view the game
 * 
 * @author vincee7
 * @version 2016.07.29
 *
 */
public class GameWindow implements Observer
{
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    private final int DISK_GAP = 0;
    private final int DISK_HEIGHT = 6;
    
    
    /**
     * takes care of making a thread
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    } // end sleep

    /**
     * takes care of making a thread
     * @param button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * updates the front end after the back end 
     * has been changed
     */
    private void moveDisc(Position position)
    {
        Disc currentDisc = game.getTower(position).peek();
        Shape currentPole = left;
        
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        if (position == Position.MIDDLE)
        {
            currentPole = middle;
        }
        if (position == Position.RIGHT)
        {
            currentPole = right;
        }
        
        int x = currentPole.getX() + currentPole.getWidth() / 2
                - currentDisc.getWidth() / 2;
        
        int y = currentPole.getY() + currentPole.getHeight() -
                game.getTower(position).size() * (DISK_GAP + DISK_HEIGHT);
        
        currentDisc.moveTo(x, y);
        
    }
    
    /**
     * creates a new game window
     * @param game
     */
    public GameWindow(HanoiSolver game)
    {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        int x = window.getGraphPanelWidth();
        int y = window.getGraphPanelHeight() / 2;
        
        left = new Shape(x / 6, y, 3, 90, Color.BLACK);
        middle = new Shape(x / 2, y, 3, 90, Color.BLACK);
        right = new Shape((x * 5) / 6, y, 3, 90, Color.BLACK);
        
        for (int i = game.discs(); i >= 1; i--)
        {
            Disc disc = new Disc(i * 6);
            window.addShape(disc);
            game.getTower(Position.LEFT).push(disc);
            moveDisc(Position.LEFT);
            
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solveButton = new Button("Solve");
        solveButton.onClick(this, "clickedSolve");
        window.addButton(solveButton, WindowSide.SOUTH);
        
     
        
    }

    /**
     * updates
     */
    @Override
    public void update(Observable o, Object arg) {
        
        if (arg.getClass().equals(Position.class))
        {
            Position pos = (Position)arg;
            moveDisc(pos);
            sleep();
        }
        
    }
}
