package week11;

public class TestUnGraphWeek11 {

	public static void main(String[] args) {
		UnGraph unGraph1 = new UnGraph(6);
		unGraph1.addEdge(0, 1, 3);
		unGraph1.addEdge(0, 2, 2);
		unGraph1.addEdge(0, 3, 5);
		unGraph1.addEdge(1, 3, 1);
		unGraph1.addEdge(1, 4, 4);
		unGraph1.addEdge(2, 3, 2);
		unGraph1.addEdge(2, 5, 1);
		unGraph1.addEdge(3, 4, 3);
		unGraph1.addEdge(4, 5, 2);
		System.out.println("Ma trận của đồ thị: ");
		unGraph1.printMatrix(unGraph1.arr);
		System.out.println("Thuật toán Bellman_Ford");
		unGraph1.bellman_Ford(5);
		UnGraph unGraph2 = new UnGraph(6);
		unGraph2.addEdge(0, 1, 7);
		unGraph2.addEdge(0, 3, 8);
		unGraph2.addEdge(1, 2, 4);
		unGraph2.addEdge(1, 4, 2);
		unGraph2.addEdge(1, 5, 1);
		unGraph2.addEdge(3, 1, 2);
		unGraph2.addEdge(3, 4, 2);
		unGraph2.addEdge(4, 5, 3);
		unGraph2.addEdge(5, 2, 2);
		unGraph2.addEdge(5, 3, -6);
		System.out.println("Ma trận của đồ thị: ");
		unGraph2.printMatrix(unGraph2.arr);
		//unGraph2.bellman_Ford(0);
		
		
	}

}
