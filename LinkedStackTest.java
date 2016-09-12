package towerofhanoi;
import java.util.EmptyStackException;

import student.TestCase;

/**
 * the test case for linked stack
 * @author vincee7
 * @version 2016.07.29
 *
 */
public class LinkedStackTest extends TestCase
{

    private LinkedStack stack;
    
    /**
     * sets up the test case
     */
    public void setUp()
    {
        stack = new LinkedStack();
    }
    
    /**
     * tests that size returns the actual size
     */
    public void testSize()
    {
        stack.push("asdf");
        assertEquals(1, stack.size());
    }
    
    /**
     * tests that the clear method clears
     * the stack
     */
    public void testClear()
    {
        stack.push("asdf");
        stack.push("asdf");
        stack.push("asdf");
        assertEquals(3, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }
    
    /**
     * tests that isEmpty returns true when the
     * stack is empty and false when it isnt
     */
    public void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push("DFDF");
        assertFalse(stack.isEmpty());
        
    }
    
    /**
     * test peek to make sure it returns the
     * top node
     */
    public void testPeek()
    {
        Exception thrown = null;
        try
        {
            stack.peek();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);
        
        stack.push("asdf");
        assertTrue(stack.peek().equals("asdf"));
        
        
        
    }
    
    /**
     * tests to make sure the pop method removes
     * the top node
     */
    public void testPop()
    {
        Exception thrown = null;
        try
        {
            stack.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertTrue(thrown instanceof EmptyStackException);
        
        stack.push("asdf");
        stack.push("asdfasdf");
        stack.pop();
        assertEquals(stack.size(), 1);
        
    }
    
    /**
     * tests the push method to make
     * sure it adds an item to the top of the 
     * stack
     */
    public void testPush()
    {
        stack.push("asdfasdf");
        assertEquals(stack.size(), 1);
    }
    
    /**
     * tests that the tostring method returns
     * a string of the stack
     */
    public void testToString()
    {
        stack.push("asdf");
        String string = stack.toString();
        String string1 = "[asdf]";
        assertTrue(string.equals(string1));
        
    }


}
