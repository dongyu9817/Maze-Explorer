//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Maze)
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
 * The Maze class contains the method setStart, setFinish, displayMaze, turnRightCheck, solveMaze
 * and the main method. These methods would be responsible for displaying the maze layout, solving
 * the maze by applying the right hand rule.
 * 
 * @author Katy Dong
 *
 */
public class Maze {
  // fields
  private Position start; // Start position
  private Position finish; // Finish position
  private char[][] mazeInfo; //  2-dimensional array of characters that represents the maze layout
  private MazeRunnerStack path; // Final path from start to finish through the maze
  private Boolean solved; // indicates whether is maze path is solved or not

  /**
   * Constructor creates a new instance of Maze with a given layout
   * 
   * @param mazeInfo represents the layout the maze.
   */
  public Maze(char[][] mazeInfo) {
    path = null; // Before the maze has been solved, path should be null
    this.mazeInfo = mazeInfo;
    solved = null;// before a solution has been attempted, solved is also null
    start = null;
    finish = null;

  }

  /**
   * sets the start position field
   * 
   * @param row represents the row of the position
   * @param col represents the column of the position
   */
  public void setStart(int row, int col) {
    start = new Position(row, col);
  }

  /**
   * sets the finish position field
   * 
   * @param row
   * @param col
   */
  public void setFinish(int row, int col) {
    finish = new Position(row, col);

  }

  /**
   * Displays the maze. Note that the code for this method is provided in the assignment
   */
  public void displayMaze() {
    boolean[][] pathGrid = new boolean[mazeInfo.length][mazeInfo[0].length];
    String pathLine = "";
    if (path != null) {
      if (solved) {
        System.out.println("Solution is:");
        Position p;
        while (!path.peek().equals(start)) {
          p = path.pop();
          pathLine = " --> [" + p.row + "," + p.col + "]" + pathLine;
          pathGrid[p.row][p.col] = true;
        }
        p = path.pop();
        pathLine = "[" + p.row + "," + p.col + "]" + pathLine;
      } else
        System.out.println("No solution could be found.");
    }
    // Make the top wall
    for (int j = 0; j < mazeInfo[0].length; j++) {
      System.out.print("+---");
    }
    System.out.println("+");

    // Make each row
    for (int i = 0; i < mazeInfo.length; i++) {

      for (int j = 0; j < mazeInfo[i].length; j++) {
        if (mazeInfo[i][j] == 'L' || mazeInfo[i][j] == '|')
          System.out.print("| ");
        else
          System.out.print("  ");
        if (start.equals(i, j))
          System.out.print("S ");
        else if (finish.equals(i, j))
          System.out.print("F ");
        else if (pathGrid[i][j])
          System.out.print("* ");
        else
          System.out.print("  ");
      }
      System.out.println("|"); // Right wall always present
      // Bottom walls
      for (int j = 0; j < mazeInfo[i].length; j++) {
        if (mazeInfo[i][j] == 'L' || mazeInfo[i][j] == '_')
          System.out.print("+---");
        else
          System.out.print("+   ");
      }
      System.out.println("+");
    }
    // Display the path line if solved
    if (path != null && solved)
      System.out.println("Path is: " + pathLine);

  }

  /**
   * The helper method for checking if the user could turn right at the given direction and positon.
   * 
   * @param direction represents the current direction the user is facing.
   * @param row represents the current row the user is at.
   * @param column represents the current column the user is at.
   * @return return true if the user could turn right, false otherwise.
   */
  public boolean turnRightCheck(int direction, int row, int column) {
    boolean turnRight = true;
    // If it is facing East, check if it can turn right
    if (direction == 1) {
      if (mazeInfo[row][column] == 'L' || mazeInfo[row][column] == '_') {
        turnRight = false;
      }
    }
    // If it is facing North, check if it can turn right
    if (direction == 0) {
      if (column == mazeInfo[0].length - 1 || mazeInfo[row][column + 1] == 'L'
          || mazeInfo[row][column + 1] == '|') {
        turnRight = false;
      }
    }
    // If it is facing South, check if it can turn right
    if (direction == 2) {
      if (mazeInfo[row][column] == 'L' || mazeInfo[row][column] == '|') {
        turnRight = false;
      }
    }
    // If it is facing West, check if it can turn right
    if (direction == 3) {
      if (row == 0 || mazeInfo[row - 1][column] == 'L' || mazeInfo[row - 1][column] == '_') {
        turnRight = false;
      }
    }
    return turnRight;
  }

  /**
   * Solves the maze
   */
  public void solveMaze() {
    // local variable
    int facingOrientation = 1; // 0 is North, 1 is east, 2 is south, and 3 is west
    int currentRow = 0;
    int currentColumn = 0;
    int timeOfLoop = 0;// record how many times have been looped.
    boolean goAhead = false;
    // create a new stack
    path = new MazeRunnerStack();
    // add the starting position to the stack at first.
    path.push(start);

    while (!finish.equals(currentRow, currentColumn)) {
      // if the final position is not reached, keep looping.
      if (timeOfLoop == (mazeInfo.length * mazeInfo[0].length * 4)) {
        solved = false;
        return;// if the maximum time has been tried, exit the while loop to prevent infinite loop
               // and return the boolean solved, which is false.
      }
      // apply right hand rule
      // First check if it can turn right. If it has wall, try go
      // straight instead. If cann't, try turn left.
      if (turnRightCheck(facingOrientation, currentRow, currentColumn)) {// turn right and update
                                                                         // direction it is facing.
        facingOrientation = (facingOrientation + 1) % 4;
        goAhead = true;
        // can't turn right, then go straight ahead.
      } else if (turnRightCheck(facingOrientation - 1, currentRow, currentColumn)) {
        goAhead = true;
        // if it can go straight ahead
      } else if (turnRightCheck(facingOrientation + 2, currentRow, currentColumn)) {
        // try turn left. If it is possible, update the current position.
        facingOrientation = (Math.abs(facingOrientation - 1)) % 4;
        goAhead = true;
      }
      // update current row and column if it is able to go to the next step.
      if (goAhead) {
        if (facingOrientation == 1 && currentColumn < mazeInfo[0].length - 1) {
          ++currentColumn;
        }
        if (facingOrientation == 2 && currentRow < mazeInfo.length - 1) {

          ++currentRow;
        }
        if (facingOrientation == 3 && currentColumn > 0) {
          --currentColumn;
        }
        if (facingOrientation == 0 && currentRow > 0) {
          --currentRow;
        }
        // store the new step into path.
        if (!path.contains(new Position(currentRow, currentColumn))) {
          // if the position has not been included in the path yet, pusg it into the path.
          path.push(new Position(currentRow, currentColumn));
        } else {
          while (!path.peek().equals(currentRow, currentColumn)) {
            path.pop();
          }
        }

      }
      goAhead = false;// After each time looping, reset the goAhead boolean to false.
      ++timeOfLoop;// the last statement of loop.
    }
    solved = true;
  }

  /**
   * This is the optional main method for testing if the maze is solved properly.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Maze maze = new Maze(new char[][] { // Create the maze
        {'L', '_', '|'}, {'L', 'L', 'L'}});
    maze.setStart(0, 0);
    maze.setFinish(0, 2);
    maze.displayMaze();
    maze.solveMaze();
    maze.displayMaze();
  }
}
