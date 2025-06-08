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
		if(head == null) return;
		head = head.next;
	}
	
	@Override
	public void popBack() {
		if(head == null) return;
		if(head.next == null) {
			head = null;
			return;
		}
		Node currentNode = head;
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}
	
	@Override
	public void delete(int k) {
		int quantity = countNodes();
		if(k < 1 || k > quantity) {
			System.out.println("Error: Deletion is INVALID at this position.");
			return;
		}
		
		if(k == 1) {
			popFront();
		} else {
			Node temp = head;
			for(int i = 1; i < k - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		
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
