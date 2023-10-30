package lab4.inform.student;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedyBestFirstSearch implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> priQueue = new PriorityQueue<Node>(new NodeComparator());
		Set<Node> list = new HashSet<Node>();
		priQueue.add(root);
		list.add(root);
		while (!priQueue.isEmpty()) {
			Node current = priQueue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			for (Node n : current.getChildrenNodes()) {
				if (!list.contains(n) && !priQueue.contains(n)) {
					priQueue.add(n);
					n.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub

		PriorityQueue<Node> priQueue = new PriorityQueue<Node>(new NodeComparator());

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
					double t = (current.getH() + chill.getWeight());
					if (!priQueue.contains(n) && !visited.contains(n)) {
						priQueue.add(n);
						n.setParent(current);
						n.setH(t);
					}
				}
				for (Node node : current.getChildrenNodes()) {
					if (node.getLabel() == start) {
						node.setParent(null);
						priQueue.clear();
						visited.clear();
						priQueue.add(node);
						node.setH(node.getH() + current.getH());
					}
				}
			}
		}
		return null;
	}

	class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH();
			Double h2 = o2.getH();
			int result = h1.compareTo(h2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}
}
