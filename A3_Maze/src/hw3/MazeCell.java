package hw3;

import java.awt.Point;
import java.util.ArrayList;

import maze.Status;

/**
 * Implementation of MazeCell that has a location in a 2D plane.
 * 
 * @author Christian Lisle
 */
public class MazeCell {
	/**
	 * the maze to which this MazeCell belongs.
	 */
	private Maze owner;
	/**
	 * Status of this cell.
	 */
	private Status status;
	/**
	 * Time stamp of the cell
	 */
	private int timeStamp;
	/**
	 * Row and Column of cell
	 */
	private int row, col;
	/**
	 * The Parent cell
	 */
	private MazeCell parent;
	/**
	 * List of neighboring (accessible) cells
	 */
	private ArrayList<MazeCell> neighbors;

	/**
	 * Constructs a maze cell whose location is specified by the given row and
	 * column, whose status is WALL by default, and whose parent is null. The cell
	 * initially has no neighbors. Its initial time stamp is 0.
	 * 
	 * @param row The row
	 * @param col The column
	 */
	public MazeCell(int row, int col) {
		setStatus(Status.WALL);
		setParent(null);
		timeStamp = 0;
		this.row = row;
		this.col = col;
		neighbors = new ArrayList<MazeCell>();
	}

	/**
	 * Adds an observer for changes in this cell's status.
	 * 
	 * @param obs
	 */
	public void setOwner(Maze maze) {
		owner = maze;
	}

	/**
	 * Update the status of this cell and notifies the owner that this current
	 * cell's status has changed
	 * 
	 * @param cell
	 */
	public void setStatus(Status s) {
		status = s;
		if (owner != null) {
			owner.updateStatus(this);
		}
	}

	/**
	 * return the status of the current cell
	 * 
	 * @return status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Adds a neighbor to given cell
	 * 
	 * @param m The maze cell
	 */
	public void addNeighbor(MazeCell m) {
		neighbors.add(m);
	}

	/**
	 * Computes the manhattan deistance between this cell and other cell. The
	 * distance between two points measured along axes at right angles. In a plane
	 * with p1 at (x1,y1) and p2 at (x2, y2), it is |x1 - x2| + |y1 - y2|.
	 * 
	 * @param other Other cell
	 * @return The Manhattan distance
	 */
	public int distance(MazeCell other) {
		java.awt.Point otherPoint = other.getLocation();
		return (int) (Math.abs(row - otherPoint.getX())) + (int) (Math.abs(col - otherPoint.getY()));
	}

	/**
	 * Returns this cell's location as a point, which contains its row and column.
	 * 
	 * @return location The location of the cell
	 */
	public java.awt.Point getLocation() {
		return new Point(row, col);
	}

	/**
	 * Returns the neighbors of the current cell. If a cell has no neighbor, the
	 * method must still return an ArrayList, which is empty.
	 * 
	 * @return neighbors A list of the neighboring cells
	 */
	public java.util.ArrayList<MazeCell> getNeighbors() {
		return neighbors;
	}

	/**
	 * Gets the parent of this cell. This method returns null if the current cell
	 * has no parent.
	 * 
	 * @return parent The parent cell
	 */
	public MazeCell getParent() {
		return parent;
	}

	/**
	 * Sets the parent of this cell with the given parent
	 * 
	 * @param parent The parent cell
	 */
	public void setParent(MazeCell parent) {
		this.parent = parent;
	}

	/**
	 * Returns the time stamp of this cell
	 * 
	 * @return TimeStamp The Time Stamp of the cell
	 */
	public int getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the time stamp of this cell
	 * 
	 * @param time The Time Stamp of the cell
	 */
	public void setTimeStamp(int time) {
		timeStamp = time;
	}

	/**
	 * Returns a string representation of this cell's row and column numbers
	 * enclosed by a pair of parenthesis, e.g., (3, 4), or (10, 0).
	 * 
	 * @overrides toString in class java.lang.Object
	 */
	@Override
	public java.lang.String toString() {
		return "(" + row + ", " + col + ")";
	}
}