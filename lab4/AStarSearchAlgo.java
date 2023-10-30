package lab4.inform.student;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> priQueue = new PriorityQueue<Node>( new NodeComparator());
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
				if (!list.contains(end) && !priQueue.contains(end)) {
					end.setG(cost + current.getG());
					end.setParent(current);
					list.add(end);
					priQueue.add(end);
				}else if (priQueue.contains(end) && end.getG() > current.getG() + cost) {
					end.setG(current.getG() + cost);
					end.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> priQueue = new PriorityQueue<Node>( new NodeComparator());
		Set<Node> list = new HashSet<Node>();
		priQueue.add(root);
		list.add(root);
		while (!priQueue.isEmpty()) {
			Node current = priQueue.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			List<Edge> children = current.getChildren();
			for (Edge e : children) {
				Node end = e.getEnd();
				double cost = e.getWeight();
				if (!list.contains(end) && !priQueue.contains(end)) {
					end.setG(cost + current.getG());
					end.setParent(current);
					priQueue.add(end);
				}
			}
			for (Node node : current.getChildrenNodes()) {
				if (node.getLabel().equals(start)) {
					node.setParent(null);
					priQueue.clear();
					list.clear();
					priQueue.add(node);
					node.setH(node.getH()+ current.getH());
				}
			}
		}
		return null;
	}
	class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getG();
			Double h2 = o2.getG();
			int result = h1.compareTo(h2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}
}
