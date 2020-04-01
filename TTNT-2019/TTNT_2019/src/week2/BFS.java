package week2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	public Node bfsUsingQueue(Node initial, int goal) {
		if (initial.state.size() == goal) { // nếu là goal thì trả về node đó
			return initial;
		} else {
			Queue<Node> queue = new LinkedList<>();
			queue.add(initial);
			while (!queue.isEmpty()) {
				Node element = queue.poll();
				if (element.state.size() == goal) { // nếu là goal thì in nó ra
					System.out.println(element.state);
				} else {
					List<Node> node = element.getNeighbours(); // lấy ra các Node liền kề
					for (Node n : node) {
						queue.add(n); // thêm vào Queue
					}

				}
			}
		}
		return initial;
	}
}
