package tuan2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		Set<Node> visited = new HashSet<Node>();
		frontier.add(root);
		visited.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			for (Node n : current.getChildrenNodes()) {
				if (!visited.contains(n) && !frontier.contains(n)) {
					n.setParent(current);
					visited.add(n);
					frontier.add(n);
					for(Edge e : current.getChildren()) {
						n.setPathCost(e.getWeight());
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		Set<Node> visited = new HashSet<Node>();
		frontier.add(root);
		visited.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			
			for (Node n : current.getChildrenNodes()) {
				if (n.getLabel().equals(start)) {
					frontier.clear();
					visited.clear();
					execute(n, goal);
				}
			}
		}
		return null;
	}

}
