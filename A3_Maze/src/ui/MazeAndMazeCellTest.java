package ui;

import java.util.ArrayList;

import maze.Status;
import hw3.Maze;
import hw3.MazeCell;

/**
 * Some basic tests on the MazeCell and the Maze class. You should 
 * expand the test cases to thoroughly test your classes. 
 * 
 */
public class MazeAndMazeCellTest {
	public static void main(String[] args) {
		MazeCell cell = new MazeCell(1,2);
		System.out.println(cell); // expected: (1,2)
		System.out.println(cell.getStatus()); // expected: Wall
		cell.setStatus(Status.UNVISITED);
		System.out.println(cell.getStatus()); // expected: UNVISITED
		
		MazeCell cell2 = new MazeCell(1,1);
		cell.setParent(cell2);
		System.out.println(cell.getParent()); // expected: (1, 1)
		System.out.println(cell2.getParent()); // expected: null
		System.out.println(cell.distance(cell2)); //Expected 1
		System.out.println(cell.getLocation());//Expected java.awt.Point[x=1,y=2]
		
		
		// The following tests the Maze class
		String[] maze1 =  {
			    "#######",
			    "#   $ #",
			    "#     #",
			    "#     #",
			    "#S#####",
			};
		//also:             0           1            2         3          4 (length of 5)
		String[] maze2 = {"#######", "#   $ #", "#     #", "#     #",  "#S#####",};
		
		Maze maze = new Maze(maze1);
		MazeCell start = maze.getStart(); 
		System.out.println(start); // expected: (4, 1)
		System.out.println(start.getNeighbors()); // expected: [(3, 1)]
		MazeCell goal = maze.getGoal(); 
		System.out.println(goal); // expected (1, 4)
		ArrayList<MazeCell> neighbors = goal.getNeighbors();
		// The goal cell has three neighbors. Since the neighbors are
		// added in top, left, bottom, right order, goal's neighbors' locations are:
		// (1, 3), (2, 4), (1, 5). 
		System.out.println(neighbors); // expected: [(1, 3), (2, 4), (1, 5)].
		
	}

}
