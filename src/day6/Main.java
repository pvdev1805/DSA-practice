package day6;

public class Main {
	public static void main(String[] args) {
		GeneralTree tree = new GeneralTree();
//		Node root = new Node();
		
//		root.value = 1;
		
//		tree.root = root;
		tree.insert(0, 1);
		//      1
		
//		Node node = new Node();
//		node.value = 30;
		
//		tree.root.children.add(node);
		tree.insert(1, 30);
		//      1
		//     /
		//    30
		
		
//		node = new Node();
//		node.value = 40;
		
//		tree.root.children.add(node);
		tree.insert(1, 40);
		//      1
		//     / \
		//    30  40
		
//		node = new Node();
//		node.value = 10;
		
//		tree.root.children.get(1).children.add(node);
		tree.insert(40, 10);
		//      1
		//     / \
		//    30  40
		//         \
		//          10
		
//		node = new Node();
//		node.value = 90;
		
//		tree.root.children.get(1).children.get(0).children.add(node);
		tree.insert(10, 90);
		//      1
		//     / \
		//    30  40
		//         \
		//          10
		//           \
		//            90
		
//		Node node10 = tree.findNode(10);
		Node node10 = tree.findNodeBFS(10);
		System.out.println(node10.value);
		
//		Node node90 = tree.findNode(90);
		Node node90 = tree.findNodeBFS(90);
		System.out.println(node90.value);
	}
}
