package model;
import java.util.Random;
public class  GeneticOperators {

    public static int[] initialize(int[] gene) {
        int dimensions = (int) Math.sqrt(gene.length);

        for (int i = 0; i < gene.length; i++) {
            if (gene[i] == 0) gene[i] = new Random().nextInt(dimensions) + 1;
        }

        return gene;
    }

    public static int[] randomMutation(int[] gene) {
        int dimensions = (int) Math.sqrt(gene.length);
        int[] mutation = gene;
        int rand = new Random().nextInt(gene.length);
        for (int i = 0; i <rand ; i++)
            mutation = mutation(gene, new Random().nextInt(gene.length), new Random().nextInt(dimensions) + 1);


        return mutation;
    }

    public static int[] mutation(int[] gene) {
        int dimensions = (int) Math.sqrt(gene.length);
        int[] mutation = mutation(gene, new Random().nextInt(gene.length), new Random().nextInt(dimensions) + 1);

        return mutation;
    }


    public static int[] mutation(int[] gene, int index, int value) {
    	gene[index] = value;

        return gene;
    }

    public static int[][] crossover(int[] gene1, int[] gene2) {
        int start = new Random().nextInt(gene1.length);
        int end = new Random().nextInt(gene1.length - start) + start;

        return crossover(gene1, gene2, start, end);
    }

    public static int[][] crossover(int[] gene1, int[] gene2, boolean singlePoint) {
        int start = (singlePoint) ? 0 : new Random().nextInt(gene1.length);
        int end = new Random().nextInt(gene1.length - start) + start;

        return crossover(gene1, gene2, start, end);
    }

    public static int[][] crossover(int[] gene1, int[] gene2, int start, int end) {
        int[][] newGene = new int[2][gene1.length];
        for (int i = 0; i < gene1.length; i++) {
            newGene[0][i] = (i >= start && i <= end) ? gene2[i] : gene1[i];
            newGene[1][i] = (i >= start && i <= end) ? gene1[i] : gene2[i];
        }
        return newGene;
    }
}