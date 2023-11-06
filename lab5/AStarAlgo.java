package lab5;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarAlgo implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		Set<Node> explored = new HashSet<Node>();
		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getH() == 0) {
				return current;
			} else {
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!explored.contains(child)) {
						if (!frontier.contains(child)) {
							child.setG(current.getG() + 1);
							frontier.add(child);
						} else {
							int newG = current.getG() + 1;
							if (newG < child.getG()) {
								child.setG(newG);
							}
						}

					}
				}
			}

		}

		return null;
	}
}
