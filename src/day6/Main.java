package day6;

public class Main {
	public static void main(String[] args) {
		GeneralTree tree = new GeneralTree();
		tree.insert(0, 1);
		//      1
		
		tree.insert(1, 3);
		//      1
		//     /
		//    3
		
		
		tree.insert(1, 4);
		//      1
		//     / \
		//    3  4
		
		tree.insert(4, 10);
		//      1
		//     / \
		//    3   4
		//         \
		//          10
		
		tree.insert(10, 17);
		//      1
		//     / \
		//    3   4
		//         \
		//          10
		//           \
		//            17
		
		tree.insert(3, 7);
		tree.insert(3, 9);
		//       1
		//     /  \
		//    3    4
		//   / \    \
		//  7   9    10
		//            \
		//             17
		
		tree.insert(7, 11);
		tree.insert(7, 18);
		//       1
		//      /  \
		//     3    4
		//    / \    \
		//   7   9    10
		//  / \         \
		// 11 18        17
		
		Node node10 = tree.findNode(10);
//		Node node10 = tree.findNodeBFS(10);
		System.out.println( "Address: " + node10 +" - Value: " + node10.value);
		
		Node node17 = tree.findNode(17);
//		Node node17 = tree.findNodeBFS(17);
		System.out.println("Address: " + node17 +" - Value: " + node17.value);
		
		Node node18 = tree.findNode(18);
		System.out.println("Address: " + node18 +" - Value: " + node18.value);
		
		System.out.println();
		
		tree.postOrderTraversal(tree.root);
		System.out.println();
		
		tree.postOrderTraversal(tree.findNode(3));
		System.out.println();
		
	}
}
