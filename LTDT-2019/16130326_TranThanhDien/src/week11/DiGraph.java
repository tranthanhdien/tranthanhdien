package week11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// directed graph
public class DiGraph extends Graph {

	public DiGraph(int v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	// thêm cạnh
	@Override
	public void addEdges(int src, int dest) {
		if (src >= 0 && src < this.numVex && dest >= 0 && src < this.numVex) {
			this.arr[src][dest] = 1; // đồ thị có hướng nên thêm 2 chiều
		}

	}

	// thêm cạnh có trọng số
	public void addEdge(int src, int dest, int weight) {
		if (src >= 0 && src < this.numVex && dest >= 0 && src < this.numVex) {
			this.arr[src][dest] = weight;
		}

	}

	// xoá cạnh
	@Override
	public void delEdges(int src, int dest) {
		if (src >= 0 && src < this.numVex && dest >= 0 && src < this.numVex) {
			this.arr[src][dest] = 0;
		}
	}

	// tính bậc trong deg-(bậc trong là đi vào)
	public int degreeIn(int src) {
		int sum = 0;
		if (src >= 0 && src < this.numVex) {
			for (int i = 0; i < this.arr.length; i++) {
				sum += this.arr[i][src];
			}

		}
		return sum;
	}

	// tính bậc ngoài deg+(bậc ngoài là đi ra)
	public int degreeOut(int src) { // đưa vào 1 đỉnh
		int sum = 0;
		if (src >= 0 && src < this.numVex) {
			for (int i = 0; i < this.arr.length; i++) {
				sum += this.arr[src][i];
			}

		}
		return sum;
	}

	// in số bậc tất cả đỉnh của đồ thị có hướng
	public String printDegree() {
		String result = "";
		int total = 0;
		for (int i = 0; i < this.arr.length; i++) {
			result += "Đỉnh " + (i + 1) + " có bậc là: " + degree(i) + "\n";
			total += degree(i);
		}
		return result + "==>Tổng bậc: " + total;
	}

	// bậc của đồ thị có hướng = bậc trong + bậc ngoài
	@Override
	public int degree(int src) {
		return degreeIn(src) + degreeOut(src);
	}

	// tổng số bậc của đồ thị có hướng
	public int totalDegree() {
		int total = 0;
		for (int i = 0; i < this.arr.length; i++) {
			total += degree(i);
		}
		return total;
	}

	// số cạnh của đồ thị
	@Override
	public int numberEdgeGraph() {
		return totalDegree() / 2;
	}

	// tuần 2***********************************************************
	// kiểm tra tính liên thông
	@Override
	public boolean isConnected() {
		for (int i = 0; i < arr.length; i++) {
			if (degreeIn(i) > 0 && degreeOut(i) > 0) {
				System.out.println("Đồ thị liên thông mạnh");
				return true;
			}
			if (degreeIn(i) == 0 || degreeOut(i) == 0) {
				System.out.println("Đồ thị liên thông yếu");
				return false;
			}
		}
		return false;
	}

	// dùng đệ quy
	@Override
	public void DFS(int vexStart) {
		visited[vexStart] = true;
		System.out.print(vexStart + "\t");
		for (int i = 0; i < arr.length; i++) {
			if (arr[vexStart][i] > 0 && visited[i] == false) {
				DFS(i);
			}
		}
	}

	// đếm thành phần liên thông(dùng đệ quy)
	@Override
	public int countConnected() {
		int count = 1;
		DFS(0);
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false) {
				DFS(i);
				count++;
			}
		}
		return count;

	}

	// tìm thành phần liên thông
	@Override
	public void findConnection() {
//		String s = "[";
//		if (arr.length == 0) {
//			throw new Exception("Matrix chưa được khởi tạo");
//		}
//		if (isBir()) {
//			for (int i = 0; i < arr.length; i++)
//				s += i + "-->";
//			s = s.substring(0, s.length() - 3);
//			return s + "]";
//		}
//		s = "";
//		for (int i = 0; i < arr.length; i++) {
//			if (visited[i] == 0)
//				s += searchElementLienThong(i, visited) + "\n";
//		}
//		return s;

	}

	// đồ thị có hướng có lưỡng phân k==>// ko có
	@Override
	public boolean isBir() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean lienThongManh() {
		// neu co vao co ra thi lien thong manh
		for (int i = 0; i < this.arr.length; i++) {
			if (degreeIn(i) > 0 && degreeOut(i) > 0) {
				return true;
			}
		}
		return false;
	}

	public boolean lienThongYeu() {
		for (int i = 0; i < this.arr.length; i++) {
			if (degreeIn(i) == 0 || degreeOut(i) == 0) {
				return true;
			}
		}
		return false;
	}

	// tuần 3***************************************************************
	// ktra đồ thị này có phải là con của đồ thị kia hay k?
	// Điều kiện: số đỉnh đồ thị this <= that(hợp lệ thì xét cạnh)
	//
	@Override
	public boolean isSubGraph(Graph g1, Graph g2) {
		ArrayList<Edges> l1 = new ArrayList<>(); // list cạnh con
		ArrayList<Edges> l2 = new ArrayList<>(); // list cạnh cha
		// if this graph <= that graph ==> xét cạnh
		if (g1.numVex <= g2.numVex) {
			// xét cạnh đồ thị thứ 1
			for (int i = 0; i < g1.numVex; i++) {
				for (int j = 0; j < g1.numVex; j++) {
					if (g1.arr[i][j] != 0) { // có cạnh
						l1.add(new Edges(i, j));
					}
				}
			}
			// xét cạnh đồ thị thứ hai
			for (int i = 0; i < g2.numVex; i++) {
				for (int j = 0; j < g2.numVex; j++) {
					if (g2.arr[i][j] != 0) { // có cạnh
						l2.add(new Edges(i, j));
					}
				}
			}
			// ktra
			int count = 0;
			for (int i = 0; i < l1.size(); i++) {
				for (int j = 0; j < l2.size(); j++) {
					if (l1.get(i).toString().equalsIgnoreCase(l2.get(j).toString())) {
						count++;
					}
				}
			}
			if (count == l1.size()) {
				return true;
			}
		}
		// ngược lại
		return false;
	}

	@Override
	public void DFS_Stack(int start) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		stack.push(start);// đưa đỉnh start vào Stack
		list.add(start);
		visited[start] = true; // đánh dấu đã duyệt
		while (!stack.empty()) {
			int k;
			int count = 0;
			k = stack.peek(); // lấy k ra khỏi Stack, lấy nhưng ko xoá
			for (int i = 0; i < this.numVex; i++) {
				if ((this.arr[k][i] > 0) && visited[i] == false) { // xđ đỉnh kề mà chưa xét
					list.add(i);
					stack.push(i); // đưa đỉnh kề chưa xét i vào break liền
				} else {
					count++;
				}
			}

			if (count == visited.length) { // đi qua tất cả các đỉnh thì xoá khỏi Stack
				stack.pop();
			}

		}
		for (Integer i : list) {
			System.out.print((i + 1) + "\t");
		}

	}

	@Override
	public void BFS_Queue(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			System.out.print("\t" + v);
			for (int i = 0; i < arr.length; i++) {
				if (arr[v][i] > 0 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

	String s = "";

	@Override
	public void findPathLong(int src, int dest) {
		visited[src] = true; // đã thăm
		for (int i = 0; i < this.numVex; i++) {
			if (arr[src][i] != 0 && visited[i] == false) { // có cạnh
				visited[i] = true;
				s += (src + 1) + "==>";
				if (i == dest) {
					s += i + 1; // nếu như tới đích
					System.out.println(s);
					break;

				} else
					findPathLong(i, dest);
			}
		}
	}

	@Override
	public void findPathShortest(int src, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = true;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(src);

		while (!queue.isEmpty()) {
			src = queue.poll();
			System.out.print((src + 1) + "\t");
			if (src == dest)
				break;
			for (int i = 0; i < this.numVex; i++) {
				if (arr[src][i] != 0 && visited[i] == false) {
					list.add(i);
					visited[i] = true;
					queue.add(i);
				}

			}

		}

	}

	// Week4: ***********************************************************
	// kiểm tra chu trình Euler
	// G cân bằng(đỉnh bậc trong = đỉnh bậc ngoài)
	@Override
	public boolean checkCycleEuler() {
		if (lienThongYeu() || lienThongManh() && this.numVex > 1) {
			for (int i = 0; i < arr.length; i++) {
				if (degreeIn(i) == degreeOut(i)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// kiểm tra đường đi Euler
	@Override
	public boolean checkEulerPath() {
		int countX = 0; // deg(X)
		int countY = 0; // deg(Y)
		int dinhConLaiCB = 0;

		for (int i = 0; i < this.arr.length; i++) {
			// có đúng 2 đỉnh x, y thoã
			if (degreeIn(i) == (degreeOut(i) + 1)) { // deg+(X)=deg-(X)+1
				countY++;
			}
			if (degreeOut(i) == (degreeIn(i) + 1)) { //// deg-(X)=deg+(X)+1
				countX++;
			}
			// các đỉnh còn lại cân bằng
			if (degreeIn(i) == degreeOut(i)) {
				dinhConLaiCB++;
			}
		}
		// liên thông yếu or liên thông mạnh và thoã 2 điều kiện trên
		if ((lienThongYeu() || lienThongManh()) && countX == 1 && countY == 1 && dinhConLaiCB == (this.numVex - 2))
			return true;

		return false;
	}

	@Override
	public void findCycleEuler(int start) {
		if (checkCycleEuler() == false) {
			System.out.println("Không có chu trình Euler!");
		} else {
			// tạo ma trận mới chứa kích thước ma trận cũ
			// int[][] c;
			Stack<Integer> stack = new Stack<>();
			ArrayList<Integer> list = new ArrayList<>(); // lưu các đỉnh đã duyệt
			stack.push(start);
			list.add(start);
			while (!stack.isEmpty()) {
				int x = stack.pop(); // lấy ra
				for (int i = 0; i < arr.length; i++) {
					if (arr[x][i] != 0) { // nếu có cạnh liền kề
						stack.add(i);
						list.add(i);
						arr[x][i] = 0; // xoá nó đi
						x = i;
						i = 0;
					}
					if (i == numVex && !stack.isEmpty()) { // chạy hết các cạnh
						stack.pop();
					}
				}
			}
			System.out.println("Chu trình Euler: ");
			for (Integer c : list) {
				System.out.print((c + 1) + "\t");
			}

		}

	}

	@Override
	public void findPathEuler(int start) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		if (degree(start) % 2 != 0) { // nếu đỉnh bậc lẻ thì push vào
			stack.add(start);
			list.add(start);
		} else { // ko phải đỉnh lẻ ==> kiếm đỉnh bậc lẻ đầu tiên duyệt
			for (int i = 0; i < arr.length; i++) {
				if (degree(i) % 2 != 0) { // nếu đỉnh lẻ
					start = i; // duyệt từ đỉnh lẻ đó
					stack.add(start);
					list.add(start);
					break;
				} else { // không có đỉnh bậc lẻ nào
					System.out.println("Không có đường đi Euler!");
				}
			}
		}
		while (!stack.isEmpty()) {
			int x = stack.pop();
			for (int i = 0; i < arr.length; i++) {
				if (arr[x][i] != 0) {
					stack.add(i);
					list.add(i);
					arr[x][i] = 0; // sau khi thêm vào thì xoá đi (vì đối xứng nên arr[x][i] = arr[i][x]
					x = i;
					i = 0;
				}
				if (i == numVex && !stack.isEmpty()) { // chạy hết các cạnh
					stack.pop();
				}
			}
		}
		System.out.println("\nĐường đi Euler: ");
		for (Integer c : list) {
			System.out.print((c + 1) + "\t"); // tại vì chạy ở 0 nên in ra phải +1
		}
	}

	// tuần 5
	// liên thông mạnh, đỉnh bậc trong or bậc ngoài >= n(đỉnh)/2
	@Override
	public boolean checkCycleHamilton() {
		if (lienThongManh()) {
			for (int i = 0; i < this.arr.length; i++) {
				if (degreeIn(i) >= this.numVex / 2 || degreeOut(i) >= this.numVex / 2) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean checkPathHamilton() {
		if (this.numVex < 3 && !isConnected()) {
			return false;
		}
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (degree(i) == 1) { // đếm đỉnh bậc 1
				count1++;
			}
			if (degree(i) >= (this.numVex / 2) - 1) {
				count2++;
			}
			if (degree(i) <= (this.numVex / 2) - 1) {
				count3++;
			}
		}
		if (count2 == this.numVex) {
			return true;
		}
		if (count1 == 1 && count2 == (numVex - count1)) {
			return true;
		}
		if (count1 == 2 && count3 == 2 && count2 == (this.numVex - count1 - count2)) {
			return true;
		}

		return false;
	}

	private void expand(int i) {
		for (int j = 0; j < this.numVex; j++) {
			if (visited[j] == false && this.arr[path[i - 1]][j] > 0) {
				path[i] = j;
				if (i < this.numVex - 1) {
					visited[j] = true;
					expand(i + 1);
					visited[j] = false;
				} else {
					if (this.arr[path[i]][0] > 0) {
						printHamiltonCycle(path);
						System.out.print(path[0] + 1);
						System.out.println();

					}

				}
			}
		}
	}

	private void printHamiltonCycle(int[] path) {
		String result = "";
		for (int i = 0; i < path.length; i++) {
			result += path[i] + 1 + "\t";
		}
		System.out.print(result);
	}

	@Override
	public void findCycleHamiltonAll() {
		if (checkCycleHamilton()) {
			System.out.println("Tất cả chu trình Hamilton: ");
			for (int i = 0; i < numVex; i++) {
				visited[i] = false;
			}
			path[0] = 0;
			visited[0] = true;
			expand(1);
		} else {
			System.out.println("Đồ thị không có chu trình Hamilton!");
		}

	}

	// tuần 6
	@Override
	public void findCycleHamiltonAll(int start) {
		if (checkCycleHamilton()) {
			System.out.println("Tất cả chu trình Hamilton: ");
			for (int i = 0; i < numVex; i++) {
				visited[i] = false;
			}
			path[0] = start;
			visited[start] = true;
			expand(1);
		} else {
			System.out.println("Đồ thị không có chu trình Hamilton!");
		}
	}

	@Override
	public void allPathHamilton() {
		// if (checkEulerPath()) {
		System.out.println("Tất cả đường đi Hamilton!");
		for (int i = 0; i < numVex; i++) {
			visited[i] = false;
		}
		int v = 0;

		path[0] = v;
		visited[v] = true;
		expandPath(1);
//		} else {
//			System.out.println("Đồ thị không có đường đi Hamilton!");
//		}
	}

	private void expandPath(int i) {
		for (int j = 0; j < numVex; j++) {
			if (visited[j] == false && arr[path[i - 1]][j] != 0) {
				path[i] = j;
				if (i < numVex - 1) {
					visited[j] = true;
					expandPath(i + 1);
					visited[j] = false;

				} else {
					if (i == this.numVex - 1) {
						printHamiltonPath(path);
						System.out.println();
					}
				}
			}
		}

	}

	private void printHamiltonPath(int[] path) {
		for (int i = 0; i < path.length; i++) {
			System.out.print((path[i] + 1) + "\t");
		}

	}

	@Override
	public void allPathHamilton(int start) {
		// if (checkEulerPath()) {
		System.out.println("Tất cả đường đi từ đỉnh " + (start + 1));
		for (int i = 0; i < numVex; i++) {
			visited[i] = false;
		}
		path[0] = start;
		visited[start] = true;
		expandPath(1);
//		} else {
//			System.out.println("Đồ thị không có đường đi Hamilton!");
//		}

	}

	// tuần 7 Tree
	// *******************************************************************
	// DFS ==> [][]: khử đệ quy
	@Override
	public int[][] dfsTree(int start) {
		int[][] result = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			visited[i] = false;
		}
		Stack<Integer> stack = new Stack<>();
		// ArrayList<Integer> list = new ArrayList<>();
		// gán đỉnh bắt đầu đã đc thăm
		visited[start] = true;
		// thêm đỉnh bắt đầu vào
		stack.push(start);
		// list.add(start);
		// System.out.println("Cây bào trùm (DFS):");
		while (!stack.isEmpty()) {
			int i = stack.peek(); // lấy phần tử trên cùng nhưng k xoá
			int count = 0;
			for (int j = 0; j < visited.length; j++) {
				if (arr[i][j] > 0 && visited[j] == false) {
					// thêm tập cạnh
					result[i][j] = 1;
					// thêm j vào tập đỉnh để xét
					stack.push(j);
					visited[j] = true;
					// thêm j vào tập đỉnh trả về
					// list.add(j);
					break;
				} else {
					count++;
				}
			}
			// nếu thăm hết các đỉnh thì xoá đi
			if (count == visited.length) {
				stack.pop();
			}
		}
		return result;
	}

	// DFS ==> Graph (khử đệ quy)
	public Graph dfsTree_Graph(int start) {
		Graph graph = new UnGraph(this.numVex);
		graph.arr = dfsTree(start);
		return graph;
	}

	// DFS đệ quy ==> [][]
	int[][] result = new int[this.numVex][this.numVex];

	public int[][] dfs_Recursive(int start) {
		visited[start] = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[start][i] != 0 && visited[i] == false) {
				visited[i] = true;
				result[start][i] = 1; // có hướng nên chỉ add 1 lần
				dfs_Recursive(i);
			}
		}
		return result;
	}

	// DFS đệ quy ==> Graph
	public Graph dfs_Recu(int start) {
		Graph graph = new UnGraph(this.numVex);
		graph.arr = dfs_Recursive(start);
		return graph;
	}

	// BFS ==> [][]
	@Override
	public int[][] bfsTree(int start) {
		int[][] tree = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<>();
		// ArrayList<Integer> list = new ArrayList<>();
		visited[start] = true;
		queue.add(start);
		// list.add(start);
		// System.out.println("Cây bao trùm (BFS)");
		while (!queue.isEmpty()) {
			int v = queue.remove();
			// System.out.print((v + 1) + "\t");
			// list.add(v);
			for (int i = 0; i < arr.length; i++) {
				if (arr[v][i] != 0 && visited[i] == false) {
					visited[i] = true;
					tree[i][v] = 1;
					queue.add(i);
				}
			}
		}
		return tree;
	}

	// BFS ==> Graph
	public Graph bfsTree_Graph(int start) {
		Graph graph = new UnGraph(this.numVex);
		graph.arr = bfsTree(start);
		return graph;
	}

	// tuần 8
	@Override
	public int[][] kruskalTree() {
		int[][] result = new int[this.numVex][this.numVex];
		List<Edges> listEdges = new ArrayList<>(); // list cạnh theo trọng số
		int totalWeight = 0; // tổng trọng số nhỏ nhất
		int countEdge = 0; // đếm số cạnh

		// thêm tất cả tập cạnh vào list(chưa sắp xếp)
		for (int i = 0; i < this.numVex; i++) {
			for (int j = 0; j < this.numVex; j++) {
				if (arr[i][j] > 0) { // nếu có cạnh thì thêm vào list
					listEdges.add(new Edges(i, j, arr[i][j]));
					// sau khi chạy xong sẽ đc danh sách các cạnh chưa sắp xếp
				}
			}
		}
		// sắp xếp các tập cạnh theo thứ tự tăng dần trọng số
		Collections.sort(listEdges, new Comparator<Edges>() {

			@Override
			public int compare(Edges e1, Edges e2) {
				return e1.getWeight() - e2.getWeight();// sắp xếp theo trọng số tăng dần
			}

		});
		// in ra các cạnh đã sắp xếp
		System.out.println("Các cạnh sắp xếp theo chiều tăng dần trọng số: ");
		for (int i = 0; i < listEdges.size(); i++) {
			Edges edge = listEdges.get(i); // lấy cạnh ra
			System.out.println("(" + (edge.getA() + 1) + ", " + (edge.getB() + 1) + ")" + ": " + edge.getWeight());
		}
		// duyệt tới khi nào số cạnh trong cây T = (số đỉnh -1)
		System.out.println("Các cạnh đã duyệt: ");
		while (countEdge < this.numVex - 1) {
			for (int i = 0; i < listEdges.size(); i++) {
				Edges tmp = listEdges.get(i); // lấy ra cạnh trong list để ktra
				if (hasCycle(result, tmp.getA(), tmp.getB()) == false) {// ktra cạnh vừa lấy ra có tạo chu trình hay k
					// k có chu trình thi thêm vào cây T
					result[tmp.getA()][tmp.getB()] = tmp.getWeight();
					result[tmp.getB()][tmp.getA()] = tmp.getWeight();
					System.out.println("(" + (tmp.getA() + 1) + ", " + (tmp.getB() + 1) + ")" + ": " + tmp.getWeight());
					totalWeight += tmp.getWeight(); // tính trọng số cho cạnh đó
					countEdge++; // tăng số cạnh lên 1

				}
				// ngược lại có chu trình
				else {
					System.out.println("(" + (tmp.getA() + 1) + ", " + (tmp.getB() + 1) + ")" + ": " + tmp.getWeight()
							+ ": Có chu trình");
					tmp = listEdges.remove(0);
				}
			}
		}
		System.out.println("Tổng trọng số nhỏ nhất: " + totalWeight);
		return result;

	}

	// ktra cạnh thêm vào có tạo chu trình k

	public boolean hasCycle(int[][] matrix, int u, int v) {
		// visited = new boolean[matrix.length];
		// cho tất cả là chưa thăm
		for (int i = 0; i < matrix.length; i++) {
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(u); // thêm vào queue
		visited[u] = true; // cho đỉnh đó là đã thăm
		while (!queue.isEmpty()) {
			u = queue.remove(); // lấy ra duyệt và xoá nó
			for (int i = 0; i < matrix.length; i++) {
				if (visited[i] == false && matrix[u][i] > 0) { // nếu đỉnh đó chưa thăm và có cạnh
					queue.add(i); // thêm vào queue
					visited[i] = true; // đỉnh đã thăm
					if (v == i) { // nếu đỉnh bắt đầu == đỉnh kết thúc==> có chu trình
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public int[][] primTree(int[][] arr, int start) {
		int[][] result = new int[arr.length][arr.length];
		int totalWeight = 0; // tổng trọng số
		List<Edges> listEdges = new ArrayList<>(); // list cạnh
		int countEdge = 0; // đếm số cạnh
		visited = new boolean[arr.length];
		// cho tất cả chưa thăm
		for (int i = 0; i < this.numVex; i++) {
			visited[i] = false;
		}
		// đưa đỉnh đầu tiên vào thăm
		visited[start] = true;
		// chạy đến khi nào Tree đủ (n-1) cạnh thì dừng, ngược lại chạy tiếp
		while (countEdge < this.numVex - 1) {
			for (int i = 0; i < visited.length; i++) {
				if (arr[start][i] > 0 && visited[i] == false) { // nếu có cạnh và chưa thăm
					// thêm vào list cạnh
					listEdges.add(new Edges(start, i, arr[start][i])); // thêm cạnh, có trọng số
					visited[i] = true; // gán lại đỉnh đó đã thăm
				}
				if (i == visited.length - 1) {
					// sắp xếp các cạnh theo thứ tự tăng dần(chỉ các cạnh đã duyệt)
					// lấy ra cạnh có trọng số nhỏ nhất
					Collections.sort(listEdges, new Comparator<Edges>() {
						// so sánh 2 cạnh
						@Override
						public int compare(Edges e1, Edges e2) {
							return e1.getWeight() - e2.getWeight();
						}
					});

					// in ra các cạnh đã sắp xếp
					System.out.println("Cạnh được thêm vào cây của đỉnh: " + (start + 1));
					for (int j = 0; j < listEdges.size(); j++) {
						Edges edge = listEdges.get(0); // lấy cạnh đầu tiên ra (vì đã sắp xếp nên cạnh có trọng số nhỏ
														// nhất sẽ nằm đầu tiên)
						// tiếp theo kiểm tra nó có chu trình k
						if (hasCycle(result, edge.getA(), edge.getB()) == false) {
							// có chu trình thì xoá nó đi or bỏ qua
							// edge = listEdges.remove(0);
							// thêm vào Tree nếu cạnh k tạo chu trình
							result[edge.getA()][edge.getB()] = edge.getWeight();
							result[edge.getB()][edge.getA()] = edge.getWeight();
							System.out.println(
									"(" + (edge.getA() + 1) + ", " + (edge.getB() + 1) + ")" + ": " + edge.getWeight());
							start = edge.getB(); // lấy lại đỉnh duyệt tiếp theo sẽ là đỉnh cuối của cạnh mới thêm vào

							totalWeight += edge.getWeight();
							countEdge++; // đếm số cạnh trong Tree
							break;
							// ngược lại có chu trình
						} else {
							edge = listEdges.remove(0);

						}
					}
				}
			}
			System.out.println("Tổng trọng số nhỏ nhất là: " + totalWeight);

		}
		return result;
	}

	@Override
	public void dijkstra(int start) {
		boolean[] R = new boolean[this.numVex]; // chứa các đỉnh đã xét, đã thăm
		int[] L = new int[this.numVex]; // độ dài đường đi đến đỉnh đó
		int[] P = new int[this.numVex]; // chứa đỉnh liền kề của đỉnh đang xét

		// khởi tạo ban đầu
		for (int i = 0; i < this.numVex; i++) {
			L[i] = Integer.MAX_VALUE; // là vô cùng (k có đường đi)
			P[i] = -1;
			R[i] = false; // gán đều chưa đi
		}

		L[start] = 0; // đưa đỉnh đầu vào thăm
		int countEdge = 0; // đếm số cạnh
		// duyệt tới khi nào (số cạnh==số đỉnh -1)
		while (countEdge < this.numVex - 1) {
			int v = 0; // lấy ra đỉnh có độ dài(trọng số) nhỏ nhất
			// tìm đỉnh có trọng số nhỏ nhất (giống như tìm phần tử nhỏ nhất trong mảng)
			int min = Integer.MAX_VALUE; // ban đầu cho min là lớn nhất
			for (int i = 0; i < this.numVex; i++) {
				if (L[i] < min && R[i] == false) {
					min = L[i]; // trọng số nhỏ nhất
					v = i; // gán lại đỉnh có trọng số nhỏ nhất
				}
			}
			// thuật toán Dijkstra
			// duyệt từ đầu cho đến hết các đỉnh kề của đỉnh v(đỉnh đag xét)
			for (int i = 0; i < this.numVex; i++) {
				// nếu có cạnh và đồ dài của nó < vô cùng và ...
				if (this.arr[v][i] != 0 && this.arr[v][i] < Integer.MAX_VALUE && L[i] > (L[v] + this.arr[v][i])) {
					L[i] = L[v] + this.arr[v][i]; // gán lại đỉnh
					P[i] = v;
				}
			}
			R[v] = true; // gán lại đỉnh đó đã thăm
			countEdge++;

		}
		// in ra đường đi
		for (int i = 0; i < this.numVex; i++) {
			// System.out.println("Đường đi ngắn nhất từ " + (start+1) + " đến " + (i+1) + "
			// là:");
			int destination = i;
			Stack<Integer> stack = new Stack<>();
			stack.push(destination);
			while (start != destination) {
				stack.push(P[destination]);
				destination = P[destination];
			}
			// System.out.print(stack.pop());
			while (!stack.isEmpty()) {
				int v = stack.pop();
				System.out.print(" ==> " + (v + 1));

			}
			System.out.println("\nĐộ dài là: " + L[i]);
		}

	}

	// thuật toán Floyd mở rộng
	int[][] P;

	public int[][] floyd(int[][] arr) {
		P = new int[numVex][numVex];// ma trận đỉnh liền trước
		// Khởi tạo ma trận ban đầu
		int[][] W = this.arr;
		// Thiết lập lại giá trị 0 bằng giá trị vô cùng là 1000 và cho mãng phụ P (path)
		// để chút dùng truy vết đường đi
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (W[i][j] == 0) {
					// nếu k có cạnh thì gán vô cùng (==>9999, bất kì số nào lớn cũng đc)
					W[i][j] = 9999;
				} else {
					// Nếu có cạnh thì khởi tạo P[i][j] = j;
					P[i][j] = j;
				}

			}
		}
		// Chạy thuật toán FLOYD như trong slide
		// k: đỉnh phụ, i: đỉnh đầu, j: đỉnh cuối
		for (int k = 0; k < arr.length; k++) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (W[i][j] > (W[i][k] + W[k][j])) { // nếu giá trị tại hàng i, cột j hiện tại lớn hơn giá trị
															// (W[i][k] + W[k][j])
						W[i][j] = (W[i][k] + W[k][j]); // thì cập nhật lại
						// Gán P để chút hỗ trợ cho việc tìm đường đi
						P[i][j] = P[i][k];
					}
				}
			}
			// Sau mỗi lần cập nhật mảng phụ thì in ra để dể theo dõi
			System.out.println("*** when k = " + k);
			System.out.println("Ma trận W");
			printMatrix(W);

			System.out.println("Ma trận P");
			printMatrix(P);
		}

		return W;
	}

	@Override
	public void dijkstra(int src, int dest, Graph g) {
		boolean[] R = new boolean[this.numVex]; // chứa các đỉnh đã xét, đã thăm
		int[] L = new int[this.numVex]; // độ dài đường đi đến đỉnh đó
		int[] P = new int[this.numVex]; // chứa đỉnh liền kề của đỉnh đang xét

		// khởi tạo ban đầu
		for (int i = 0; i < g.numVex; i++) {
			L[i] = Integer.MAX_VALUE; // là vô cùng (k có đường đi)
			P[i] = -1;
			R[i] = false; // gán đều chưa đi
		}
		L[src] = 0; // đưa đỉnh đầu vào thăm
		int countEdge = 0; // đếm số cạnh
		while (countEdge < g.numVex - 1) {
			int v = 0; // lấy ra đỉnh có độ dài(trọng số) nhỏ nhất
			// tìm đỉnh có trọng số nhỏ nhất (giống như tìm phần tử nhỏ nhất trong mảng)
			int min = Integer.MAX_VALUE; // ban đầu cho min là lớn nhất
			for (int i = 0; i < this.numVex; i++) {
				if (L[i] < min && R[i] == false) { // nếu có phần tử nào nhỏ hơn và chưa thăm
					min = L[i]; // trọng số nhỏ nhất, gán min là phần tử đó
					v = i; // gán lại đỉnh có trọng số nhỏ nhất
				}
			}
			// thuật toán Dijkstra
			// duyệt từ đầu cho đến hết các đỉnh kề của đỉnh v(đỉnh đag xét)
			for (int i = 0; i < g.numVex; i++) {
				// nếu có cạnh và đồ dài của nó < vô cùng và ...
				if (this.arr[v][i] != 0 && this.arr[v][i] < Integer.MAX_VALUE && L[i] > (L[v] + this.arr[v][i])) {
					L[i] = L[v] + this.arr[v][i]; // gán lại đỉnh
					P[i] = v;
				}
			}
			R[v] = true; // gán lại đỉnh đó đã thăm
			countEdge++;
			if (v == dest)
				break;
		}
		// in ra đường đi
		System.out.println("Đường đi ngắn nhất từ: " + (src + 1) + " den " + (dest + 1) + " là: ");
		int destination = dest;
		Stack<Integer> stack = new Stack<>();
		stack.push(destination);
		while (src != destination) {
			stack.push(P[destination]);
			destination = P[destination];
		}
		System.out.print(stack.pop() + 1);
		while (!stack.isEmpty()) {
			int v = stack.pop();
			System.out.print(" ==> " + (v + 1));

		}
		System.out.println("\nĐộ dài là: " + L[dest]);
	}

	// thuật toán Floyd
	@Override
	public int[][] floyd() {
//		P = new int[numVex][numVex];// ma trận đỉnh liền trước
		// Khởi tạo ma trận ban đầu
		int[][] W = this.arr;
		// Thiết lập lại giá trị 0 bằng giá trị vô cùng là 1000 và cho mãng phụ P (path)
		// để chút dùng truy vết đường đi
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (W[i][j] == 0) {
					// nếu k có cạnh thì gán vô cùng (==>9999, bất kì số nào lớn cũng đc)
					W[i][j] = 9999;
				} else {
					// Nếu có cạnh thì khởi tạo P[i][j] = j;
					// P[i][j] = j;
					// P[i][j] = arr[i][j] // lấy trọng số của arr
					W[i][j] = W[i][j];
				}

			}
		}
		// Chạy thuật toán FLOYD như trong slide
		// k: đỉnh phụ, i: đỉnh đầu, j: đỉnh cuối
		for (int k = 0; k < arr.length; k++) {
			for (int i = 0; i < arr.length; i++) { // i dòng
				for (int j = 0; j < arr.length; j++) { // j cột
					if (W[i][j] > (W[i][k] + W[k][j])) { // nếu giá trị tại hàng i, cột j hiện tại lớn hơn giá trị
															// (W[i][k] + W[k][j])
						W[i][j] = (W[i][k] + W[k][j]); // thì cập nhật lại
						// Gán P để chút hỗ trợ cho việc tìm đường đi
						// P[i][j] = P[i][k];
					}
				}
			}
			// Sau mỗi lần cập nhật mảng phụ thì in ra để dể theo dõi
			System.out.println("*** When k = " + k);
			System.out.println("Ma trận W");
			printMatrix(W);

//					System.out.println("Ma trận P");
//					printMatrix(P);
		}

		return W;
	}

	@Override
	// có đường đi(thăm rồi) vẫn cập nhật lại
	public void bellman_Ford(int start) {
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = max;
				}
			}
		}

		// int[][] W = this.arr;
		int[] L = new int[this.numVex]; // L[v] Khoảng cách ngắn nhất từ s đến các đỉnh v
		int[] P = new int[this.numVex]; // chứa đỉnh liền trước của đỉnh đang xét, dùng để lưu đường đi

		// bước 1: khởi tạo ban đầu đồ thị, duyệt tất cả các đỉnh
		// Mỗi đỉnh i, gán nhãn bởi cặp (pre[i], l[i])
		for (int i = 0; i < this.numVex; i++) {
			P[i] = -1; // đỉnh liền trước == null
			if (i == start) {
				L[i] = 0; // nếu đỉnh đưa vào bằng đỉnh i thì cho nó bằng 0
			} else {
				L[i] = max; // ngược lại gán là vô cùng
			}
		}
		// bước 2: kết nạp cạnh, chạy thuật toán
		boolean stop = false;
		int k = 0; // chưa duyệt đỉnh nào
		while (!stop) {
			stop = true;
			k++;
			for (int i = 0; i < this.numVex; i++) {
				for (int j = 0; j < this.numVex; j++) {
					if (arr[i][j] < max && L[i] != max) { // nếu có cạnh
						if (L[j] > L[i] + arr[i][j]) { // nếu khoảng cách j > khoảng cách i + trọng số (i,j)
							L[j] = L[i] + arr[i][j];
							P[j] = i; // gán đỉnh liền trước
							stop = false;
						}
					}
				}
			}
			if (k > this.numVex) {
				if (stop == false) {
					System.out.println("Đồ thị có chu tình âm");
					stop = true;
					break;
				}
			}
		}
		// in ra đường đi
		for (int i = 0; i < this.numVex; i++) {
			System.out.println("Đường đi ngắn nhất từ " + (start + 1) + " đến " + (i + 1) + " là:\n");
			int destination = i;
			Stack<Integer> stack = new Stack<>();
			stack.push(destination);
			while (start != destination) {
				stack.push(P[destination]);
				destination = P[destination];
			}
			// System.out.print(stack.pop());
			while (!stack.isEmpty()) {
				int v = stack.pop();
				System.out.print(" ==> " + (v + 1));
			}
			System.out.println("\nĐộ dài là: " + L[i]);
		}

	}

	@Override
	public int[][] warshall() {
		int[][] R = new int[this.numVex][this.numVex]; // output: ma trận khả liên của G
		R = this.arr; // ma trận trọng số, kề
		// R = A;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (R[i][j] == 0) {
					// nếu k có cạnh thì gán vô cùng (==>9999, bất kì số nào lớn cũng đc)
					R[i][j] = 0;
				} else {
					// Nếu có cạnh thì khởi tạo P[i][j] = j;
					// P[i][j] = j;
					// P[i][j] = arr[i][j] // lấy trọng số của arr
					R[i][j] = 1;
				}

			}
		}

		for (int k = 0; k < arr.length; k++) {
			for (int i = 0; i < arr.length; i++) { // i dòng
				if (R[i][k] > 0) {
					for (int j = 0; j < arr.length; j++) { // j cột
						// R[i][j] = R[i][j] || (R[i][k] && R[k][j]);
						if (R[k][j] > 0) {
							R[i][j] = 1;
						}
					}
				}
			}
			// Sau mỗi lần cập nhật mảng phụ thì in ra để dể theo dõi
			System.out.println("*** When k = " + (k + 1));
			System.out.println("Ma trận R");
			printMatrix(R);
		}
		return R;
	}

}
