package week11;

public class TestDiGraphWeek8 {
	public static void main(String[] args) {
		DiGraph diGraph1 = new DiGraph(6);
		diGraph1.addEdge(0, 3, 2);
		diGraph1.addEdge(0, 1, 7);
		diGraph1.addEdge(1, 2, 4);
		diGraph1.addEdge(1, 4, 1);
		diGraph1.addEdge(2, 5, 3);
		diGraph1.addEdge(3, 1, 4);
		diGraph1.addEdge(4, 0, 2);
		diGraph1.addEdge(4, 2, 2);
		diGraph1.addEdge(5, 1, 1);
		System.out.println("Ma trận đồ thị: ");
		diGraph1.printMatrix(diGraph1.arr);
		diGraph1.printMatrix(diGraph1.kruskalTree()); // thuật toán y chang vô hướng
		diGraph1.printMatrix(diGraph1.primTree(diGraph1.arr, 5));
		//diGraph1.printMatrix(diGraph1.primTree1(diGraph1.arr, 0));
		
	}
}
