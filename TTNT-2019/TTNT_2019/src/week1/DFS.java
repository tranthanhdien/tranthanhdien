package week1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS {
	public void dfsUsingStack(Node initial, int goal) {
		if (initial.state == goal) {
			System.out.println("This is goal, finish!");
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.add(initial); // thêm vào Stack
		initial.visited = true; // đánh dấu Node đã thăm
		while (!stack.isEmpty()) { 
			Node element = stack.pop();
			if (element.state == goal) {
				String s = "";
				while (element != initial) {
					s = element.state + "\t" + s;
					element = element.parent;
				}
				System.out.println(initial.state + "\t" + s);
				return;
			}
			List<Node> node = element.getNeighbour(); // lấy ra các Node kề của nó
			for (int i = 0; i < node.size(); i++) {
				Node n = node.get(i);
				if (n.visited == false) { // chưa thăm
					stack.add(n); // thêm vào Stack
					n.visited = true; // đánh dấu là đã thăm
					n.parent = element;
				}
			}

		}
	}

	public static void main(String[] args) {
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		node40.addNeighbours(node10);
		node40.addNeighbours(node20);
		node10.addNeighbours(node30);
		node20.addNeighbours(node10);
		node20.addNeighbours(node30);
		node20.addNeighbours(node60);
		node20.addNeighbours(node50);
		node30.addNeighbours(node60);
		node60.addNeighbours(node70);
		node50.addNeighbours(node70);

		DFS dfs = new DFS();
		System.out.println("The DFS traversal of the graph using Stack: ");
		dfs.dfsUsingStack(node40, 70);
	}
}
