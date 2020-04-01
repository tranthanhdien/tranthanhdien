package week11;

public class TestDiGraphWeek5 {
	public static void main(String[] args) {
		DiGraph diGraph1 = new DiGraph(5);
		diGraph1.addEdges(0, 1);
		diGraph1.addEdges(0, 2);
		diGraph1.addEdges(0, 3);
		diGraph1.addEdges(1, 2);
		diGraph1.addEdges(1, 3);
		diGraph1.addEdges(2, 3);
		diGraph1.addEdges(4, 0);
		diGraph1.addEdges(4, 1);
		diGraph1.addEdges(4, 3);
		diGraph1.printMatrix(diGraph1.arr);
		System.out.println("Chu trình Hamilton: " + diGraph1.checkCycleHamilton());
		System.out.println("Đường đi Hamilton: " + diGraph1.checkPathHamilton());
		diGraph1.findCycleHamiltonAll();
		
		
		
		DiGraph diGraph2 = new DiGraph(6);
		diGraph2.addEdges(0, 1);
		diGraph2.addEdges(0, 5);
		diGraph2.addEdges(1, 2);
		diGraph2.addEdges(1, 3);
		diGraph2.addEdges(1, 5);
		diGraph2.addEdges(2, 1);
		diGraph2.addEdges(2, 4);
		diGraph2.addEdges(3, 2);
		diGraph2.addEdges(3, 4);
		diGraph2.addEdges(4, 0);
		diGraph2.addEdges(4, 1);
		diGraph2.addEdges(4, 5);
		diGraph2.addEdges(5, 0);
		diGraph2.addEdges(5, 3);
		diGraph2.addEdges(5, 4);
		diGraph2.findCycleEuler(0);
	}

}
