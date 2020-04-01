package week11;

public class TestDiGraphWeek2 {
	public static void main(String[] args) {
		DiGraph diGraph = new DiGraph(4); // đồ thị có 4 đỉnh
		diGraph.addEdges(0, 1);
		diGraph.addEdges(0, 3);
		diGraph.addEdges(1, 2);
		diGraph.addEdges(2, 3);
		
		DiGraph diGraph1 = new DiGraph(4); // đồ thị có 4 đỉnh
		diGraph1.addEdges(0, 1);
		diGraph1.addEdges(0, 3);
		diGraph1.addEdges(1, 2);
		diGraph1.addEdges(2, 3);
		
		System.out.println("Ma trận kề của đồ thị có hướng:");
		diGraph.printMatrix(diGraph.arr);
	//	System.out.println("Lưỡng phân hay k? "+diGraph.isBir());
		System.out.println("Duyệt DFS: ");
		diGraph.DFS(0);
		System.out.println("\nCó liên thông hay k? " + diGraph.isConnected());
		System.out.println("Thành phần liên thông: " + diGraph.countConnected());
		System.out.println("Đồ thị con hay k? " + diGraph.isSubGraph(diGraph, diGraph1));
	}
}
