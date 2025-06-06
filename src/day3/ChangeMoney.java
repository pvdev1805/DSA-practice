package day3;

import java.util.Scanner;

public class ChangeMoney {
	
	// Solution: Greedy Algorithm
	// Time Complexity: O(9) --> O(1)
	// Space Complexity: O(1)
	// - Input size: O(1)
	// - Additional space for logic: O(11)
	public static int solution(int n) {
		if(n <= 0) return 0;
		int result = 0;
		int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		for(int i = 0; i < denominations.length; i++) {
			result += (n / denominations[i]);
			n %= denominations[i];
		}
		return result;
	}
	// End - Solution
	
	public static void main(String[] args) {
		System.out.print("Enter the amount of money: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.printf("The minimum number of dollar bills: %d\n", solution(n));
		
	}
}
