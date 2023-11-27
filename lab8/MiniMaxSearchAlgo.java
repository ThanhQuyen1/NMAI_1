package lab8;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int v = maxValue(node);
		System.out.println(node.getLabel() + ": " + v);

	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int v = Integer.MIN_VALUE;
		List<Node> list = node.getChildren();
		Collections.sort(list, node.LabelComparator);

		for (Node child : list) {
//			get min 
			int min = minValue(child);
//			update max
			v = Math.max(min, v);
		}

		// Enter your code here
		return v;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		List<Node> list = node.getChildren();
		Collections.sort(list, node.LabelComparator);
		int v = Integer.MAX_VALUE;
		for (Node child : list) {
//			get max 
			int max = maxValue(child);
//			update min
			v = Math.min(max, v);
		}

		// Enter your code here
		return v;
	}
}
