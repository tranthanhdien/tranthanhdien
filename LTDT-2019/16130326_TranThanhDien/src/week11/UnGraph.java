package week11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// undirected graph
public class UnGraph extends Graph {

	public UnGraph(int v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

	// thêm cạnh
	@Override
	public void addEdges(int src, int dest) {
		if (src >= 0 && src < this.numVex && dest >= 0 && dest < this.numVex) {
			this.arr[src][dest] = 1; // đồ thị vô hướng nên thêm 2 chiều
			this.arr[dest][src] = 1;
		}
	}

	// xoá cạnh
	@Override
	public void delEdges(int src, int dest) {
		if (src >= 0 && src < this.numVex && dest >= 0 && dest < this.numVex) {
			this.arr[src][dest] = 0; // đồ thị vô hướng nên xoá 2 chiều
			this.arr[dest][src] = 0;
		}
	}

	// in số bậc tất cả đỉnh của đồ thị vô hướng
	public String printDegree() {
		String result = "";
		int total = 0;
		for (int i = 0; i < this.arr.length; i++) {
			result += "Đỉnh " + (i + 1) + " có bậc là: " + degree(i) + "\n";
			total += degree(i);
		}
		return result + "==>Tổng bậc: " + total;
	}

	// bậc của đồ thị vô hướng tại 1 đỉnh
	@Override
	public int degree(int src) {
		int sum = 0;
		if (src >= 0 && src <= this.numVex) {
			for (int i = 0; i < this.arr.length; i++) { // duyệt hết tất cả các đỉnh
				sum += this.arr[i][src]; // cột trước hàng sau
			}
		}
		return sum;
	}

	// tổng số bậc của đồ thị vô hướng
	public int totalDegree() {
		int total = 0;
		for (int i = 0; i < this.arr.length; i++) {
			total += degree(i);
		}
		return total;
	}

	// số cạnh của đồ thị vô hướng
	@Override
	public int numberEdgeGraph() {
		return totalDegree() / 2;
	}

	// tuần 2***********************************************************************
	// kiểm tra tính liên thông(dùng DFS)
	@Override
	public boolean isConnected() {
		DFS(0); // xét từ đỉnh đầu tiên
		for (int i = 0; i < arr.length; i++) { // duyệt tất cả các đỉnh
			if (visited[i] == false) { // nếu 1 đỉnh nào đó chưa thăm thì k liên thông
				return false;
			}
		}
		return true;
	}

	// duyệt đồ thị theo chiều sâu (đệ quy)
	@Override
	public void DFS(int vexStart) {
		visited[vexStart] = true; // thăm đỉnh đầu tiên, đánh dấu đã thăm
		// System.out.print(vexStart + 1 + "==>");
		for (int i = 0; i < arr.length; i++) {
			if (arr[vexStart][i] != 0 && visited[i] == false) { // nếu có cạnh và chưa thăm
				DFS(i); // gọi đệ quy (đưa đỉnh i vào thăm tiếp theo)
			}
		}

	}

	// đếm thành phần liên thông
	@Override
	public int countConnected() {
		int count = 1;
		DFS(0); // gọi hàm DFS để duyệt đồ thị
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false) { // nếu có đỉnh nào chưa thăm
				DFS(i); // tiếp tục gọi lại để thăm đỉnh đó
				count++; // tăng count lên 1
			}
		}
		return count;
	}

	// kiểm tra đồ thị g1 có phải là con của g2 không?
	// ý tưởng: nếu số cạnh trong l2 mà chứa số cạnh trong l1 (l1 thuộc trong l2)
	// thì là đồ thị con
	@Override
	public boolean isSubGraph(Graph g1, Graph g2) {
		ArrayList<Edges> l1 = new ArrayList<>(); // list cạnh đồ thị 1
		ArrayList<Edges> l2 = new ArrayList<>(); // list cạnh đồ thị 2
		// nếu số đỉnh hợp lệ (đỉnh g1 phải nhỏ hơn đỉnh g2) ==> xét cạnh
		if (g1.numVex <= g2.numVex) {
			// xét cạnh cho Graph1
			// duyệt tất cả các đỉnh
			for (int i = 0; i < g1.numVex; i++) {
				for (int j = 0; j < g1.numVex; j++) {
					if (g1.arr[i][j] != 0) { // nếu có cạnh
						l1.add(new Edges(i, j)); // thêm vào list cho Graph1
					}
				}
			}
			// xét cạnh cho Graph2
			// duyệt tất cả các đỉnh
			for (int i = 0; i < g2.numVex; i++) {
				for (int j = 0; j < g2.numVex; j++) {
					if (g2.arr[i][j] != 0) { // nếu có cạnh
						l2.add(new Edges(i, j)); // thêm vào list cho Graph2

					}
				}
			}
			System.out.println(l1.toString()); // in list Graph1
			System.out.println(l2.toString()); // in list Graph2
			// kiểm tra các cạnh trong l2 có chứa các cạnh trong l1 không?
			int count = 0; // là số cạnh l2 chứa l1 (l1 thuộc l2)
			for (int i = 0; i < l1.size(); i++) {
				for (int j = 0; j < l2.size(); j++) {
					if (l1.get(i).toString().equalsIgnoreCase(l2.get(j).toString())) {
						count++; // nếu có thì tăng lên 1
					}
				}
			}
			if (count == l1.size()) { // nếu số cạnh mà l2 chứa trong l1 = số cạnh l1
				return true; // ==> g1 là đồ thị con của g2
			} else {
				return false; // ==> g1 k phải là đồ thị con của g2
			}
		}
		// ngược lại số đỉnh của đồ thị g1 >= g2
		return false; // trả về false (g1 không phải là con của g2)

	}

	// tìm thành phần liên thông
	@Override
	public void findConnection() {
//		ArrayList<Integer> vex = new ArrayList<>();
//		for (int i = 1; i <= numVex; i++) {
//			vex.add(i);
//		}
//		int count = 0;
//		visited = new boolean[numVex];
//		while (vex.size() != 0) {
//			count++;
//			System.out.println("thanh phan lien thong thu: " + count);
//			System.out.println(DFS(vex.get(0)));
//			vex.removeAll(vexVisited);
//		}
//		System.out.println("so thanh phan lien thong cua do thi: " + count);
	}

	// kiểm tra đồ thị lưỡng phân (hay đồ thị 2 phía)
	@Override
	public boolean isBir() {
		int[] colorArr = new int[numVex]; // biến màu, mảng màu = số đỉnh đồ thị
		// bước 1: duyệt mảng màu
		// -1: không có màu, 1: màu đầu tiên, 0: màu thứ 2
		for (int i = 0; i < colorArr.length; i++) {
			colorArr[i] = -1; // ban đâu cho tất cả là k có màu
		}
		// bước 2: thực hiện tô màu
		for (int i = 0; i < colorArr.length; i++) {
			for (int j = 0; j < colorArr.length; j++) {
				if (arr[i][j] != 0 && colorArr[j] == -1) { // nếu có đỉnh và ko có màu
					if (colorArr[i] == 1) { // nếu i là 1
						colorArr[j] = 0; // thì j là 0
					} else { // ngược lại i ko phải là 1 (0 or -1)
						colorArr[j] = 1; // gán j là 1
					}

				}
			}
		}
		// bước 3: kiểm tra
		// duyệt tất cả đồ thị
		for (int i = 0; i < colorArr.length; i++) {
			for (int j = 0; j < colorArr.length; j++) {
				if (arr[i][j] != 0 && colorArr[i] == colorArr[j]) { // nếu có cạnh và 2 màu như nhau
					return false; // ==> k lưỡng phân
				}
			}
		}
		return true;

	}

	// duyệt DFS (dùng Stack)
	@Override
	public void DFS_Stack(int start) {
		Stack<Integer> stack = new Stack<>(); // khỏi tạo Stack
		ArrayList<Integer> list = new ArrayList<>(); // list các đỉnh
		stack.push(start); // đưa vào Stack
		list.add(start); // đưa vào list
		visited[start] = true; // gán đỉnh đầu đã thăm
		while (!stack.isEmpty()) { // duyệt tới khi nào stack rỗng
			int k;
			int count = 0; // để đếm số đỉnh đã thăm
			k = stack.peek();// Lấy k ra khỏi Stack, lấy nhưng k xoá
			for (int i = 0; i < this.numVex; i++) { // duyệt các đỉnh
				if ((this.arr[k][i] != 0) && visited[i] == false) { // nếu có cạnh và chưa thăm
					stack.push(i); // đưa đỉnh kề i chưa xét vào Stack để xét
					list.add(i); // thêm đỉnh kề i vào list
					visited[i] = true; // sau đó đánh dấu đã duyệt đỉnh i
					break; // tìm được đỉnh đầu tiên thì break liền
				} else { // k có đỉnh kề hoặc thăm rồi
					count++; // tăng lên 1
				}
			}
			if (count == visited.length) { // nếu đi qua tất cả các đỉnh thì xoá Stack
				stack.pop(); // ==> Stack rỗng, kết thúc vòng lập
			}
		}
		// duyệt các đỉnh trong list và in ra
		for (int e : list) {
			System.out.print((e + 1) + "\t");
		}
	}

	// duyệt BFS (dùng Queue)
	@Override
	public void BFS_Queue(int start) {
		Queue<Integer> queue = new LinkedList<Integer>(); // khởi tạo Queue
		queue.add(start); // thêm vào queue
		visited[start] = true; // đánh dấu đỉnh bắt đầu là đã thăm
		while (!queue.isEmpty()) { // duyệt tới khi nào queue rỗng
			start = queue.poll(); // lấy ra và loại bỏ nó (lấy đứa đầu hàng đợi)
			System.out.print((start + 1) + "\t"); // in ra đỉnh vừa thăm
			for (int i = 0; i < arr.length; i++) { // duyệt các đỉnh
				if (arr[start][i] != 0 && visited[i] == false) { // nếu có cạnh và chưa thăm
					visited[i] = true; // đánh dấu là đã thăm
					queue.add(i); // thêm vào queue
				}
			}
		}

	}

	String s = ""; // để in ra đường đi
	// tìm đường đi từ 1 đỉnh đến 1 đỉnh

	@Override
	public void findPathLong(int src, int dest) {
		visited[src] = true; // đánh dấu đỉnh đầu là đã thăm
		for (int i = 0; i < this.numVex; i++) { // duyệt tất cả các đỉnh
			if (arr[src][i] != 0 && visited[i] == false) { // nếu có canh và chưa thăm
				visited[i] = true; // đánh dấu lại đỉnh đó là đã thăm
				s += (src + 1) + "==>";
				if (i == dest) { // nếu đỉnh đó = đỉnh đích (tới đi)
					s += i + 1; // nếu như tới đích
					System.out.println(s);
					break;
				} else // ngược lại chưa tới đích
					findPathLong(i, dest); // chạy lại, gán đỉnh đầu sẽ bằng đỉnh vừa duyệt i
			}
		}
	}

	// tìm đường đi ngắn nhất từ 1 đỉnh tới 1 đỉnh
	// Đối với trường hợp rất nhiều Node ==> dùng BFS(Queue)
	@Override
	public void findPathShortest(int src, int dest) {
		Queue<Integer> queue = new LinkedList<>(); // khởi tạo Queue
		queue.add(src); // đưa đỉnh đầu vào queue
		visited[src] = true; // đánh dấu đỉnh đầu đã thăm
		ArrayList<Integer> list = new ArrayList<>(); // list để lát in đường đi
		list.add(src); // tương tự cũng thêm đỉnh đầu vào list

		while (!queue.isEmpty()) { // duyệt tới khi nào queue rỗng
			src = queue.poll(); // lấy ra và loại bỏ nó (lấy đứa đầu hàng đợi)
			System.out.print((src + 1) + "\t");
			if (src == dest) // nếu đầu = cuối ==> break liền
				break;
			// ngược lại duyệt tất cả các đỉnh
			for (int i = 0; i < this.numVex; i++) {
				if (arr[src][i] != 0 && visited[i] == false) { // nếu có cạnh và chưa thăm
					list.add(i); // thêm vào list
					visited[i] = true; // đánh dấu đỉnh đó đã thăm
					queue.add(i); // thêm đỉnh i vào queue
				}
			}
		}
	}

	// Week4: *****************************************************
	// ktra chu trình Euler
	// G liên thông, tất cả các đỉnh bậc chẵn
	@Override
	public boolean checkCycleEuler() {
		int count = 0;
		// nếu liên thông và đỉnh > 1
		if (isConnected() == true && this.numVex > 1) {
			for (int i = 0; i < arr.length; i++) { // duyệt tất cả các đỉnh
				if (degree(i) % 2 == 0) { // kiểm tra xem nếu bậc của đỉnh nào là chẵn
					count++; // tăng count lên
				}
				if (count == this.numVex) { // tất cả đều bậc chẵn
					return true;
				}
			}
		}
		return false;

	}

	// kiểm tra đường đi Euler
	// G liên thông, có đúng 2 đỉnh bậc lẻ
	@Override
	public boolean checkEulerPath() {
		int count = 0;
		if (isConnected() == true && this.numVex > 1) {
			for (int i = 0; i < arr.length; i++) { // duyệt tất cả các đỉnh
				if (degree(i) % 2 != 0) { // kiểm tra xem nếu bậc của đỉnh nào là lẻ
					count++; // tăng count lên
				}
			}
			if (count == 2) { // đúng 2 đỉnh bậc lẻ
				return true;
			}
		}
		return false;
	}

	// tìm chu trình Euler
	@Override
	public void findCycleEuler(int start) {
		if (checkCycleEuler() == false) {
			System.out.println("Không có chu trình Euler");
		} else {
			// tạo ma trận mới chứa kích thước ma trận cũ
			// int[][] c;
			Stack<Integer> stack = new Stack<>(); // khởi tạo Stack
			ArrayList<Integer> list = new ArrayList<>(); // lưu các đỉnh đã duyệt
			stack.push(start); // đưa đỉnh đầu vào stack
			list.add(start); // tương tự thêm vào list để lát in ra
			while (!stack.isEmpty()) {
				int x = stack.pop(); // lấy ra
				for (int i = 0; i < arr.length; i++) { // duyệt tất cả các đỉnh
					if (arr[x][i] != 0) { // nếu có cạnh
						stack.add(i); // thêm vào stack
						list.add(i); // thêm vào list
						// Euler chỉ qua mỗi cạnh 1 lần
						arr[x][i] = arr[i][x] = 0; // sau khi thêm vào thì xoá đi (vì đối xứng nên arr[x][i] = arr[i][x]
						x = i; // cho đỉnh duyệt tiếp theo == i
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

	// tìm đường đi Euler (bắt đầu đỉnh bậc lẻ và kết thúc bậc lẻ)
	// đầu tiên xét đỉnh người dùng đưa vào là chẵn hay lẽ
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
					arr[x][i] = arr[i][x] = 0; // sau khi thêm vào thì xoá đi (vì đối xứng nên arr[x][i] = arr[i][x]
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
	// chu trình Hamilton
	// đỉnh >=3, bậc của tất cả đỉnh >= đỉnh/2
	// nó chỉ phù hợp với đơn đồ thị (ko có khuyên và cạnh //)
	@Override
	public boolean checkCycleHamilton() {
		int count = 0;
		if (this.numVex < 3 || !isConnected()) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (degree(i) >= this.numVex / 2) {
				count++;
			}
		}
		if (count == this.numVex) {
			return true;
		}
		return false;

	}

	// đường đi Hamilton
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
			if (degree(i) >= (this.numVex - 1) / 2) { // đếm đỉnh >=(n-1)/2
				count2++;
			}
			if (degree(i) <= (this.numVex - 1) / 2) { // đếm đỉnh <=(n-1)/2
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

	// in ra 1 chu trình Hamilton từ 1 đỉnh
	public void aCycleHamilton(int anyVex) {
		if (checkCycleHamilton()) {
			System.out.print("Một chu trình Hamilton bắt đầu từ đỉnh " + anyVex + " là: ");
			for (int i = 0; i < this.numVex; i++) {
				visited[i] = false; // khởi tạo là chưa thăm
			}
			path[0] = anyVex;
			visited[anyVex] = true;
			expand(1);
		} else {
			System.out
					.println("In ra 1 chu trình Hamilton bắt đầu từ " + anyVex + " là: không tìm thấy chu trình nào");
		}
	}
	
	// in ra tất cả các chu trình Hamilton
	@Override
	public void findCycleHamiltonAll() {
		if (checkCycleHamilton()) {
			System.out.println("Tất cả chu trình Hamilton: ");
			for (int i = 0; i < numVex; i++) {
				visited[i] = false; // gán tất cả chưa thăm
			}
			path[0] = 0;
			visited[0] = true;
			expand(1);
		} else {
			System.out.println("Đồ thị không có chu trình Hamilton!");
		}
	}

	public void expand(int i) { // áp dụng thuật toán quay lui và theo chiều sâu
		for (int j = 0; j < this.numVex; j++) {
			if (visited[j] == false && this.arr[path[i - 1]][j] > 0) {
				path[i] = j; // cập nhật lại đường đi
				if (i < this.numVex - 1) { // nếu i < đỉnh cuối cùng
					visited[j] = true;
					expand(i + 1);
					visited[j] = false; // quay lui, để kiểm tra đường tiếp theo
				} else { // i tới đỉnh cuối cùng (i=numVex-1)
					if (this.arr[path[i]][0] > 0) { // có cạnh
						printHamiltonCycle(path);
						System.out.print(path[0] + 1);
						System.out.println();
					}
				}
			}
		}
	}

	private void printHamiltonCycle(int[] path) { // path dùng để lưu đường đi
		String result = "";
		for (int i = 0; i < path.length; i++) {
			result += path[i] + 1 + "\t";
		}
		System.out.print(result);
	}

	// week6
	// in ra tất cả chu trình Hamilton tại 1 đỉnh bất kì
	@Override
	public void findCycleHamiltonAll(int start) {
		if (checkCycleHamilton()) {
			System.out.println("Chu trình Hamilton bắt đầu từ đỉnh " + (start + 1));
			for (int i = 0; i < this.numVex; i++) {
				visited[i] = false;
			}
			path[0] = start;
			visited[start] = true;
			expand(1);
		} else {
			System.out.println("Đồ thị không có chu trình Hamilton!");
		}
	}

	// tìm tất cả đường đi Hamilton của đồ thị
	@Override
	public void allPathHamilton() {
		if (checkEulerPath()) {
			System.out.println("Tất cả đường đi Hamilton!");
			for (int i = 0; i < numVex; i++) {
				visited[i] = false;
			}
			int v = 3 - 1;

			path[0] = v;
			visited[v] = true;
			expandPath(1);
		} else {
			System.out.println("Đồ thị không có đường đi Hamilton!");
		}
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

	// in ra đường đi Hamilton
	private void printHamiltonPath(int[] path) {
		for (int i = 0; i < path.length; i++) {
			System.out.print((path[i] + 1) + "\t");
		}

	}

	// tất cả đường đi Hamilton từ 1 đỉnh bất kì
	@Override
	public void allPathHamilton(int start) {
		if (checkEulerPath()) {
			System.out.println("Tất cả đường đi từ đỉnh " + (start + 1));
			for (int i = 0; i < numVex; i++) {
				visited[i] = false;
			}
			path[0] = start;
			visited[start] = true;
			expandPath(1);
		} else {
			System.out.println("Đồ thị không có đường đi Hamilton!");
		}

	}

	// Tìm cây bao trùm dùng DFS ==> [][]
	@Override
	public int[][] dfsTree(int start) {
		int[][] result = new int[arr.length][arr.length];
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		// gán đỉnh bắt đầu đã đc thăm
		visited[start] = true;
		// thêm đỉnh bắt đầu vào
		stack.push(start);
		list.add(start);
		System.out.println("Cây bào trùm (DFS):");
		while (!stack.isEmpty()) {
			int i = stack.peek(); // lấy phần tử trên cùng nhưng k xoá
			int count = 0;
			for (int j = 0; j < visited.length; j++) {
				if (arr[i][j] > 0 && visited[j] == false) {
					// thêm tập cạnh
					result[i][j] = 1;
					result[j][i] = 1;
					// thêm j vào tập đỉnh để xét
					stack.push(j);
					visited[j] = true;
					// thêm j vào tập đỉnh trả về
					list.add(j);
					break;
				} else {
					count++;
				}
			}
			// nếu thăm hết các đỉnh thì xoá đi
			if (count == visited.length) {
				stack.pop();
			}
//			if (list.size() == arr.length) {
//				printTree(list);
//				// return result;
//				break;
//
//			}
		}
		return result;
	}

	public void printTree(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			// System.out.print(list.get(i) + 1 + "\t");
		}

	}

	// Tìm cây bao trùm dùng DFS ==> Graph (khử đệ quy)
	public Graph dfsTree_Graph(int start) {
		Graph graph = new UnGraph(this.numVex);
		graph.arr = dfsTree(start);
		return graph;
	}

	// Tìm cây bao trùm dùng DFS (đệ quy) ==> int[][]
	int[][] result = new int[this.numVex][this.numVex];

	public int[][] dfs_Recursive(int start) {
		visited[start] = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[start][i] != 0 && visited[i] == false) {
				visited[i] = true;
				result[start][i] = 1; // vô hướng nên add 2 chiều
				result[i][start] = 1;

				dfs_Recursive(i);
			}
		}

		return result;

	}

	// Tìm cây bao trùm dùng DFS đệ quy ==> Graph
	public Graph dfs_Recu(int start) {
		Graph graph = new UnGraph(this.numVex);
		graph.arr = dfs_Recursive(start);
		return graph;
	}

	// Tìm cây bao trùm dùng BFS ==> [][]
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
					tree[i][v] = 1; // vô hướng nên add 2 chiều
					tree[v][i] = 1;
					queue.add(i);
				}
			}
		}
		return tree;
	}

	// Tìm cây bao trùm dùng BFS ==> Graph
	public Graph bfsTree_Graph(int start) {
		Graph graph = new UnGraph(this.numVex);
		graph.arr = bfsTree(start);
		return graph;
	}

	// tuần 7 **********************
	// thêm cạnh có trọng số
	public void addEdge(int src, int dest, int weight) {
		if (src >= 0 && src < this.numVex && dest >= 0 && dest < this.numVex) {
			this.arr[src][dest] = weight;
			this.arr[dest][src] = weight;
			// nếu remove thì bằng 0
		}
	}

	// Kruskal ==> tìm cây bao trùm
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
	public int[][] primTree(int[][] tree, int start) {
		int[][] result = new int[tree.length][tree.length];
		int totalWeight = 0; // tổng trọng số
		List<Edges> listEdges = new ArrayList<>(); // list cạnh
		int countEdge = 0; // đếm số cạnh
		visited = new boolean[tree.length];
		// cho tất cả chưa thăm
		for (int i = 0; i < this.numVex; i++) {
			visited[i] = false;
		}
		// đưa đỉnh đầu tiên vào thăm
		visited[start] = true;
		// chạy đến khi nào Tree đủ (n-1) cạnh thì dừng, ngược lại chạy tiếp
		while (countEdge < tree.length - 1) {
			for (int i = 0; i < visited.length; i++) {
				if (tree[start][i] > 0 && visited[i] == false) { // nếu có cạnh và chưa thăm
					// thêm vào list cạnh
					listEdges.add(new Edges(start, i, tree[start][i])); // thêm cạnh, có trọng số
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

	// thuật toán Dijkstra
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

	// tuần 10
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

	// Thuật toán Floyd mở rộng
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
					// P[i][j] = arr[i][j] // lấy trọng số của arr
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

	// tim duong di tu X toi Y using Floy

	public void findWayXtoY_UsingFloyd(int src, int des) {
		// Gọi phương thức floyd thuần để lấy được mãng P và W
		int[][] W = floyd(arr);

		// Đây mới là bước tìm đường đi
		// i, P*[i,j],P*[P*[i,j],j], P*[P*[P*[i,j],j],j],j],…,j
		// Dựa vào công thức trên ta dùng vòng lập để lấy ra đường đi add vào list
		ArrayList<Integer> list = new ArrayList<>();

		int path = src;
		list.add(path);
		while (path != des) {
			path = P[path][des];
			list.add(path);
		}

		System.out.println("Ma trận đường đi sau khi dùng FLOYD: ");
		printMatrix(P);
		// In đường đi
		System.out.println("Đường đi từ đỉnh " + src + " đến " + des + " la ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");

		}
		System.out.println("Trọng số: " + W[src][des]);

		// return list;
	}

	// thuật toán Floyd ==> int[][]
	@Override
	public int[][] floyd() {
		// P = new int[numVex][numVex];// ma trận đỉnh liền trước
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

//				System.out.println("Ma trận P");
//				printMatrix(P);
		}

		return W;
	}

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
			System.out.println("*** When k = " + k);
			System.out.println("Ma trận R");
			printMatrix(R);
		}
		return R;
	}

}
