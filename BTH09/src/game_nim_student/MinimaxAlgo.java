package game_nim_student;

public class MinimaxAlgo {
	private Node bestMove;
	public void execute(Node node) throws CloneNotSupportedException {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) throws CloneNotSupportedException {
		if (node.isTerminal())
			return UTILITY(node);

		int v = Integer.MIN_VALUE;
		Node bestMove = null; 

		for (Node child : node.getSuccessors()) {
			int minValue = minValue(child);
			if (minValue > v) {
				v = minValue;
				bestMove = child; 
			}
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) throws CloneNotSupportedException {
		if (node.isTerminal()) {
			return UTILITY(node);
		}
		int v = Integer.MAX_VALUE;
		bestMove = null;

		for (Node child : node.getSuccessors()) {
			v = Math.min(v, maxValue(child));
		}
		return v;
	}
	
	private int UTILITY(Node node) {
		int sum = 0;
		for (Integer value : node.getData()) {
			sum += value;
		}
		return sum;
	}

}
