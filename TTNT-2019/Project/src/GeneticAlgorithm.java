
import java.util.Random;

// GeneticAlgorithm.java
// Manages algorithms for evolving population

public class GeneticAlgorithm extends Solver {
	protected Sudoku initialSudoku;

	// GeneticAlgorithm parameters
	private static final double mutationRate = 0.015;
	private static final int tournamentSize = 10;
	private static final boolean elitism = true;

	// Evolves a population over one generation
	public Population evolvePopulation(Population pop, Sudoku sud) {
		this.initialSudoku = sud;
		Population newPopulation = new Population();
		newPopulation.initializePopulation(pop.populationSize(), sud);

		// Keep our best individual if elitism is enabled
		int elitismOffset = 0;
		if (elitism) {
			newPopulation.saveSudoku(0, pop.getFittest());
			elitismOffset = 1;
		}
		// Crossover population
		// Loop over the new population's size and create individuals from
		// Current population
		for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
			// Select parents
			Sudoku parent1 = this.tournamentSelection(pop, sud);
			Sudoku parent2 = this.tournamentSelection(pop, sud);
			// Crossover parents
			Sudoku child = this.crossover(parent1, parent2);
			// Add child to new population
			newPopulation.saveSudoku(i, child);
		}

		// Mutate the new population a bit to add some new genetic material
		for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
			this.mutate(newPopulation.getSudoku(i));
		}
		return newPopulation;
	}

	// crossover từ cha mẹ để tạo ra con
	public Sudoku crossover(Sudoku parent1, Sudoku parent2) {
		Sudoku child; // tạo mới 1 Sudoku con

		int[][] p1 = new int[9][9]; // cha
		int[][] p2 = new int[9][9]; // mẹ

		int[][] c = new int[9][9]; // con

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				c[i][j] = 0;
			}
		}

		// lấy vị trí bắt đầu và kết thúc của cha
		int startx = (int) (Math.random() * 9);
		int endx = (int) (Math.random() * 9);

		// Copy the initial state of the puzzle to the Hill
		// climbing class.
		this.setInitialState(parent1);

		// Copy initial state into current state.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				p1[i][j] = this.initialState[i][j];
			}
		}

		// Copy the initial state of the puzzle to the Hill
		// climbing class.
		this.setInitialState(parent2);

		// Copy initial state into current state.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				p2[i][j] = this.initialState[i][j];
			}
		}

		// Loop and add the sub sudoku from parent1 to our child
		for (int i = 0; i < 9; i++) {
			// If our start position is less than the end position
			if (startx < endx && i >= startx && i < endx) {
				for (int j = 0; j < 9; j++) {
					c[i][j] = p1[i][j];
				}

			} // If our start position is larger
			else if (startx > endx) {
				if (!(i < startx && i > endx)) {
					for (int j = 0; j < 9; j++) {
						c[i][j] = p1[i][j];
					}
				}
			}
		}

		// Loop through parent2's sudoku
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (c[i][j] == 0) {
					c[i][j] = p2[i][j];
				}
			}
		}
		child = new Sudoku(c);
		return child;
	}

	// Mutate a sudoku using swap mutation
	private void mutate(Sudoku sudoku) {
		Random rd = new Random();
		int temporaryValue, randomRowIndex;
		int[] colIndex = new int[2];
		int[][] tempState = new int[9][9];

		// Make a copy of puzzle to work with.
		this.temp = new Sudoku(this.initialSudoku.getInitialState());

		// Copy the initial state of the puzzle to the Hill
		// climbing class.
		this.setInitialState(this.temp);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tempState[i][j] = this.initialState[i][j];
			}
		}

		// Apply mutation rate
		if (Math.random() < mutationRate) {
			// Picks a random row in initialState, and if two random elements
			// that belong in that row both equal zero, swap those values in
			// the currentState.
			randomRowIndex = rd.nextInt(9);

			do {
				for (int i = 0; i < 2; i++) {
					colIndex[i] = rd.nextInt(9);
				}
			} while (this.initialState[randomRowIndex][colIndex[0]] != 0
					|| this.initialState[randomRowIndex][colIndex[1]] != 0);

			temporaryValue = tempState[randomRowIndex][colIndex[0]];
			tempState[randomRowIndex][colIndex[0]] = tempState[randomRowIndex][colIndex[1]];
			tempState[randomRowIndex][colIndex[1]] = temporaryValue;
			sudoku = new Sudoku(tempState);
		}

	}

	// Selects candidate sudoku for crossover
	private Sudoku tournamentSelection(Population pop, Sudoku s) {
		// Create a tournament population
		Population tournament = new Population();
		tournament.initializePopulation(tournamentSize, s);
		// For each place in the tournament get a random candidate sudoku and
		// add it
		for (int i = 0; i < tournamentSize; i++) {
			int randomId = (int) (Math.random() * pop.populationSize());
			tournament.saveSudoku(i, pop.getSudoku(randomId));
		}
		// Get the fittest sudoku
		Sudoku fittest = tournament.getFittest();
		return fittest;
	}

	@Override
	public int[][] solve(Sudoku puzzle) {
		// not used in context
		return null;
	}
	
}