//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (StackADT<E>)
// Files: .java
// Semester: CS 300 Summer 2018
//
// Author: (Yu (Katy)Dong)
// Email: (ydong65@wisc.edu)
// CS Login: (Katy)
// Lecturer's Name: (Mouna Kacem)
// Lecture Section: 001
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.EmptyStackException;

/**
 * Creating the Generic Interface called StackADT using the type variable "E", which contains the
 * method push(E item), pop(), peek(), and isEmpty().
 * 
 * @author Katy Dong
 *
 * @param <E> the type variable wich will be passed into the methods.
 */
public interface StackADT<E> {
  /**
   * adds a new item to the top of the stack
   * 
   * @param item
   */
  public void push(E item);

  /**
   * removes the top item from the stack and returns it
   * 
   * @return the top item from the list
   * @throws EmptyStackException
   */
  public E pop() throws EmptyStackException;


  /**
   * returns the top item from the stack without removing it
   * 
   * @return the top item from the stack.
   * @throws EmptyStackException
   */
  public E peek() throws EmptyStackException;

  /**
   * Checks if the stack is empty.
   * 
   * @return returns true if the stack is empty, otherwise returns false
   */
  public boolean isEmpty();
}
