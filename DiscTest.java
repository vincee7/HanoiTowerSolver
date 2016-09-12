package towerofhanoi;
import student.TestCase;

/**
 * Test Case for Disc class
 * @author vincee7
 * @version 2016.07.27
 *
 */
public class DiscTest extends TestCase
{

    private Disc disc;
    
    /**
     * sets up the test case
     */
    public void setUp()
    {
        disc = new Disc(6);
        
    }
    
    /**
     * tests the compareto method.
     * 
     */
    public void testCompareTo()
    {
        Disc disc1 = new Disc(6);
        assertEquals(0, disc.compareTo(disc1));
        
        Disc disc2 = null;
        Exception thrown  = null;
        try
        {
            disc.compareTo(disc2);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        
    }
    
    /**
     * tests to make sure the tostring method
     * returns a string version of the width
     */
    public void testToString()
    {
        String string = "6";
        String string1 = disc.toString();
        assertTrue(string.equals(string1));
        
    }
    
    /**
     * tests the equals method
     * 
     */
    public void testEquals()
    {
        assertTrue(disc.equals(disc));
        Disc disc2 = null;
        assertFalse(disc.equals(disc2));
        Disc disc1 = new Disc(6);
        assertTrue(disc.equals(disc1));
        Object disc3 = new Object();
        assertFalse(disc.equals(disc3));
        Disc disc4 = new Disc(2);
        assertFalse(disc.equals(disc4));
        
    }


}
