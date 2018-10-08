package src;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int [][] data;
	boolean visited;
	List<Node> children;
/*  private int depth;
	public int getDepth() {
    return depth;
}
	public void setDepth(int depth) {
    this.depth = depth;
}*/	

	//constructor
	Node(int [][] data)
		{
		this.data=data;
		this.children=new ArrayList<>();
		}
	public void addChildren(Node childrenNode)
		{
		this.children.add(childrenNode);
		}
	public List<Node> getChildren() {
		return children;
		}
	public void setChildren(List<Node> children) {
		this.children = children;
		}
}
