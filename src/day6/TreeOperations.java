package day6;

public interface TreeOperations {
	// Find a node having a specific value on the tree
	Node findNode(int value);
	
	/**
	 * Insert a new node having a targetValue as a child node to another node 
	 * having a parentNodeValue and has already been available in the tree
	 * @param parentNodeValue
	 * @param targetValue
	 */
	void insert(int parentNodeValue, int targetValue);
}
