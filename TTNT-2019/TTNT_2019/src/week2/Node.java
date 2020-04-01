package week2;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public int n; // số quân hậu
	public List<Integer> state; // vị trí quân hậu hiện tại
	public List<Node> neighbours; // ds các Node con của Node đang xét

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}

	public Node(int n, List<Integer> state) {
		super();
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();
	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	// ktra một state có hợp lệ hay không
	public boolean isValid(List<Integer> state) {
		if (state.size() == 1) { // hợp lệ vì chỉ có 1 quân hậu
			return true;
		}
		int lastIndex1 = this.state.size() - 1; // state cuối
		int lastIndex2 = state.get(lastIndex1);
		if (this.state.size() > 1) {
			for (int i = 0; i < lastIndex1; i++) { // hàng
				// ktra ngang
				if (lastIndex1 == state.get(i)) { // ktra state cuối với các state trước đó
					return false;
				}
				// ktra chéo
				if (Math.abs(lastIndex2 - state.get(i)) == Math.abs(lastIndex1 - i)) { // xung đột đư�?ng chéo
					return false;
				}
			}
		}
		return true;
	}

	// ktra có thể đặt con hậu mới vào vị trí x của cột mới hay không
	private List<Integer> place(int x) {
		List<Integer> list = new ArrayList<>(this.state);
		// thêm vào vị trí x
		list.add(x);
		if (isValid(list) == false) {
			return null;
		} else {
			return list;
		}

	}

	// trả v�? danh sách các Node con của Node đang xét
	public List<Node> getNeighbours() {
		if (this.state.size() == this.n) {
			return null;
		}
		for (int i = 0; i < this.n; i++) {
			List<Integer> list = place(i);
			if (list != null) {
				Node node = new Node(n, list);
				addNeighbours(node);
			}
		}
		return neighbours;

	}

}
