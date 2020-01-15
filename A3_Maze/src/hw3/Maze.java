package hw3;

import maze.MazeObserver;
import maze.Status;

/**
 * This class constructs a maze that consists of MazeCells arranged in a 2D grid
 * 
 * @author Christian Lisle
 */
public class Maze {
	/**
	 * Observer to be notified in case of changes to cells in this maze.
	 */
	private MazeObserver observer;
	/**
	 * Maze that stores all of the individual maze cells
	 */
	private MazeCell[][] maze;
	/**
	 * Starting cell and goal cell
	 */
	private MazeCell start, goal;

	/**
	 * Constructs a maze based on a 2D grid. The given strings, rows, represent rows
	 * of a maze, where '#' represents a wall, a blank represents a possible path,
	 * 'S' represents the starting cell, and '$' represents the goal cell. The maze
	 * must be rectangular, which means the Strings in the given rows must have the
	 * same length. Also, there must be only one start cell and one goal cell in the
	 * maze. For each MazeCell in the maze, set its owner to be the current maze,
	 * its status as GOAL if it is the goal cell, UNVISITED if it is not the goal
	 * nor the wall. For each MazeCell that is accessible (not a wall), its
	 * accessible neighbors MUST be added in the order of top, left, bottom, right.
	 * Cells on the boundary of the maze or near a wall will have fewer accessible
	 * neighbors.
	 * 
	 * @param rows The maze
	 */
	public Maze(String[] rows) {
		maze = new MazeCell[rows.length][rows[0].length()];
		// Construct/fill maze with maze cells
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				maze[row][col] = new MazeCell(row, col);
				maze[row][col].setOwner(this);
				// Set the status of each cell accordingly
				if (rows[row].charAt(col) == ' ') {
					maze[row][col].setStatus(Status.UNVISITED);// Accessible path
				} else if (rows[row].charAt(col) == 'S') {
					start = maze[row][col];// This is the starting point cell
					maze[row][col].setStatus(Status.UNVISITED);
				} else if (rows[row].charAt(col) == '$') {
					goal = maze[row][col];// This is the goal cell
					maze[row][col].setStatus(Status.GOAL);
				}
			}
		}
		// Create list of neighbor (accessible) cells
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				// If mazeCell is not a wall then it is checked for possible neighbors
				if (maze[row][col].getStatus() != Status.WALL) {
					// Check for neighbor above, to the left, below, and to the right
					if (row > 0) {// Not at top of column
						if (maze[row - 1][col].getStatus() != Status.WALL) {
							maze[row][col].addNeighbor(maze[row - 1][col]);
						}
					}
					if (col > 0) {// Not at start of row
						if (maze[row][col - 1].getStatus() != Status.WALL) {
							maze[row][col].addNeighbor(maze[row][col - 1]);
						}
					}
					if (row + 1 < maze.length) {// Not at bottom of column
						if (maze[row + 1][col].getStatus() != Status.WALL) {
							maze[row][col].addNeighbor(maze[row + 1][col]);
						}
					}
					if (col + 1 < maze[0].length) {// Not at end of row
						if (maze[row][col + 1].getStatus() != Status.WALL) {
							maze[row][col].addNeighbor(maze[row][col + 1]);
						}
					}
				}
			}
		}
	}

	/**
	 * Sets the observer for the cells of this maze.
	 * 
	 * @param obs
	 */
	public void setObserver(MazeObserver obs) {
		observer = obs;
	}

	public void updateStatus(MazeCell cell) {
		if (observer != null) {
			observer.updateStatus(cell);
		}
	}

	/**
	 * Returns the cell at the given position
	 * 
	 * @param row The row
	 * @param col The column
	 * @return The cell at given row and col
	 */
	public MazeCell getCell(int row, int col) {
		return maze[col][row];
	}

	/**
	 * Returns the number of rows in this maze
	 * 
	 * @return The row number
	 */
	public int getRows() {
		return maze.length;
	}

	/**
	 * Returns the number of columns in this maze
	 * 
	 * @return The col number
	 */
	public int getColumns() {
		return maze[0].length;
	}

	/**
	 * Returns the start cell for this maze
	 * 
	 * @return The start cell
	 */
	public MazeCell getStart() {
		return start;
	}

	/**
	 * Returns the goal cell for this maze
	 * 
	 * @return The goal cell
	 */
	public MazeCell getGoal() {
		return goal;
	}
}
