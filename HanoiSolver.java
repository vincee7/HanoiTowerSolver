package towerofhanoi;

import java.util.Observable;

/**
 * HanoiSOlver is the class that is responsible for 
 * solving the puzzle. It uses recursion to do so.
 * @author vincee7
 * @version 2016.07.29
 *
 */
public class HanoiSolver extends Observable
{
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDiscs;
    
    /**
     * creates a new HanoiSolver object
     * @param numDiscs is the number of discs left
     */
    public HanoiSolver(int numDiscs)
    {
        this.numDiscs = numDiscs;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }
    
    /**
     * returns the number of discs left
     * @return the numbeer of discs
     */
    public int discs()
    {
        return numDiscs;
    }
    
    /**
     * returns the tower at the specified position
     * @param pos the position specified
     * @return the tower
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case MIDDLE: 
                return middle;
        
            case RIGHT: 
                return right;
        
            default: 
                return left;
        }
    }
    
    /**
     * Converts the discs on the towers to strings
     * showing their width
     * @return is the string of the towers
     */
    public String toString()
    {
        String string = "";
        
        string += left.toString();
        string += middle.toString();
        string += right.toString();
        
        return string;
    }
    
    /**
     * moves a disc from one tower to another
     * @param source is the starting tower
     * @param des is the ending tower
     */
    private void move(Tower source, Tower des)
    {
        des.push(source.pop());
        setChanged();
        notifyObservers(des.position());
        
    }
    
    /**
     * The method that solves the towers using recursion
     * @param currentDiscs is the current number of discs
     * @param startPole  the starting pole (left)
     * @param tempPole the temp pole (middle)
     * @param endPole the ending pole (right)
     */
    private void solveTowers(int currentDiscs, Tower startPole, 
            Tower tempPole, Tower endPole)
    {
        if (currentDiscs == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDiscs - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * the method that calls the method to solve the puzzle
     */
    public void solve()
    {
        solveTowers(numDiscs, left, middle, right);
    }
    
    
}
