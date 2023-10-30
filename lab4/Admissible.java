package lab4.inform.student;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Admissible {

	private Queue<Node> frontier = new LinkedList<Node>();
	private Set<Node> explored = new HashSet<Node>();
	private boolean result = true;

	public boolean isAdmissibleH(Node tree, String goal) {
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node curr = frontier.poll();
			explored.add(curr);
			Node nodeRe = execute(curr, goal);
			// if nodeRe == null => kh có đường đi => tự quy ước true => tiếp tục đệ quy
			if (nodeRe != null) {
				if (curr.getH() > nodeRe.getG())
					return false;

				for (Node child : curr.getChildrenNodes())
					if (!explored.contains(child) && !frontier.contains(child)) {
						child.setParent(null);
						child.setG(0);
						result = result && isAdmissibleH(child, goal);
						if (!result)
							return result;
					}
			}
		}
		return true;
	}

	private Node execute(Node curr, String goal) {
		// TODO Auto-generated method stub
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
