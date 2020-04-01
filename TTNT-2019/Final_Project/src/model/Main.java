package model;
import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int populationSize = 81;
        int maxIterations = 200000;
        int iteration = 0;
       // Sudoku.setInitialGene(new int[]{2,0,0,0,0,3,0,0,0,0,0,0,0,0,4,0 });
        Sudoku.setInitialGene(new int[]{3, 0, 6, 5, 0, 8, 4, 0, 0,
                5, 2, 0, 0, 0, 0, 0, 0, 0,
                0, 8, 7, 0, 0, 0, 0, 3, 1,
                0, 0, 3, 0, 1, 0, 0, 8, 0,
                9, 0, 0, 8, 6, 3, 0, 0, 5,
                0, 5, 0, 0, 9, 0, 6, 0, 0,
                1, 3, 0, 0, 0, 0, 2, 5, 0,
                0, 0, 0, 0, 0, 0, 0, 7, 4,
                0, 0, 5, 2, 0, 6, 3, 0, 0});
        Sudoku currentSudoku = new Sudoku(GeneticOperators.initialize(Sudoku.getInitialGene().clone()));

        while (currentSudoku.getFitnessValue() != 0 && iteration < maxIterations) {
            System.out.println("current: " + currentSudoku + ", iteration: " + iteration);
            Vector<Sudoku> population = new Vector<>();
            for (int i = 0; i < populationSize; i++) {population.add(new Sudoku(currentSudoku.getGene().clone()));}
             
            for (int i = 0; i < population.size(); i++) {
                if (random.nextBoolean()) {
                   
                	population.get(i).randomMutation();
                	population.get(i).crossover(population.get(random.nextInt(population.size())));
                	currentSudoku = Sudoku.bestSelection(population);
                } else {
                	population.get(i).mutation();
                    population.get(i).crossover(population.get(random.nextInt(population.size())));
                    currentSudoku = Sudoku.bestSelection(population);
                	
            }
            }
            //if (random.nextBoolean()) {
                //currentSudoku = Sudoku.bestSelection(population);
            //}else {
                //currentSudoku = Sudoku.rouletteSelection(population);}
            iteration++;
            
        }

        System.out.println("goal: " + currentSudoku + ", iteration: " + iteration);

    }


}