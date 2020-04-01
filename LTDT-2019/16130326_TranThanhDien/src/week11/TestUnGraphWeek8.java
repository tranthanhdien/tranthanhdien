package week11;

public class TestUnGraphWeek8 {

	public static void main(String[] args) {
		UnGraph unGrph1 = new UnGraph(9);
		unGrph1.addEdge(0, 1, 8);
		unGrph1.addEdge(0, 5, 3);
		unGrph1.addEdge(1, 2, 9);
		unGrph1.addEdge(1, 4, 12);
		unGrph1.addEdge(1, 5, 7);
		unGrph1.addEdge(2, 3, 4);
		unGrph1.addEdge(2, 4, 18);
		unGrph1.addEdge(3, 4, 6);
		unGrph1.addEdge(4, 6, 5);
		unGrph1.addEdge(5, 6, 10);
		unGrph1.addEdge(6, 7, 11);
		unGrph1.addEdge(6, 8, 1);
		//System.out.println("Ma trận của đồ thị: ");
		//unGrph1.printMatrix(unGrph1.arr);
		//unGrph1.printMatrix(unGrph1.kruskalTree());
		//System.out.println("****************Thuật toán PRIM");
		//unGrph1.printMatrix(unGrph1.primTree(0));
		
		UnGraph unGraph2 = new UnGraph(8);
		unGraph2.addEdge(0, 1, 4);
		unGraph2.addEdge(0, 2, 3);
		unGraph2.addEdge(1, 2, 2);
		unGraph2.addEdge(1, 3, 5);
		unGraph2.addEdge(1, 4, 7);
		unGraph2.addEdge(2, 3, 3);
		unGraph2.addEdge(2, 4, 6);
		unGraph2.addEdge(3, 4, 1);
		unGraph2.addEdge(3, 5, 8);
		unGraph2.addEdge(4, 6, 5);
		unGraph2.addEdge(5, 6, 2);
		unGraph2.addEdge(5, 7, 7);
		unGraph2.addEdge(6, 7, 4);
		System.out.println("Ma trận");
		//unGraph2.printMatrix(unGraph2.arr);
		//unGraph2.primTree(0);
		
		UnGraph unGraph3 = new UnGraph(8);
		unGraph3.addEdge(0, 1, 8);
		unGraph3.addEdge(0, 2, 6);
		unGraph3.addEdge(0, 3, 3);
		unGraph3.addEdge(1, 3, 1);
		unGraph3.addEdge(1, 4, 3);
		unGraph3.addEdge(1, 6, 6);
		unGraph3.addEdge(2, 3, 4);
		unGraph3.addEdge(2, 4, 9);
		unGraph3.addEdge(2, 5, 2);
		unGraph3.addEdge(3, 4, 2);
		unGraph3.addEdge(4, 5, 5);
		unGraph3.addEdge(4, 6, 2);
		unGraph3.addEdge(4, 7, 3);
		unGraph3.addEdge(6, 7, 4);
		unGraph3.printMatrix(unGraph3.arr);
		unGraph3.primTree(unGraph3.arr, 1);
		
		
		
	}

}
