package week11;

public class TestUnGraphWeek7 {
	public static void main(String[] args) {
		UnGraph unGraph1 = new UnGraph(9);
		unGraph1.addEdges(0, 1);
		unGraph1.addEdges(0, 5);
		unGraph1.addEdges(1, 2);
		unGraph1.addEdges(1, 4);
		unGraph1.addEdges(1, 5);
		unGraph1.addEdges(2, 3);
		unGraph1.addEdges(2, 4);
		unGraph1.addEdges(3, 4);
		unGraph1.addEdges(4, 6);
		unGraph1.addEdges(5, 6);
		unGraph1.addEdges(6, 7);
		unGraph1.addEdges(6, 8);
		System.out.println("Ma trận của đồ thị 1: ");
		unGraph1.printMatrix(unGraph1.arr);
		// unGraph1.dfsTree(0);
		System.out.println("DFS khử đệ quy ==>int[][]: ");
		// unGraph1.printMatrix(unGraph1.dfsTree(0));
		System.out.println("DFS khử đệ quy ==>Graph: ");
		// unGraph1.printMatrix(unGraph1.dfsTree(0));
		System.out.println("DFS đệ quy ==>int[][]: ");
		// unGraph1.printMatrix(unGraph1.dfs_Recursive(0));
		System.out.println("DFS đệ quy==>Graph: ");
		// unGraph1.printGraph(unGraph1.dfs_Recu(0));
		System.out.println("BFS khử đệ quy ==>int[][]: ");
		unGraph1.printMatrix(unGraph1.bfsTree(0));
		System.out.println("BFS khử đệ quy ==>Graph: ");
		unGraph1.printGraph(unGraph1.bfsTree_Graph(0));

	}
}
