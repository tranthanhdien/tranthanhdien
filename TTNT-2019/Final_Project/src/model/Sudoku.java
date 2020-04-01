package model;

import java.util.Observable;
import java.util.Random;
import java.util.Vector;

public class Sudoku extends Observable {
	private static int[] initialGene;
	private int[] gene;
	private int fitnessValue;
	private double probability;
	
    Random random = new Random();
    int populationSize = 50;
    int maxIterations = 200000;
    int iteration = 0;

	public Sudoku() {
		
	}


	public Sudoku(int[] gene) {
		this.gene = gene;
		fitnessValue = fitness();

	}

	public static Sudoku bestSelection(Vector<Sudoku> sudokus) {
		Sudoku min = sudokus.firstElement();
		for (Sudoku sudoku : sudokus)
			if (sudoku.fitnessValue < min.fitnessValue)
				min = sudoku;

		return min;
	}

	public static Sudoku rouletteSelection(Vector<Sudoku> sudokus) {
		int max = 0;
		for (Sudoku sudoku : sudokus)
			if (sudoku.fitnessValue > max)
				max = sudoku.fitnessValue;

		int sum = 0;
		for (Sudoku sudoku : sudokus)
			sum += max - sudoku.fitnessValue;
		for (Sudoku sudoku : sudokus)
			sudoku.setProbability((max - sudoku.fitnessValue) / (sum * 1.0));

		double random = Math.random() * sum;
		int i;
		for (i = 0; i < sudokus.size() && random > 0; i++) {
			random -= max - sudokus.get(i).fitnessValue;
		}
		return sudokus.get(i - 1);
	}

	public void randomMutation() {
		int[] mutation = GeneticOperators.randomMutation(this.getGene());
		this.setGene(mutation);
	}

	public void mutation() {
		int[] mutation = GeneticOperators.mutation(this.getGene());
		this.setGene(mutation);
	}

	public void mutation(int index, int value) {
		int[] mutation = GeneticOperators.mutation(this.getGene(), index, value);
		this.setGene(mutation);
	}

	public static void randomMutation(Sudoku sudoku) {
		int[] mutation = GeneticOperators.randomMutation(sudoku.getGene());
		sudoku.setGene(mutation);
	}

	public static void mutation(Sudoku sudoku) {
		int[] mutation = GeneticOperators.mutation(sudoku.getGene());
		sudoku.setGene(mutation);
	}

	public static void mutation(Sudoku sudoku, int index, int value) {
		int[] mutation = GeneticOperators.mutation(sudoku.getGene(), index, value);
		sudoku.setGene(mutation);
	}

	public void crossover(Sudoku sudoku1, boolean singlePoint) {
		int[][] crossover = GeneticOperators.crossover(this.getGene(), sudoku1.getGene(), singlePoint);
		this.setGene(crossover[0]);
		sudoku1.setGene(crossover[1]);
	}

	public void crossover(Sudoku sudoku1) {
		int[][] crossover = GeneticOperators.crossover(this.getGene(), sudoku1.getGene());
		this.setGene(crossover[0]);
		sudoku1.setGene(crossover[1]);
	}

	public void crossover(Sudoku sudoku1, int start, int end) {
		int[][] crossover = GeneticOperators.crossover(this.getGene(), sudoku1.getGene(), start, end);
		this.setGene(crossover[0]);
		sudoku1.setGene(crossover[1]);
	}

	public static void crossover(Sudoku sudoku, Sudoku sudoku1, boolean singlePoint) {
		int[][] crossover = GeneticOperators.crossover(sudoku.getGene(), sudoku1.getGene(), singlePoint);
		sudoku.setGene(crossover[0]);
		sudoku1.setGene(crossover[1]);
	}

	public static void crossover(Sudoku sudoku, Sudoku sudoku1) {
		int[][] crossover = GeneticOperators.crossover(sudoku.getGene(), sudoku1.getGene());
		sudoku.setGene(crossover[0]);
		sudoku1.setGene(crossover[1]);
	}

	public static void crossover(Sudoku sudoku, Sudoku sudoku1, int start, int end) {
		int[][] crossover = GeneticOperators.crossover(sudoku.getGene(), sudoku1.getGene(), start, end);
		sudoku.setGene(crossover[0]);
		sudoku1.setGene(crossover[1]);
	}

	public int fitness() {
		return fitness(this.gene);
	}

	public static int fitness(int[] gene) {
		int fitness = 0;
		int[][] newGene = oneDToTwoD(gene);
		int[][] newInitialGene = oneDToTwoD(initialGene);
		for (int i = 0; i < newGene.length; i++) {
			boolean[] rowFlag = new boolean[newGene.length + 1];
			boolean[] colFlag = new boolean[newGene.length + 1];
			for (int j = 0; j < newGene.length; j++) {
				if (rowFlag[newGene[i][j]])
					fitness++;
				if (colFlag[newGene[j][i]])
					fitness++;
				if ((newInitialGene[i][j] != 0 && newInitialGene[i][j] != newGene[i][j]) || newGene[i][j] == 0)
					fitness += 1000;
				rowFlag[newGene[i][j]] = true;
				colFlag[newGene[j][i]] = true;
			}
		}
		int blockSize = (int) Math.sqrt(newGene.length);
		for (int i = 0; i < newGene.length; i += blockSize) {
			for (int j = 0; j < newGene.length; j += blockSize) {
				boolean[] blockFlag = new boolean[newGene.length + 1];

				for (int k = 0; k < blockSize; k++) {
					for (int l = 0; l < blockSize; l++) {
						if (blockFlag[newGene[i + k][j + l]])
							fitness++;
						blockFlag[newGene[i + k][j + l]] = true;
					}
				}
			}
		}
		return fitness;
	}

	public static int[] twoDToOneD(int[][] twoD) {
		int[] oneD = new int[twoD.length * twoD.length];
		for (int i = 0; i < oneD.length; i++)
			oneD[i] = twoD[i / twoD.length][i % twoD.length];

		return oneD;
	}

	public static int[][] oneDToTwoD(int[] oneD) {
		int[][] twoD = new int[(int) Math.sqrt(oneD.length)][(int) Math.sqrt(oneD.length)];
		for (int i = 0; i < oneD.length; i++)
			twoD[i / twoD.length][i % twoD.length] = oneD[i];

		return twoD;
	}

	public static int[] getInitialGene() {
		return initialGene;
	}

	public static void setInitialGene(int[] initialGene) {
		Sudoku.initialGene = initialGene;
	}

	public int[] getGene() {
		return gene;
	}

	public void setGene(int[] gene) {
		this.gene = gene;
		fitnessValue = fitness();
	}

	public int getFitnessValue() {
		return fitnessValue;
	}

	public void setFitnessValue(int fitnessValue) {
		this.fitnessValue = fitnessValue;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		String string = "Gene: ";
		int dimensions = (int) Math.sqrt(gene.length);
		for (int i : gene) {
			string += i;
		}
		for (int i = 0; i < gene.length; i++)
			string += ((i % dimensions == 0) ? "\n" : "") + gene[i] + " ";
		string += "\nFitness: " + fitnessValue;

		return string;
	}

	public int getNumber(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSelectedNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setNumber(int x, int y, int number) {
		// TODO Auto-generated method stub
		
	}
	
}