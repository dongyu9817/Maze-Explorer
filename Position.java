//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Position)
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

/**
 * The Position class is a package-visibility helper class. It contains the method equals(Object)
 * and equals (int, int).
 * 
 * @author Katy Dong
 *
 */

class Position {
  int col; // column of the position, 0 indexed
  int row; // column of the position, 0 indexed

  /**
   * Constructs a position object with given row and column
   * 
   * @param row Row for the position
   * @param col Column for the position
   */
  Position(int row, int col) {
    this.col = col;
    this.row = row;
  }

  /**
   * Checks if the two objects have same row and column values This method overrides the equals
   * method declared in the java.lang.Object class
   * 
   * @param other The other position object to be compared with
   */
  @Override
  public boolean equals(Object other) {
    // If the two objects are equal, return true.
    if (this == other) {
      return true;
    }
    // If the two objects are not equal, return false otherwise.
    if (!(other instanceof Position)) {
      return false;
    }

    Position pOther = (Position) other;

    return this.col == pOther.col && this.row == pOther.row;
  }

  /**
   * Checks if the two objects have same row and column values This is an example of overloading
   * methods This method does not override the java.lang.Object's equals method. It has the same
   * name, but different input argument parameters.
   * 
   * @param row Row for comparison
   * @param col Column for comparison
   */
  public boolean equals(int row, int col) {
    // True will be returned if the two objects have same row and column values.
    return this.col == col && this.row == row;
  }

}
