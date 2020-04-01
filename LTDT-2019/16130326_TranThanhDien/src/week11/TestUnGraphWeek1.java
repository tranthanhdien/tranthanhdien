package week11;

public class TestUnGraphWeek1 {

	public static void main(String[] args) {
		UnGraph unGraph1 = new UnGraph(7); // tạo đồ thị có 7 đỉnh
		unGraph1.addEdges(0, 1);
		unGraph1.addEdges(0, 2);
		unGraph1.addEdges(0, 6);
		unGraph1.addEdges(1, 0);
		unGraph1.addEdges(1, 2);
		unGraph1.addEdges(1, 3);
		unGraph1.addEdges(1, 4);
		unGraph1.addEdges(2, 0);
		unGraph1.addEdges(2, 1);
		unGraph1.addEdges(2, 3);
		unGraph1.addEdges(2, 6);
		unGraph1.addEdges(3, 1);
		unGraph1.addEdges(3, 2);
		unGraph1.addEdges(3, 4);
		unGraph1.addEdges(3, 6);
		unGraph1.addEdges(4, 1);
		unGraph1.addEdges(4, 3);
		unGraph1.addEdges(5, 6);
		unGraph1.addEdges(6, 0);
		unGraph1.addEdges(6, 2);
		unGraph1.addEdges(6, 5);
		System.out.println("Ma trận kề của đồ thị vô hướng: ");
		unGraph1.printMatrix(unGraph1.arr);
		System.out.println("***********************************");
		System.out.println("Ma trận kề của đồ thị vô hướng sau khi xoá cạnh: ");
		unGraph1.delEdges(6, 5);
		unGraph1.printMatrix(unGraph1.arr);
		System.out.println("***********************************");
		System.out.println("Bậc của đỉnh 1: " + unGraph1.degree(0));
		System.out.println("***********************************");
		System.out.println(unGraph1.printDegree());
		System.out.println("***********************************");
		System.out.println("Số cạnh của đồ thị vô hướng: "+unGraph1.numberEdgeGraph());
		System.out.println("***********************************");
		
		
		
		
		
		
	}

}
