package week11;

public class TestDiGraphWeek9 {
	public static void main(String[] args) {
		DiGraph diGraph = new DiGraph(6);
		diGraph.addEdge(0, 1, 4);
		diGraph.addEdge(0, 2, 7);
		diGraph.addEdge(0, 3, 1);
		diGraph.addEdge(1, 2, 2);
		diGraph.addEdge(2, 5, 3);
		diGraph.addEdge(2, 4, 2);
		diGraph.addEdge(3, 1, 2);
		diGraph.addEdge(3, 4, 4);
		diGraph.addEdge(4, 1, 100);
		diGraph.addEdge(4, 3, 3);
		diGraph.addEdge(5, 4, 1);
		System.out.println("Ma trận của đồ thị: ");
		diGraph.printMatrix(diGraph.arr);
		System.out.println("Thuật toán Dijkstra: ");
		diGraph.dijkstra(0);
		System.out.println("Thuật toán FLOYD: ");
		diGraph.floyd(diGraph.arr);
	}

}
