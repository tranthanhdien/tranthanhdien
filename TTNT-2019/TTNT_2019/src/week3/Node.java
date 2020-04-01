package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
	public int n;
	public List<Integer> state;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			Random rd = new Random();
			this.state.add(rd.nextInt(n));
		}
	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public List<Integer> getState() {
		return state;
	}

	public void setState(List<Integer> state) {
		this.state = state;
	}

	@Override
	public String toString() {
		String result = "";
		for (Integer i : state) {
			result += i + "\t";
		}
		return result;
	}

}
