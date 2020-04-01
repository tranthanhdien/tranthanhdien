package week11;

public class TestDiGraphWeek6 {
	public static void main(String[] args) {
		DiGraph diGraph1 = new DiGraph(5);
		diGraph1.addEdges(0, 1);
		diGraph1.addEdges(0, 3);
		diGraph1.addEdges(0, 4);
		diGraph1.addEdges(2, 1);
		diGraph1.addEdges(2, 3);
		diGraph1.addEdges(2, 4);
		diGraph1.addEdges(3, 2);
		diGraph1.addEdges(3, 4);
		diGraph1.addEdges(4, 1);
		System.out.println("Ma trận kề của đồ thị có hướng: ");
		diGraph1.printMatrix(diGraph1.arr);
		diGraph1.allPathHamilton(); // 1 4 3 5 2
		diGraph1.allPathHamilton(0);

	}
}
