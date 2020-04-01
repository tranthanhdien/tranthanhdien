package week11;

public class TestUnGraphWeek9 {
	public static void main(String[] args) {
		// UnGraph1 cho Dijkstra
		UnGraph unGraph1 = new UnGraph(7);
		unGraph1.addEdge(0, 1, 8);
		unGraph1.addEdge(1, 2, 1);
		unGraph1.addEdge(1, 3, 4);
		unGraph1.addEdge(2, 4, 5);
		unGraph1.addEdge(3, 5, 3);
		unGraph1.addEdge(4, 5, 6);
		unGraph1.addEdge(4, 6, 3);
		unGraph1.addEdge(5, 6, 2);
		System.out.println("Ma trận của đồ thị: ");
		unGraph1.printMatrix(unGraph1.arr);
		System.out.println("Thuật toán Dijkstra: ");
		unGraph1.dijkstra(0);
		System.out.println("Thuật toán Floyd: ");
		unGraph1.floyd();
		System.out.println("Thuật toán Floyd mở rộng: ");
		unGraph1.floyd(unGraph1.arr);
		
		
		//unGraph1.findWayXtoY_UsingFloyd(0, 5);
	}

}
