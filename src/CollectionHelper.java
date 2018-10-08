package src;

import java.util.List;
import java.util.Stack;

public class CollectionHelper {

	public boolean contains(List<int[][]> log, int[][] tempArray) {
		for(int[][] element:log) {
	        	
		if(equals(element,tempArray) )	 
		{
			return true;
		}
	        }
   	return false;
	}

	
	 public  boolean equals (int[][] m1, int[][] m2)
	    {
	       if (m1.length != m2.length) return false;
	       for (int i = 0; i < m1.length; i++) {
	         if (m1[i].length != m2[i].length) return false;
	         for (int j = 0; j < m1[i].length; j++) {
	           int b1 = m1[i][j];
	           int b2 = m2[i][j];
	           if (b1 != b2) return false;
	         }
	      }
	      return true;
	    }
	 
	 public  String stringifyArray(int[][] m1) {
			String content="";
				content+="[";
			    for (int i = 0; i < m1.length; i++) 
			         for (int j = 0; j < m1[i].length; j++) 
			        	 if (i==m1.length-1 && j==m1[i].length-1) content += m1[i][j];
			        	 else content += m1[i][j] + ", ";
			    
			    content+="] \n";
       return content;
	    }


	public void printStack(Stack<Node> stack) {
		System.out.println("### Elements in the Stack ###");
		for(Node element:stack) {
			System.out.print(stringifyArray(element.data));
			System.out.println();

		}
		System.out.println("####################################");
	}

	
	public String pathToExploredNodes(List<int[][]> log) 	    {
		String content="";
		for (int k = 0; k < log.size(); k++) {
			int[][] item = log.get(k);
		 	
			content+=(k+1)+": [";
		    for (int i = 0; i < item.length; i++) 
		         for (int j = 0; j < item[i].length; j++) 
		        	 if (i==item.length-1 && j==item[i].length-1) content += item[i][j];
		        	 else content += item[i][j] + ", ";
		    
		    content+="] \n";

			}
	      return content;
	}

	public String solutionPath(List<int[][]> closed_list, int[][] goal) 	    {
		String content="";
		for (int k = 0; k < closed_list.size(); k++) {
			int[][] item = closed_list.get(k);
		 	
			content+="   "+(k+1)+": [";
		    for (int i = 0; i < item.length; i++) 
		         for (int j = 0; j < item[i].length; j++) 
		        	 if (i==item.length-1 && j==item[i].length-1) content += item[i][j];
		        	 else content += item[i][j] + ", ";
		    
		    content+="] \n";

			}
		content+=" Goal: "+stringifyArray(goal);
		
		return content;
	}	
	
	
}
