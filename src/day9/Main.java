package day9;

public class Main {
	public static void main(String[] args) {
        int[] nums = {1, 5, 6, 3, 8, 9, 10, 23, 4, 2};
        BST tree = new BST();
        tree.buildBST(nums);
        tree.printBST();
    }
}
