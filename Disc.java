package towerofhanoi;
import CS2114.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
 * Disc represents a disc and pretty
 * much functions just to store the width.
 * @author vincee7
 * @version 2016.07.27
 *
 */
public class Disc extends Shape 
    implements Comparable<Disc>
{
    
    
    /**
     * Creates a Disc Shape
     * @param width is the width
     */
    public Disc(int width)
    {
        super(0, 0, width, 6);
        TestableRandom randomG = new TestableRandom();
        int int1 = randomG.nextInt(256);
        int int2 = randomG.nextInt(256);
        int int3 = randomG.nextInt(256);
        Color color = new Color(int1, int2, int3);
        
        
        this.setBackgroundColor(color);
    }
    
    /**
     * Compares the width of this disc to another
     * one. 
     * @return is negative if this disc is smaller
     * and positive if its bigger and 0 if its the same
     * @param otherDisc to be compared with
     */
    @Override
    public int compareTo(Disc otherDisc)
    {
        if (otherDisc == null)
        {
            throw new IllegalArgumentException();
        }
        
        return this.getWidth() - otherDisc.getWidth();
        
    }
    
    /**
     * returns a string version of the width integer
     * @return is the string version of the width
     */
    public String toString()
    {
        return Integer.toString(this.getWidth());
    }
    
    /**
     * returns true if the input is a disc
     * with the same width as this disc
     * @param obj is the input obj to be compared
     * @return is true if the discs are the same width
     */
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (obj.getClass().equals(this.getClass()))
        {
            if (this.getWidth() == ((Disc)obj).getWidth())
            {
                return true;
            }
        }
        return false;
        
    }

}
