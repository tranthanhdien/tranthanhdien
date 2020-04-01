
import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		int[][] inputSud = new int[][] { 
			{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
			{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
			{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
			{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
			{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		GeneticAlgorithm ga = new GeneticAlgorithm();

		Sudoku tempSudoku = new Sudoku(inputSud);
		int[][] tempSolution;

		// Testing Genetic Algorithm...
		System.out.println("----Testing Genetic Algorithm----");
		// Initialize population
		Population pop = new Population();
		tempSudoku = new Sudoku(inputSud);
		 pop.initializePopulation(50, tempSudoku);
		System.out.println("Initial state: ");
		tempSudoku.printCurrentState();
		System.out.println();

		// Evolve population for 100 generations
		pop = ga.evolvePopulation(pop, tempSudoku);
		for (int i = 0; i < 100; i++) {
			pop = ga.evolvePopulation(pop, tempSudoku);
			// System.out.println("(" + i + ")evolving population ... ");
		}
		tempSudoku = pop.getFittest();
		// Print final results
		System.out.println();
		System.out.println("---Solution----");
		tempSudoku.printCurrentState();

	}

}