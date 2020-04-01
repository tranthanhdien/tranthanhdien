package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LocalSearch {
	// 1. tổng xung đột ngang trong 1 node
	public int checkHorizontal(Node node) {
		int sum = 0;
		for (int i = 0; i < node.state.size() - 1; i++) {
			for (int j = i + 1; j < node.state.size(); j++) {
				if (node.state.get(i) == node.state.get(j)) {
					sum++;
				}
			}
		}
		return sum;
	}

	// 2. tổng xung đột chéo trong 1 Node
	public int checkDiagonal(Node node) {
		int sum = 0;
		for (int i = 0; i < node.state.size() - 1; i++) {
			for (int j = i + 1; j < node.state.size(); j++) {
				if (Math.abs(node.state.get(i) - node.state.get(j)) == Math.abs(i - j)) {
					sum++;
				}
			}
		}
		return sum;
	}

	// 3. tổng xung đột ngang và chéo
	public int heuristic(Node node) {
		return checkHorizontal(node) + checkDiagonal(node);
	}

	// 4. thay đổi vị trí quân hậu của Node tại cột y thành dòng x
	public int tryMovingOneQueen(Node node, int x, int y) {
//		int a1 = node.state.get(x);
//		int a2 = node.state.get(y);
//		node.state.add(x, a1);
//		node.state.remove(x - 1);
//		node.state.add(a2, y);
//		node.state.remove(y - 1);
//
//		return heuristic(node);
		int temp = 0;
		node.getState().set(y, x);
		temp = heuristic(node);
		return temp;
	}

	// 5.
	public SortedMap<Integer, Node> generateNeighbours(Node node) {
		SortedMap<Integer, Node> sortedMap = new TreeMap<>();
		// tạo Neighbour của Node đang xét
		for (int i = 0; i < node.state.size(); i++) {
			int indexCurrent = i; // vị trí hiện tại
			for (int j = 0; j < node.n; j++) {
				if (j != indexCurrent) {
					ArrayList<Integer> list = new ArrayList<>();
					for (int n : node.state) {
						list.add(n);
					}
					list.set(i, j);
					Node child = new Node(node.n, list);
					int h = heuristic(child);
					sortedMap.put(h, child);
				}
			}
		}
		return sortedMap;
	}

	// 6.
	public void run() {
		Node initial = new Node(8);
		if (heuristic(initial) == 0) {
			System.out.println(initial.state);
			return;
		}
		System.out.println("Initial state is: " + initial.state);
		Node node = initial;
		SortedMap<Integer, Node> neighbours = generateNeighbours(node);
		Integer bestHeuristic = neighbours.firstKey();
		while (bestHeuristic < heuristic(node)) {
			node = neighbours.get(bestHeuristic);
			neighbours = generateNeighbours(node);
			bestHeuristic = neighbours.firstKey();
		}
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else
			System.out.println("Cannot find goal state! Best state is: " + node.state);
	}

	public static void main(String[] args) {
		LocalSearch local = new LocalSearch();
		local.run();
	}

}
