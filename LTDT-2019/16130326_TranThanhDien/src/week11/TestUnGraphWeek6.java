package week11;

public class TestUnGraphWeek6 {
	public static void main(String[] args) {
		UnGraph unGraph1 = new UnGraph(5);
		unGraph1.addEdges(0, 1);
		unGraph1.addEdges(0, 3);
		unGraph1.addEdges(1, 2);
		unGraph1.addEdges(1, 3);
		unGraph1.addEdges(1, 4);
		unGraph1.addEdges(2, 3);
		unGraph1.addEdges(2, 4);
		System.out.println("**Ma trận kề của đồ thị 1: ");
		unGraph1.printMatrix(unGraph1.arr);
		//unGraph1.findCycleHamiltonAll();
		//unGraph1.findCycleHamiltonAll(0);
		unGraph1.allPathHamilton();
		unGraph1.allPathHamilton(0);
		System.out.println("****************************************");
		
		UnGraph unGraph2 = new UnGraph(6);
		unGraph2.addEdges(0, 1);
		unGraph2.addEdges(0, 4);
		unGraph2.addEdges(0, 5);
		unGraph2.addEdges(1, 2);
		unGraph2.addEdges(1, 3);
		unGraph2.addEdges(2, 3);
		unGraph2.addEdges(4, 5);
		System.out.println("**Ma trận kề của đồ thị 2: ");
		unGraph2.printMatrix(unGraph2.arr);
		unGraph2.findCycleHamiltonAll(2);
		unGraph2.allPathHamilton();
		unGraph2.allPathHamilton(2);
		System.out.println("****************************************");

		UnGraph unGraph3 = new UnGraph(4);
		unGraph3.addEdges(0, 1);
		unGraph3.addEdges(1, 2);
		unGraph3.addEdges(1, 3);
		unGraph3.addEdges(2, 3);
		//System.out.println("Ma trận kề của đồ thị 3: ");
		//unGraph3.printMatrix(unGraph3.arr);
		//unGraph3.allPathHamilton();
		//unGraph3.allPathHamilton(3);
	}

}
