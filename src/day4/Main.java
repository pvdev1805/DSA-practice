package day4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList linkedList = new SinglyLinkedList();

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            linkedList.pushBack(sc.nextInt());
        }

        System.out.println("Before deletion:");
        linkedList.traverse();
        System.out.println("Total nodes: " + linkedList.countNodes());

        System.out.println("Enter x (delete count) and y (skip count):");
        int x = sc.nextInt();
        int y = sc.nextInt();

        for (int i = 0; i < x; i++) {
            linkedList.delete(y + 1);
        }

        System.out.println("After deletion:");
        linkedList.traverse();
        System.out.println("Total nodes: " + linkedList.countNodes());
    }
}
