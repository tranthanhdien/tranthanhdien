package week11;

public class TestUnGraphWeek4 {
	public static void main(String[] args) {
		UnGraph unGraph1 = new UnGraph(5);
		unGraph1.addEdges(0, 1);
		unGraph1.addEdges(0, 4);
		unGraph1.addEdges(1, 0);
		unGraph1.addEdges(1, 4);
		unGraph1.addEdges(2, 3);
		unGraph1.addEdges(2, 4);
		unGraph1.addEdges(3, 2);
		unGraph1.addEdges(3, 4);
		unGraph1.addEdges(4, 0);
		unGraph1.addEdges(4, 1);
		unGraph1.addEdges(4, 2);
		unGraph1.addEdges(4, 3);
		UnGraph unGraph2 = new UnGraph(5);
		unGraph2.addEdges(0, 1);
		unGraph2.addEdges(0, 4);
		unGraph2.addEdges(1, 0);
		unGraph2.addEdges(1, 2);
		unGraph2.addEdges(1, 4);
		unGraph2.addEdges(2, 1);
		unGraph2.addEdges(2, 3);
		unGraph2.addEdges(3, 2);
		unGraph2.addEdges(3, 4);
		unGraph2.addEdges(4, 0);
		unGraph2.addEdges(4, 1);
		unGraph2.addEdges(4, 3);

		UnGraph unGraph3 = new UnGraph(7);
		unGraph3.addEdges(0, 1);
		unGraph3.addEdges(0, 4);
		unGraph3.addEdges(1, 0);
		unGraph3.addEdges(1, 4);
		unGraph3.addEdges(2, 3);
		unGraph3.addEdges(2, 4);
		unGraph3.addEdges(3, 2);
		unGraph3.addEdges(3, 4);
		unGraph3.addEdges(4, 0);
		unGraph3.addEdges(4, 1);
		unGraph3.addEdges(4, 2);
		unGraph3.addEdges(4, 3);
		unGraph3.addEdges(5, 6);
		unGraph3.addEdges(6, 5);

		System.out.println("Ma trận kề 1:");
		unGraph1.printMatrix(unGraph1.arr);
		System.out.println("Chu trình Euler: " + unGraph1.checkCycleEuler());
		System.out.println("Đường đi Euler: " + unGraph1.checkEulerPath());

		System.out.println("*************************************");
		System.out.println("Ma trận kề 2:");
		unGraph2.printMatrix(unGraph2.arr);
		System.out.println("Chu trình Euler: " + unGraph2.checkCycleEuler());
		System.out.println("Đường đi Euler: " + unGraph2.checkEulerPath());

		System.out.println("*************************************");
		System.out.println("Ma trận kề 3:");
		unGraph3.printMatrix(unGraph3.arr);
		System.out.println("Chu trình Euler: " + unGraph3.checkCycleEuler());
		System.out.println("Đường đi Euler: " + unGraph3.checkEulerPath());
		unGraph1.findCycleEuler(0);
		unGraph2.findPathEuler(0);
	}

}
