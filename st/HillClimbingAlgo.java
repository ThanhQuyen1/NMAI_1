package st;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class HillClimbingAlgo {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;
	public Node execute(Node initialState) {
		Node current = initialState;
		Node neighbor;
		int curH = current.getH();
		SortedSet<Node> set = new TreeSet<Node>(current.generateAllCandidates());
		if (randomRestarts > 1) {
			stepClimbedAfterRandomRestart = 0;
		}
		while(true) {
			neighbor = set.first();
			if (neighbor.getH() >= curH) {
				return neighbor;
				
			}else {
				curH = neighbor.getH();
				current = neighbor;
				stepClimbed++;
				if (randomRestarts > 0) {
					stepClimbedAfterRandomRestart++;
				}
			}
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node state = execute(initialState);
		while(state.getH() != 0) {
			state.generateBoard();
			randomRestarts++;
			state = execute(state);
		}
		return state;
	}
	public void print() {
		System.out.println("stepClimbed = " + stepClimbed);
		System.out.println("stepClimbedAfterRandomRestart = " + stepClimbedAfterRandomRestart);
		System.out.println("randomRestarts = " + randomRestarts);
	}
}
