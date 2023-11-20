package lab7;

public class Test {
	public static void main(String[] args) {
		Node node = new Node();
		node.generateBoard();
		node.displayBoard();
		System.out.println("-------------");
		GA_NQueenAlgo ga = new GA_NQueenAlgo();
		ga.execute().displayBoard();
	}
	
}
