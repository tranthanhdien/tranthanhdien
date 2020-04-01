package week11;

public class TestDiGraphWeek4 {
	public static void main(String[] args) {
		DiGraph diGraph1 = new DiGraph(4);
		diGraph1.addEdges(0, 1);
		diGraph1.addEdges(1, 2);
		diGraph1.addEdges(1, 3);
		diGraph1.addEdges(2, 1);
		diGraph1.addEdges(2, 3);
		diGraph1.addEdges(3, 0);
		diGraph1.addEdges(3, 2);

		DiGraph diGraph2 = new DiGraph(6);
		diGraph2.addEdges(0, 1);
		diGraph2.addEdges(0, 4);
		diGraph2.addEdges(1, 2);
		diGraph2.addEdges(1, 5);
		diGraph2.addEdges(2, 0);
		diGraph2.addEdges(2, 3);
		diGraph2.addEdges(3, 4);
		diGraph2.addEdges(4, 2);
		diGraph2.addEdges(4, 5);
		diGraph2.addEdges(5, 0);
		diGraph2.addEdges(5, 3);
		System.out.println("Ma trận kề của đồ thị có hướng: ");
		diGraph1.printMatrix(diGraph1.arr);
		System.out.println("Chu trình Euler: " + diGraph1.checkCycleEuler());
		System.out.println("Đường đi Euler: " + diGraph1.checkEulerPath());

		System.out.println("*******************************************");
		System.out.println("Ma trận kề của đồ thị có hướng: ");
		diGraph2.printMatrix(diGraph2.arr);
		System.out.println("Chu trình Euler: " + diGraph2.checkCycleEuler());
		System.out.println("Đường đi Euler: " + diGraph2.checkEulerPath());
		diGraph1.findCycleEuler(3);
		diGraph2.findPathEuler(2);

	}

}
