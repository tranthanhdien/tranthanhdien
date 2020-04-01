package week2;

import java.util.List;
import java.util.Stack;


public class DFS {
	public Node dfsUsingStack(Node initial, int goal) {
		if (initial.state.size() == goal) {
			return initial;
		} else {
			Stack<Node> stack = new Stack<Node>();
			stack.push(initial);
			while (!stack.isEmpty()) {
				Node element = stack.pop();
				if (element.state.size() == goal) { // nếu là goal thì in nó ra
					System.out.println(element.state);
					return element;
				} else { // ngược lại lấy Node liền kề và thêm vào Stack
					List<Node> node = element.getNeighbours();
					for (Node v : node) {
						stack.push(v);
					}

				}
			}

		}
		return initial;
	}
}
