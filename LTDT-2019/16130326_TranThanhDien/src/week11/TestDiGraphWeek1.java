package week11;

public class TestDiGraphWeek1 {

	public static void main(String[] args) {
		DiGraph diGraph = new DiGraph(4); // đồ thị có 4 đỉnh
		diGraph.addEdges(0, 1);
		diGraph.addEdges(0, 3);
		diGraph.addEdges(1, 2);
		diGraph.addEdges(2, 3);

		System.out.println("Ma trận kề của đồ thị có hướng:");
		diGraph.printMatrix(diGraph.arr);
		System.out.println("***********************************");
		System.out.println("Ma trận kề của đồ thị có hướng sau khi xoá cạnh: ");
		diGraph.delEdges(6, 5);
		diGraph.printMatrix(diGraph.arr);
		System.out.println("***********************************");
		System.out.println("Bậc của đỉnh 1 là: " + diGraph.degree(0));
		System.out.println("***********************************");
		System.out.println(diGraph.printDegree());
		System.out.println("***********************************");
		System.out.println("Số cạnh của đồ thị có hướng: "+diGraph.numberEdgeGraph());
	}

}
