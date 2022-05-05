//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (MazeRunnerStack)
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
 * Creating a class called MazeRunerStack, which contains the method pop, peek, push, contains, and
 * isEmpty.
 * 
 * @author Katy Dong
 *
 */
public class MazeRunnerStack implements StackADT<Position> {

  // Fields
  @SuppressWarnings("unused")
  private static final int CAPACITY = 1000; // default array capacity
  private Position[] data; // generic array used to store the items of type T in the stack
  private int top; // index of the top item in the stack

  /**
   * The constructor, which would initialize the Position array called data and set the top value to
   * -1.
   * 
   * @param data
   * @param top
   */
  public MazeRunnerStack() {

    data = new Position[CAPACITY];
    top = -1;
  }

  /**
   * Reports whether the Position p can be found within the stack
   * 
   * @param p represents the position
   * @return true if the position can be found in the stack, false otherwise.
   */
  public boolean contains(Position p) {
    // Using for-loop to traverse every elements in the array. If the Position p is equal to one of
    // the elements in the stack, return true. Otherwise, return false.
    for (int i = 0; i < data.length; ++i) {
      if (p.equals(data[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * adds a new item to the top of the stack
   * 
   * @param item
   */
  @Override
  public void push(Position p) {
    if (p == null) {
      // throw exceptions if the user is attempting to add a null element to the array.
      throw new IllegalArgumentException();
    }
    // After the element is added successfully, increment the index of the top item and update the
    // new item as the top of the data array.
    top++;
    data[top] = p;

  }

  /**
   * removes the top item from the stack and returns it
   * 
   * @return the top item from the list
   * @throws EmptyStackException
   */
  @Override
  public Position pop() throws EmptyStackException {

    if (isEmpty()) {
      // throw new EmptyStackException();

      throw new EmptyStackException();
    }
    Position item = data[top];
    data[top] = null; // item to be removed
    top--; // decrement the index of the top item sine one item has been removed from the array.
    return item;
  }


  /**
   * returns the top item from the stack without removing it
   * 
   * @return the top item from the stack.
   * @throws EmptyStackException
   */
  @Override
  public Position peek() throws EmptyStackException {
    if (isEmpty()) {
      // throw new EmptyStackException();

      throw new EmptyStackException();
    }
    return data[top]; // return item at the top of the stack


  }

  /**
   * Checks if the stack is empty.
   * 
   * @return returns true if the stack is empty, otherwise returns false
   */
  @Override
  public boolean isEmpty() {
    return top == -1;
  }
}


