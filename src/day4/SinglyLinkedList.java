package day4;

public class SinglyLinkedList implements LinkedListOperations {
	private Node head;
	
	// Constructor of the SinglyLinkedList
	SinglyLinkedList(){}
	
	@Override
	public void traverse() {
		Node currentNode = head;
		while(currentNode.next != null) {
			System.out.println(currentNode.data + " --> ");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}
	
	@Override
	public void pushFront(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	@Override
	public void pushBack(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	@Override
	public void insert(int value, int k) {
		int quantity = countNodes();
		if(k < 1 || k > quantity + 1) {
			System.out.println("Error: Insertion is INVALID at this position.");
			return;
		}
		
		if(k == 1) {
			pushFront(value);
			return;
		}
		
		Node newNode = new Node(value);
		Node currentNode = head;
		for(int i = 1; i <= k - 2; i++) {
			currentNode = currentNode.next;
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
	}
	
	@Override
	public void popFront() {
		
	}
	
	@Override
	public void popBack() {
		
	}
	
	@Override
	public void delete(int k) {
		
	}
	
	@Override
	public int countNodes() {
		int count = 0;
		Node currentNode = head;
		while(currentNode != null) {
			currentNode = currentNode.next;
			count++;
		}
		return count;
	}
}
