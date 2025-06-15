package day6;

public class Main {
	public static void main(String[] args) {
		GeneralTree tree = new GeneralTree();
		Node root = new Node();
		
		root.value = 1;
		
		tree.root = root;
		
		Node node = new Node();
		node.value = 30;
		
		tree.root.children.add(node);
		
		node = new Node();
		node.value = 40;
		
		tree.root.children.add(node);
		
		node = new Node();
		node.value = 10;
		
		tree.root.children.get(1).children.add(node);
		
		node = new Node();
		node.value = 90;
		
		tree.root.children.get(1).children.get(0).children.add(node);
		
		Node node10 = tree.findNode(10);
		System.out.println(node10.value);
		
		Node node90 = tree.findNode(90);
		System.out.println(node90.value);
	}
}
