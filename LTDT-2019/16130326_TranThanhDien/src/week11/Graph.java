package week11;

public abstract class Graph {
	public int[][] arr; // ma trận kề
	public int numVex; // số đỉnh của đồ thị
	public boolean[] visited; // thăm đỉnh kề hay chưa, ds đỉnh đã thăm
	public int[] path; // kích thước bằng số đỉnh

	public Graph(int v) {
		this.numVex = v;
		this.arr = new int[numVex][numVex]; // tạo ma trận kề
		visited = new boolean[numVex]; // mảng có size == dỉnh đồ thị
		path = new int[numVex];
	}

	public int getNumVex() {
		return numVex;
	}

	public void setNumVex(int numVex) {
		this.numVex = numVex;
	}

	// in ra ma trận kề
	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	// in ra Graph
	public void printGraph(Graph graph) {
		for (int i = 0; i < graph.numVex; i++) {
			for (int j = 0; j < graph.arr[i].length; j++) {
				System.out.print(graph.arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	

	// thêm một cạnh
	public abstract void addEdges(int src, int dest);

	// xoá một cạnh
	public abstract void delEdges(int src, int dest);

	// tính bậc của 1 đỉnh bất kì
	public abstract int degree(int src);

	// số cạnh của đồ thị
	public abstract int numberEdgeGraph();

	// *****************************************************

	// tuần 2
	// kiểm tra tính liên thông
	public abstract boolean isConnected();

	// duyệt theo chiều sâu(DFS)
	public abstract void DFS(int vexStart);

	// đếm thành phần liên thông
	public abstract int countConnected();

	// kiểm tra đồ thị phải là đồ thị con hay k?
	public abstract boolean isSubGraph(Graph g1, Graph g2);

	// tìm thành phần liên thông
	public abstract void findConnection();

	// kiểm tra lưỡng phân(giải thuật tô màu)
	public abstract boolean isBir();

	// tuần 3
	// DFS==>Stack
	public abstract void DFS_Stack(int start);

	// BFS==>Queue
	public abstract void BFS_Queue(int start);

	// findPathLong
	public abstract void findPathLong(int src, int dest);

	// findPathShortest
	public abstract void findPathShortest(int src, int dest);

	// tuần 4
	// kiểm tra có chu trình Euler ko
	public abstract boolean checkCycleEuler();

	// kiểm tra có đường đi Euler ko
	public abstract boolean checkEulerPath();

	// tìm chu trình Euler
	public abstract void findCycleEuler(int start);

	// tìm đường đi Euler
	public abstract void findPathEuler(int start);

	// tuần 5
	// kiểm tra có chu trình Hamilton ko
	public abstract boolean checkCycleHamilton();

	// kiểm tra có đường đi Hamilton k
	public abstract boolean checkPathHamilton();

	// in ra chu trình Hamilton tại 1 đỉnh
	public abstract void findCycleHamiltonAll(int start);

	// in ra tất cả chu trình Hamilton
	public abstract void findCycleHamiltonAll();

	// tuần 6
	// in ra tất cả đường đi Hamilton
	public abstract void allPathHamilton();

	// in ra tất cả đường đi Hamilton bắt đầu từ 1 đỉnh
	public abstract void allPathHamilton(int start);

	// in ra 1 chu trình Hamilton từ 1 đỉnh
	// public abstract void findACycleHamilton(int start);

	// tuần 7
	public abstract int[][] dfsTree(int start);

	public abstract Graph dfsTree_Graph(int start);

	public abstract int[][] bfsTree(int start);

	public abstract Graph bfsTree_Graph(int start);
	
	// tuần 8
	public abstract int[][] kruskalTree();
	public abstract int[][] primTree(int[][] tree, int start);
	
	// tuần 9
	public abstract void dijkstra(int start);
	
	// tuần 10
	public abstract void dijkstra(int src, int dest, Graph g);
	public abstract int[][] floyd();
	// tuần 11
	public abstract void bellman_Ford(int start);
	public abstract int[][] warshall();
}
