package day4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList linkedList = new SinglyLinkedList();
        
        boolean exit = false;
        
        do {
			printMenu();
			System.out.print("Enter your option (0-8): ");
			int opt = sc.nextInt();
			
			switch (opt) {
			case 1: 
				System.out.print("Enter the value of the new node: ");
				int pushFrontValue = sc.nextInt();
				linkedList.pushFront(pushFrontValue);
				break;
			case 2:
				System.out.print("Enter the value of the new node: ");
				int pushBackValue = sc.nextInt();
				linkedList.pushBack(pushBackValue);
				break;
			case 3:
				System.out.print("Enter the value of the new node: ");
				int insertValue = sc.nextInt();
				System.out.print("Enter the index ( 0 <= index <= the length of linked list) of the new node: ");
				int insertIndex = sc.nextInt();
				linkedList.insert(insertValue, insertIndex);
				break;
			case 4:
				linkedList.popFront();
				break;
			case 5:
				linkedList.popBack();
				break;
			case 6:
				System.out.print("Enter the index ( 0 <= index < the length of linked list) of the node: ");
				int deleteIndex = sc.nextInt();
				linkedList.delete(deleteIndex);
				break;
			case 7:
				linkedList.traverse();
				break;
			case 8:
				int quantity = linkedList.countNodes();
				System.out.printf("The singly linked list has: %d nodes.\n", quantity);
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("INVALID option! Please enter the valid option (0-8)!\n");
			}
		} while (!exit);
        
        sc.close();
        
        System.out.println("Exit - DONE");
    }
    
    public static void printMenu() {
		System.out.println("\n!----------- MAIN MENU -----------!");
		System.out.println("1. Insert a new node at the beginning of the  linked list.");
		System.out.println("2. Insert a new node at the end of the linked list.");
		System.out.println("3. Insert a new node to the index-th position ( 0 <= index <= the length of linked list) in the linked list.");
		System.out.println("4. Delete the node at the beginning position of the linked list.");
		System.out.println("5. Delete the node at the ending position of the linked list.");
		System.out.println("6. Delete the node at the index-th position ( 0 <= index < the length of linked list) of the linked list.");
		System.out.println("7. Traverse through the singly linked List and print out value of each node.");
		System.out.println("8. Count the number of nodes available in the linked list.");
		System.out.println("0. Exit.");
		System.out.println("!---------------------------------!\n");
	}
}
