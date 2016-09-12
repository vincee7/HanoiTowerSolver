package towerofhanoi;


/**
 * Tower stores the discs as stacks.
 * @author vincee7
 * @version 2016.07.29
 *
 */
public class Tower extends LinkedStack<Disc>
{
    private Position position;
    
    /**
     * Creates a new tower
     * @param position is the position
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
        
    }
    
    /**
     * gives you the position of the tower
     * @return  the position
     */
    public Position position()
    {
        return position;
    }
    
    /**
     * adds a disc on top of the stack on the
     * tower
     * @param disc the disc to be added
     */
    @Override
    public void push(Disc disc)
    {
        if (this.isEmpty() || peek().compareTo(disc) > 0)    
        {
            super.push(disc);
        }
        else
        {
            throw new IllegalStateException();
        }
    }
}
