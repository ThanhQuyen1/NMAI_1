package lab8;

public class test {
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		nodeA.addChild(nodeC);
		nodeA.addChild(nodeB);
		nodeA.addChild(nodeD);
		Node nodeE = new Node("E",3);
		Node nodeF = new Node("F",12);
		Node nodeG = new Node("G",8);
		nodeB.addChild(nodeE);
		nodeB.addChild(nodeF);
		nodeB.addChild(nodeG);
		Node nodeH = new Node("H",2);
		Node nodeI = new Node("I",4);
		Node nodeJ = new Node("J",6);
		nodeC.addChild(nodeH);
		nodeC.addChild(nodeI);
		nodeC.addChild(nodeJ);
		Node nodeK = new Node("K", 14);
		Node nodeL = new Node("L",5);
		Node nodeM = new Node("M",2);
		nodeD.addChild(nodeK);
		nodeD.addChild(nodeL);
		nodeD.addChild(nodeM);
		ISearchAlgo minimax = new MiniMaxSearchAlgo();
		minimax.execute(nodeA);
	}

}
