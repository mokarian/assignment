package src;

public class Driver {
//  Solution reached for the below 2x2 puzzle:
//	final static private int [][] INITIAL_STATE = {{2,0},{3,1}};
//  final static private int [][] GOAL_STATE = {{1,2},{0,3}};
	
	/*
	 * 	Project Initial State for a 3x4 puzzle:
	 *	final static private int [][] INITIAL_STATE = {{1,2,6,4},{5,9,7,3},{0,10,11,8}};
	 */

	 // An easy to reach Initial State to test the program for a 3x4 puzzle:
    	final static private int [][] INITIAL_STATE = {{1,2,3,4},{5,6,0,8},{9,10,11,7}};

	    final static private int [][] GOAL_STATE = {{1,2,6,4},{5,9,7,3},{0,10,11,8}};
	
	 public static void main(String[] args) {
    	Node initial =new Node(INITIAL_STATE);
    	Node goal =new Node(GOAL_STATE);
    	
    	PuzzleDFS DFS = new PuzzleDFS(initial, goal);
    }
}
