package week1;
import java.util.ArrayList;
import java.util.List;

public class Node {
	public int state; // trạng thái
	public boolean visted;
	public List<Node> neighbours;
	public Node parent;
	public boolean visited;

	public Node(int state) {
		super();
		this.state = state;
		this.neighbours = new ArrayList<>();
		this.parent = null;
	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}
	
	public List getNeighbour() {
		return neighbours;
	}
}
