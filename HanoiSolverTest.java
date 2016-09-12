package towerofhanoi;
import student.TestCase;

/**
 * Test Case for Hanoi Solver
 * @author vincee7
 * @version 2016.07.29
 *
 */
public class HanoiSolverTest extends TestCase
{
    
    private HanoiSolver han;
    private Disc disc1;
    private Disc disc2;
    private Disc disc3;

    /**
     * sets up the test case
     */
    public void setUp()
    {
        han = new HanoiSolver(3);
        disc1 = new Disc(7);
        disc2 = new Disc(8);
        disc3 = new Disc(9);
    }
    
    /**
     * tests the disc mthod to make sure it returns
     * the number of discs
     */
    public void testDiscs()
    {
        assertEquals(han.discs(), 3);
    }
    
    /**
     * tests the getTower method to make sure
     * it returns the right tower
     */
    public void testGetTower()
    {
        assertEquals(han.getTower(Position.LEFT).position(), Position.LEFT);
        assertEquals(han.getTower(Position.MIDDLE).position(), Position.MIDDLE);
        assertEquals(han.getTower(Position.RIGHT).position(), Position.RIGHT);
    }
    
    /**
     * tests the toString method to make sure it returns
     * the right string
     */
    public void testToString()
    {
        han.getTower(Position.LEFT).push(disc3);
        han.getTower(Position.LEFT).push(disc2);
        han.getTower(Position.LEFT).push(disc1);
        assertTrue(han.toString().equals("[7, 8, 9][][]"));
    }
    
    /**
     * tests the  solve method
     */
    public void testSolve()
    {
        han.getTower(Position.LEFT).push(disc3);
        han.getTower(Position.LEFT).push(disc2);
        han.getTower(Position.LEFT).push(disc1);
        han.solve();
        assertEquals(han.getTower(Position.RIGHT).size(), 3);
    }
    
}
