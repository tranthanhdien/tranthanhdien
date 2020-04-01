package week11;

public class TestDiGraphWeek7 {

	public static void main(String[] args) {
		DiGraph diGraph1 = new DiGraph(4);
		diGraph1.addEdges(0, 1);
		diGraph1.addEdges(0, 2);
		diGraph1.addEdges(1, 2);
		diGraph1.addEdges(2, 0);
		diGraph1.addEdges(2, 3);
		diGraph1.addEdges(3, 3);
		System.out.println("Ma trận của đồ thị 1: ");
		diGraph1.printMatrix(diGraph1.arr);
		// diGraph1.dfsTree(0);
		System.out.println("DFS khử đệ quy ==>int[][]: ");
		// diGraph1.printMatrix(diGraph1.dfsTree(0));
		System.out.println("DFS khử đệ quy ==>Graph: ");
		// diGraph1.printMatrix(diGraph1.dfsTree(0));
		System.out.println("DFS đệ quy ==>int[][]: ");
		// diGraph1.printMatrix(diGraph1.dfs_Recursive(0));
		System.out.println("DFS đệ quy==>Graph: ");
		// diGraph1.printGraph(diGraph1.dfs_Recu(0));
		System.out.println("BFS khử đệ quy ==>int[][]: ");
		diGraph1.printMatrix(diGraph1.bfsTree(0));
		System.out.println("BFS khử đệ quy ==>Graph: ");
		diGraph1.printGraph(diGraph1.bfsTree_Graph(0));

	}

}
