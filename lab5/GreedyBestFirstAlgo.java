package lab5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;



public class GreedyBestFirstAlgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		Set<Node> explored = new HashSet<Node>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getH() == 0) {
				return current;
			} else {
				List<Node> children = model.getSuccessors(current);
				for (Node child : children) {
					if (!frontier.contains(child) && !explored.contains(child)) {
						child.setG(current.getG()+1);
						frontier.add(child);
					}
				}
			}
			
		}
		
		return null;
	}

	
}
