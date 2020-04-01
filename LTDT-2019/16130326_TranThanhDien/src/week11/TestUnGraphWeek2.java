package week11;

public class TestUnGraphWeek2 {
	public static void main(String[] args) {
		System.out.println("**********************************************");
		System.out.println("Week2");
		UnGraph unGraph2 = new UnGraph(9);
		unGraph2.addEdges(0, 4);
		unGraph2.addEdges(0, 6);
		unGraph2.addEdges(1, 2);
		unGraph2.addEdges(1, 6);
		unGraph2.addEdges(1, 8);
		unGraph2.addEdges(2, 1);
		unGraph2.addEdges(2, 3);
		unGraph2.addEdges(3, 2);
		unGraph2.addEdges(3, 4);
		unGraph2.addEdges(3, 8);
		unGraph2.addEdges(4, 0);
		unGraph2.addEdges(4, 3);
		unGraph2.addEdges(4, 5);
		unGraph2.addEdges(4, 7);
		unGraph2.addEdges(5, 6);
		unGraph2.addEdges(5, 6);
		unGraph2.addEdges(6, 0);
		unGraph2.addEdges(6, 1);
		unGraph2.addEdges(6, 5);
		unGraph2.addEdges(7, 4);
		unGraph2.addEdges(8, 1);
		unGraph2.addEdges(8, 3);
		System.out.println("Ma trận kề của đồ thị vô hướng: ");
		unGraph2.printMatrix(unGraph2.arr);
		// lưỡng phân
		System.out.println("Lương phân hay k? " + unGraph2.isBir());

		// Duyệt DFS
		UnGraph unGraph3 = new UnGraph(7);
		unGraph3.addEdges(0, 1);
		unGraph3.addEdges(0, 2);
		unGraph3.addEdges(0, 6);
		unGraph3.addEdges(1, 0);
		unGraph3.addEdges(1, 2);
		unGraph3.addEdges(1, 3);
		unGraph3.addEdges(1, 5);
		unGraph3.addEdges(2, 0);
		unGraph3.addEdges(2, 1);
		unGraph3.addEdges(2, 3);
		unGraph3.addEdges(2, 6);
		unGraph3.addEdges(3, 1);
		unGraph3.addEdges(3, 2);
		unGraph3.addEdges(3, 5);
		unGraph3.addEdges(3, 6);
		unGraph3.addEdges(4, 6);
		unGraph3.addEdges(5, 1);
		unGraph3.addEdges(5, 3);
		unGraph3.addEdges(6, 0);
		unGraph3.addEdges(6, 2);
		unGraph3.addEdges(6, 3);
		unGraph3.addEdges(6, 4);
		System.out.println("Ma trận kề của đồ thị vô hướng: ");
		unGraph3.printMatrix(unGraph3.arr);
		System.out.println("Duyệt DFS: ");
		unGraph3.DFS(0);
		System.out.println("\nCó liên thông hay k? " + unGraph3.isConnected());
		System.out.println("Thành phần liên thông: " + unGraph3.countConnected());
		System.out.println("Có phải đồ thị con k? " + unGraph3.isSubGraph(unGraph2, unGraph3));
	}
}
