package week11;

public class TestDiGraphWeek11 {

	public static void main(String[] args) {
		DiGraph diGraph = new DiGraph(5);
		diGraph.addEdges(0, 1);
		diGraph.addEdges(1, 2);
		diGraph.addEdges(2, 0);
		diGraph.addEdges(2, 3);
		diGraph.addEdges(4, 0);
		diGraph.addEdges(4, 2);
		System.out.println("Ma trận của đồ thị: ");
		diGraph.printMatrix(diGraph.arr);
		diGraph.warshall();
		
		
		DiGraph diGraph1 = new DiGraph(8);
		diGraph1.addEdge(0, 1, 4);
		diGraph1.addEdge(0, 2, 7);
		diGraph1.addEdge(0, 3, 1);
		diGraph1.addEdge(1, 2, 2);
		diGraph1.addEdge(2, 4, 2);
		diGraph1.addEdge(2, 7, 3);
		diGraph1.addEdge(2, 5, 2);
		diGraph1.addEdge(3, 1, 2);
		diGraph1.addEdge(3, 4, 4);
		diGraph1.addEdge(3, 7, 8);
		diGraph1.addEdge(4, 1, 5);
		diGraph1.addEdge(4, 3, 3);
		diGraph1.addEdge(5, 2, 1);
		diGraph1.addEdge(5, 7, 1);
		diGraph1.addEdge(6, 4, 2);
		diGraph1.addEdge(6, 7, 2);
		
		System.out.println("Ma trận của đồ thị: ");
		diGraph1.printMatrix(diGraph1.arr);
		diGraph1.bellman_Ford(0);		
		

	}

}
