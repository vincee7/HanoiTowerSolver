package towerofhanoi;
import student.TestCase;

/**
 * Test case for the tower class
 * @author vincee7
 * @version 2016.07.29
 *
 */
public class TowersTest extends TestCase
{

    private Tower tower;
    
    /**
     * sets up the test case
     * instantiates tower
     */
    public void setUp()
    {
        tower = new Tower(Position.LEFT);
    }
    
    /**
     * tests that the position method returns
     * the correcct position
     */
    public void testPosition()
    {
        assertTrue(tower.position().equals(Position.LEFT));
    }
    
    /**
     * tests the push method to make sure iit adds 
     * a disc on top of the stack on the tower
     */
    public void testPush()
    {
        Disc disc = new Disc(2);
        Disc disc1 = new Disc(3);
        
        tower.push(disc);
        Exception thrown = null;
        try
        {
            tower.push(disc1);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalStateException);
        
    }
    
    

    

}
