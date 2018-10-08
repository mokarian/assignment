package src;/*public boolean contains(Object target)
Returns true if the calling ArrayList contains target; otherwise, returns false. 
public boolean isEmpty()
Returns true if the calling ArrayList is empty (that is, has size 0); otherwise, returns false.
MAKE A COPY:
public Object[] toArray()
Returns an array containing all the elements on the list. Preserves the order of the elements.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PuzzleDFS {
	private Node root;
	private Node goal;
	private CollectionHelper collectionHelper;
// constructor
	public PuzzleDFS (Node root, Node goal)
	{
	    this.root = root;
	    this.goal = goal;
	    collectionHelper = new CollectionHelper();
	    if (collectionHelper.equals(root.data, goal.data)) {
	    	System.out.println("Initial State and Goal are the same!");
	    	System.exit(0);
	    }
	    dfsUsingStack(root);
	}
 //Iterative DFS using stack
	public void dfsUsingStack(Node initialNode)
	{
        //
		List<int[][]> closed_list = new ArrayList<>();
        //implement track of traversed src.Node.data
		List<int[][]> log = new ArrayList<>();
        Stack<Node> stack=new Stack<Node>();
		stack.add(initialNode);
		//closed_list.add(initialNode.data);
		initialNode.visited=true;

		while (!stack.isEmpty())
		{
			collectionHelper.printStack(stack);
			//pop a src.Node from the stack
			Node currentNode=stack.pop();
			//record track of the popped src.Node
	        log.add(currentNode.data);
	        //write record of the popped src.Node on the console
			//Fix it
//	        System.out.print(currentNode.data + " ");
			//call a children method. If there is no children pop the next src.Node from the stack.
			//Otherwise, takes take the children Nodes and assign them to the parent's src.Node
			closed_list.add(currentNode.data);
			List<Node> temp =children(currentNode, log);
			System.out.println("----before if-------------");
			if (temp!=null) {
				System.out.println("-------in if ----------");
				currentNode.setChildren(temp);
				//push the children into the stack
				List<Node> children=currentNode.getChildren();
			//System.out.println(children.size());
//				System.out.println(collectionHelper.stringifyArray(children.get(0).data));
				for (int i = children.size()-1; i >=0; i--) {
					Node nChild =children.get(i);
						//check if goal has been met
					System.out.println(collectionHelper.stringifyArray(nChild.data));
					System.out.println(collectionHelper.stringifyArray(goal.data));
					System.out.println("-----------------");

						if (collectionHelper.equals(nChild.data, goal.data)) {
					    	System.out.println("Goal found! This is the explored nodes:");					
					    	System.out.println(collectionHelper.pathToExploredNodes(log));
					    	System.out.println("This is the solution paths:");
					    	System.out.println(collectionHelper.solutionPath(closed_list, goal.data));
					    	System.exit(0);
						}
					if(nChild!=null && !nChild.visited) {
						stack.add(nChild);
						nChild.visited=true;
					}	else {
							System.out.println("no more child");
					}
				}
			}
	
		}
	}
	
	public List<Node> children(Node currentNode, List<int[][]> log ) {
        List<Node> children = new ArrayList<Node>();
         //deep copy from the src.Node array
		 int [][] copyArray = new int [currentNode.data.length][currentNode.data[0].length];
	      for (int i = 0; i < copyArray.length; ++i) {
	         copyArray[i] = new int[currentNode.data[i].length];
	         for (int j = 0; j < copyArray[i].length; ++j) {
	            copyArray[i][j] = currentNode.data[i][j];
	         }
	      }
        // find location of zero grid
	     int zero_x = 0, zero_y=0;		
		 for (int i = 0; i < copyArray.length; i++)                                               
	            for (int j = 0; j < copyArray[0].length; j++) {
	            	if (copyArray[i][j] == 0) {
	            		zero_x = i;
	            		zero_y = j;
	            		break;
	            	}
	            }
	     // create array x and y to clock around zero grid
		 int [] x = {-1,-1,0,1,1,1,0,-1};
		 int [] y = {0,1,1,1,0,-1,-1,-1};
		 //determine all children using a for loop
		 for (int i = 0; i < 8; i++)    {		 
			  if((zero_x+x[i]>=0) && (zero_y+y[i]>=0) && (zero_x+x[i]<copyArray.length) && (zero_y+y[i]<copyArray[0].length)){
				  //swap zero grid with each surrounding grid
				  copyArray[zero_x][zero_y]= copyArray[zero_x+x[i]][zero_y+y[i]]; copyArray[zero_x+x[i]][zero_y+y[i]]=0;
						//deep copy   
					  	int [][] tempArray = new int [copyArray.length][copyArray[0].length]; 				
						  for (int k = 0; k < copyArray.length; k++)                                               
						            for (int l = 0; l < copyArray[0].length; l++)
						            	tempArray[k][l]=copyArray[k][l];
						//
					if (!new CollectionHelper().contains(log,tempArray)) {
						Node tempNode = new Node(tempArray);
						children.add(tempNode);	
				        log.add(tempNode.data);
					}
					else {
						System.out.println("Below src.Node already visited");
						System.out.println(collectionHelper.stringifyArray(tempArray));						
					}
				
					// back to the original grid values
				  copyArray[zero_x+x[i]][zero_y+y[i]]=copyArray[zero_x][zero_y]; copyArray[zero_x][zero_y]=0;			  
				  }
		 }	 

		 return children;	
	}

	
}
