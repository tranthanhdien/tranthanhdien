package week11;

public class TestUnGraphWeek5 {
	public static void main(String[] args) {
//		UnGraph unGraph1 = new UnGraph(5);
//		unGraph1.addEdges(0, 1);
//		unGraph1.addEdges(0, 2);
//		unGraph1.addEdges(1, 2);
//		unGraph1.addEdges(1, 3);
//		unGraph1.addEdges(1, 4);
//		unGraph1.addEdges(2, 3);
//		unGraph1.addEdges(3, 4);
//
//		UnGraph unGraph2 = new UnGraph(6);
//		unGraph2.addEdges(0, 1);
//		unGraph2.addEdges(0, 4);
//		unGraph2.addEdges(0, 5);
//		unGraph2.addEdges(1, 2);
//		unGraph2.addEdges(1, 3);
//		unGraph2.addEdges(2, 3);
//		unGraph2.addEdges(4, 5);
//
//		UnGraph unGraph3 = new UnGraph(4);
//		unGraph3.addEdges(0, 1);
//		unGraph3.addEdges(0, 2);
//		unGraph3.addEdges(1, 3);
//		unGraph3.addEdges(2, 3);
//
//		UnGraph unGraph4 = new UnGraph(4);
//		unGraph4.addEdges(0, 1);
//		unGraph4.addEdges(1, 2);
//		unGraph4.addEdges(1, 3);
//		unGraph4.addEdges(2, 3);
//
//		unGraph1.printMatrix(unGraph1.arr);
//		System.out.println("Chu trình Hamilton: " + unGraph1.checkCycleHamilton());
//		System.out.println("Đường đi Hamilton: " + unGraph1.checkPathHamilton());
//		System.out.println("*****************************************************");
//		unGraph2.printMatrix(unGraph2.arr);
//		System.out.println("Chu trình Hamilton: " + unGraph2.checkCycleHamilton());
//		System.out.println("Đường đi Hamilton: " + unGraph2.checkPathHamilton());
//		System.out.println("*****************************************************");
//		unGraph3.printMatrix(unGraph3.arr);
//		System.out.println("Chu trình Hamilton: " + unGraph3.checkCycleHamilton());
//		System.out.println("Đường đi Hamilton: " + unGraph3.checkPathHamilton());
//		System.out.println("*****************************************************");
//		unGraph4.printMatrix(unGraph4.arr);
//		System.out.println("Chu trình Hamilton: " + unGraph4.checkCycleHamilton());
//		System.out.println("Đường đi Hamilton: " + unGraph4.checkPathHamilton());
//
//		unGraph3.findCycleHamiltonAll();
//		//unGraph3.findCycleHamiltonAll(3);
//		//unGraph1.allPathHamilton();
//		//unGraph3.findACycleHamilton(0);
//		unGraph3.aCycleHamilton(0);
//		
		UnGraph un = new UnGraph(6);
		un.addEdges(0, 1);
		un.addEdges(0, 4);
		un.addEdges(0, 5);
		un.addEdges(1, 2);
		un.addEdges(1, 3);
		un.addEdges(1, 4);
		un.addEdges(2, 3);
		un.addEdges(3, 4);
		un.addEdges(3, 5);
		un.addEdges(5, 4);
		un.printMatrix(un.arr);
		un.findCycleHamiltonAll();
	}

}
