package day4;

public interface LinkedListOperations {
	// Traverse through the singly linked List and print out value of each node
	void traverse();
	
	// Insert a new node at the beginning of the  linked list
	void pushFront(int value);
	
	// Insert a new node at the end of the linked list
	void pushBack(int value);
	
	// Insert a new node to the k-th position in the linked list
	void insert(int value, int k);
	
	// Delete the node at the beginning position of the linked list
	void popFront();
	
	// Delete the node at the ending position of the linked list
	void popBack();
	
	// Delete the node at the k-th position of the linked list
	void delete(int k);
	
	// Count the number of nodes available in the linked list
	int countNodes();
}
