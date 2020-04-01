package week11;

public class TestUnGraphWeek10 {

	public static void main(String[] args) {
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
		System.out.println("***************************");
		unGraph1.dijkstra(0, 3, unGraph1);
	}

}
