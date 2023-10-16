package tuan2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> visited = new ArrayList<Node>();
		frontier.add(root);
		visited.add(root);
		double totle = 0;
		List<Node> listNode = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				
				
				return current;
			}
			for(Edge e : current.getChildren()) {
			for (Node n : current.getChildrenNodes()) {
				if (!visited.contains(n) && !frontier.contains(n)) {
					n.setParent(current);
					listNode.add(current);
					visited.add(n);
					frontier.add(n);
					
					totle = e.getWeight();
						n.setPathCost(totle);
						
					}
				}
			}

		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		frontier.add(root);
		visited.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
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
