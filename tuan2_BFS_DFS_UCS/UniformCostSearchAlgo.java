package tuan2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> priQueue = new PriorityQueue<Node>(20, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		Set<Node> list = new HashSet<Node>();
		priQueue.add(root);
		list.add(root);
		while (!priQueue.isEmpty()) {
			Node current = priQueue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			for (Edge e : current.getChildren()) {
				Node end = e.getEnd();
				double cost = e.getWeight();

				if (!priQueue.contains(end) && !list.contains(end)) {
					end.setPathCost(cost + current.getPathCost());
					end.setParent(current);
					list.add(end);
					priQueue.add(end);
				} else if (priQueue.contains(end) && end.getPathCost() > current.getPathCost() + e.getWeight()) {
					end.setParent(current);
					end.setPathCost(cost + current.getPathCost());

				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> priQueue = new PriorityQueue<Node>(20, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		Set<Node> visited = new HashSet<Node>();
		priQueue.add(root);
		visited.add(root);
		while (!priQueue.isEmpty()) {
			Node current = priQueue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				visited.add(current);
				List<Edge> children = current.getChildren();
				for (Edge chill : children) {
					Node n = chill.getEnd();
					double t = (current.getPathCost() + chill.getWeight());
					if (!priQueue.contains(n) && !visited.contains(n)) {
						priQueue.add(n);
						n.setParent(current);
						n.setPathCost(t);
					} else if (n.getPathCost() < (t)) {
						n.setParent(current);
						n.setPathCost(t);
					}
				}
				for (Node node : current.getChildrenNodes()) {
					if (node.getLabel() == start) {
						node.setParent(null);
						priQueue.clear();
						visited.clear();
						priQueue.add(node);
						node.setPathCost(node.getPathCost() + current.getPathCost());
					}
				}
			}
		}
		return null;
	}
}
