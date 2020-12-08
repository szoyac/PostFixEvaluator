/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfix.jsjf;


import postfix.jsjf.exceptions.*;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private LinearNode<T> top;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element element to be pushed on stack
     */
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it.
     *
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("stack");
            } catch (EmptyCollectionException e) {
                System.out.println(e);
                return null;
            }
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack.
     *
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("stack");
            } catch (EmptyCollectionException e) {
                System.out.println(e);
                return null;
            }
        }

        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        if (top != null) {
            return false;
        }

        return true;  // temp
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return number of elements in the stack
     */
    public int size() {

        return count;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return string representation of the stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public String toString() {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("stack");
            } catch (EmptyCollectionException e) {
                return e.toString();
            }
        }

        String StrLls = "";
        LinearNode<T> strElement = top;
        for (int i = 0; i < count; i++) {
            StrLls += strElement.getElement() + " ";
            strElement = strElement.getNext();
        }

        return StrLls;

    }

    /**
     * Displays a string representation of this stack.
     */

    public void Display() {
        System.out.print(toString());
        System.out.println();
        

    }
 
}
