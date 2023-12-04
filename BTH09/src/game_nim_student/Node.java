package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}
	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}
	// Get children of the current nodes
	public List<Node> getSuccessors() throws CloneNotSupportedException {
		// Enter your code here
		List<Integer> successors = new ArrayList<>();
		List<Node> list = new ArrayList<>();

		for(int  i =0 ; i< this.data.size(); i++) {
			if(!isTerminal()) {
				int number = data.get(i) / 2;
				for(int j= 1; j<= number; j++) {
					int x= this.data.get(i) - j;
					successors.add(x);
					successors.add(i);
					Node node = new Node();
					node.clone();
					node.data.remove(i);
					node.addAll(successors);
					list.add(node);
				}
			}
		}
		return list;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		for (Integer child : data) {
			if (child > 2) {
				return false;
			}
		}
		return true;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
