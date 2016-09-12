package towerofhanoi;
import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * LinkedStack implements stackinterface using
 * linked nodes. 
 * @author vincee7
 * @version 2016.07.28
 *
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {

    
    private int size;
    private Node<T> topNode;
    
    /**
     * makes a new LinkedStack
     */
    public LinkedStack()
    {
        size = 0;
        topNode = null;
    }
    
    /**
     * gets the size
     * @return  the size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * clears the stack
     */
    public void clear() 
    {
        topNode = null;
        size = 0;
    }

    /**
     * checks if the stack is empty
     * @return true if the stack is emtpy
     */
    public boolean isEmpty() 
    {
        return size == 0;
    }

    /**
     * returns the data at the top
     * of the stack without affecting 
     * the stack.
     * @return the data from the top node
     */
    public T peek() 
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
        
    }

    /**
     * removes the top node
     * @return the top node
     */
    public T pop() 
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        
        Node<T> temp = topNode;
        topNode = topNode.next;
        size--;
        return temp.getData();
        
    }

    /**
     * adds another item on top of the stack
     * @param arg is the argument
     */
    public void push(T arg) 
    {
        Node<T> node = new Node<T>(arg);
        node.setNextNode(topNode);
        topNode = node;
        size++;
        
    }
    
    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "[";

        Node<T> current = topNode;
        while (null != current) {
            result += "" + current.data;
            current = current.next;
            if (null != current) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
    
    /**
     * Node class for the node implementation
     * @author vincee7
     * @version 2016.07.28
     *
     * @param <D>
     */
    private static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }

        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNextNode(Node<D> n) {
            next = n;
        }

        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> getNextNode() {
            return next;
        }

        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }

}
