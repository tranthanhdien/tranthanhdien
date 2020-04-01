package week11;

public class TestUnGraphWeek3 {
	public static void main(String[] args) {
		UnGraph unGraph2 = new UnGraph(4);
		unGraph2.addEdges(0, 1);
		unGraph2.addEdges(0, 2);
		unGraph2.addEdges(1, 0);
		unGraph2.addEdges(1, 2);
		unGraph2.addEdges(1, 3);
		unGraph2.addEdges(2, 0);
		unGraph2.addEdges(2, 1);
		unGraph2.addEdges(2, 3);
		unGraph2.addEdges(3, 1);
		unGraph2.addEdges(3, 2);
		System.out.println("Graph2");
		unGraph2.printMatrix(unGraph2.arr);

		UnGraph unGraph1 = new UnGraph(7);
		unGraph1.addEdges(0, 1);
		unGraph1.addEdges(0, 2);
		unGraph1.addEdges(0, 6);
		unGraph1.addEdges(1, 0);
		unGraph1.addEdges(1, 2);
		unGraph1.addEdges(1, 3);
		unGraph1.addEdges(1, 5);
		unGraph1.addEdges(2, 0);
		unGraph1.addEdges(2, 1);
		unGraph1.addEdges(2, 3);
		unGraph1.addEdges(2, 6);
		unGraph1.addEdges(3, 1);
		unGraph1.addEdges(3, 2);
		unGraph1.addEdges(3, 5);
		unGraph1.addEdges(3, 6);
		unGraph1.addEdges(4, 6);
		unGraph1.addEdges(5, 1);
		unGraph1.addEdges(5, 3);
		unGraph1.addEdges(6, 0);
		unGraph1.addEdges(6, 2);
		unGraph1.addEdges(6, 3);
		unGraph1.addEdges(6, 4);

		UnGraph unGraph3 = new UnGraph(7);
		System.out.println("Graph1");
		unGraph1.printMatrix(unGraph1.arr);
		System.out.println("*Graph2 có là con Graph1: " + unGraph3.isSubGraph(unGraph2, unGraph1));
		System.out.println("*DFS==>Stack");
		unGraph1.DFS_Stack(0);
		System.out.println("\n*BFS==>Queue");
		unGraph1.BFS_Queue(0);
		System.out.println("\n*Đường đi dài: ");
		unGraph1.findPathLong(0, 5);
		System.out.println("*Đường đi ngăn nhất: ");
		unGraph1.findPathShortest(0, 5);
	}

}
