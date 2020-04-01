package week11;

public class Edges {
	private int a;// đỉnh a
	private int b;// đỉnh b
	private int weight; // trọng số
	// constructor bình thường
	public Edges(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	// constructor cho cây bao trùm
	public Edges(int a, int b, int weight) { 
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void set(Edges that) {
		Edges temp = this;
		this.setA(that.getA());
		this.setB(that.getB());
		this.setWeight(that.getWeight());

		that.setA(temp.getA());
		that.setB(temp.getB());
		that.setWeight(temp.getWeight());
	}

	@Override
	public String toString() {
		return "(" + this.a + ", " + this.b + ")";
	}
}
