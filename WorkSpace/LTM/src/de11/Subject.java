package de11;

public class Subject {
	private String name;
	private double score;

	public Subject(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return name + "\t" + score;
	}

}
