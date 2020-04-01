package week11;

public class TestGK {

	public static void main(String[] args) {
		UnGraph unGraph = new UnGraph(5);
		unGraph.addEdges(0, 1);
		unGraph.addEdges(0, 4);
		unGraph.addEdges(1, 2);
		//unGraph.addEdges(1, 4);
		unGraph.addEdges(2, 3);
		unGraph.addEdges(3, 4);
		unGraph.printMatrix(unGraph.arr);
		unGraph.findCycleEuler(0);
		//unGraph.findPathEuler(0);
	}

}
