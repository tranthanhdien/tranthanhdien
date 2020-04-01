package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

public class GeneticAlgorithm {
	// trả về tổng số xung đột hàng ngang
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

	// trả về tổng số xung đột chéo
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

	// đánh giá độ hợp lí của Node
	public int heuristic(Node node) {
		return checkDiagonal(node) + checkHorizontal(node);

	}

	// lai giữa 2 Node cho ra Node mới
	public Node crossover(Node father, Node mother) {
		ArrayList<Integer> list = new ArrayList<>();
		Random rd = new Random();
		int n = rd.nextInt(father.n);
		for (int i = 0; i < n; i++) {
			list.add(father.state.get(i));
		}
		for (int j = n; j < mother.n; j++) {
			list.add(mother.state.get(j));
		}
		Node node = new Node(father.n, list);
		return node;

	}

	// tạo Node mới = phương pháp đột biến
	public Node mutation(Node node) {
		Random rd = new Random();
		int element = rd.nextInt(8);
		int n = rd.nextInt(node.n);
		node.state.set(n, element);
		return node;
	}

	public SortedMap<Integer, Node> generateNeighbours(Node node) {
		System.out.println("node ban dau " + node.state);

		SortedMap<Integer, Node> sort = new TreeMap<Integer, Node>();

		for (int i = 0; i < node.state.size(); i++) {
			int indexCurrent = i;
			for (int j = 0; j < node.n; j++) {

				ArrayList<Integer> li = new ArrayList<Integer>();
				for (int n : node.state) {
					li.add(n);
				}

				if (j != indexCurrent) {
					li.set(indexCurrent, j);
					Node child = new Node(node.n, li);
					System.out.println("node child " + child.state);

					int h = heuristic(child);
					sort.put(h, child);
				}

			}
		}
		return sort;
	}

	public void run() {
		ArrayList<Node> initials = new ArrayList<>();
		for (int k = 0; k < 40; k++) {
			initials.add(new Node(4));

		}

		int fitness = 10; // định nghĩa hàm thích nghi chỉ chọn lọc các cá thể có heuristic <=10
		for (int i = initials.size() - 1; i >= 0; i--) {
			if (heuristic(initials.get(i)) > fitness) // neu so loi lon hon qui dinh thi bo
			{

				initials.remove(i);
			}

		}

		int generation = 20; // định nghĩa số thế hệ tạo ra
		for (int j = 0; j < generation; j++) {
			System.out.println("Thế hệ: " + j + ": ");
			try {
				System.out.println("Initiials " + initials.size());
//			initials.add(mutation(initials.get(j)));
				Random rd = new Random();
				int i = rd.nextInt(initials.size());
				int l = rd.nextInt(initials.size());
				initials.add(crossover(initials.get(i), initials.get(l)));
			} catch (Exception e) {
				System.out.println("khong co du phan tu de thuc hien");
			}
			// tự viết code crossover từng cặp cha mẹ trong initials, thêm con vào initials
			// tự viết code mutation từng đứa con được tạo ra từ crossover, thêm cá thể đã
			// đột biến vào initials
			for (int i = initials.size() - 1; i >= 0; i--) // chọn lọc
			{

				if (heuristic(initials.get(i)) == 0) {
					System.out.println("===============>goal = " + initials.get(i).state);
					break;
				} else if (heuristic(initials.get(i)) > fitness)

				{

					initials.remove(i);

				} else {
					System.out.println("ket qua tai node " + i + " la: " + initials.get(i).state + ", so xung dot: "
							+ heuristic(initials.get(i)));
				}

			}

		}
	}

	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm();
		ga.run();
	}

}
