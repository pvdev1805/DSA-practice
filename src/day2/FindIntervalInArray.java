package day2;

import java.util.HashMap;

public class FindIntervalInArray {
	
	// Solution: Sliding Window
	// Time Complexity: O(N)
	// - N = a.length
	// Space Complexity: O(N + M) --> O(N)
	// - M = freq.size()
	public static int solution(int[] a, int l, int r) {
		int n = a.length;
		int minLength = 1000000001;
		int inRangeQuantity = 0;
		int range = r - l + 1;
		
		HashMap<Integer, Integer> freq = new HashMap<>();
		
		int leftPtr = 0;
		for(int rightPtr = 0; rightPtr < n; rightPtr++) {
			int rightNum = a[rightPtr];
			
			if(freq.containsKey(rightNum)) {
				freq.put(rightNum, freq.get(rightNum) + 1);
			} else {
				freq.put(rightNum, 1);
			}
			
			if((rightNum >= l && rightNum <= r) && (freq.get(rightNum) == 1)) {
				inRangeQuantity++;
			}
			
			while(inRangeQuantity == range && leftPtr <= rightPtr) {
				minLength = Math.min(minLength, rightPtr - leftPtr + 1);
				
				int leftNum = a[leftPtr];
				freq.put(leftNum, freq.get(leftNum) - 1);
				
				if(freq.get(leftNum) == 0) {
					freq.remove(leftNum);
				}
				
				if(leftNum >= l && leftNum <= r) {
					inRangeQuantity--;
				}
				
				leftPtr++;
			}
		}
		
		return minLength == 1000000001 ? -1 : minLength;
	}
	// End - Solution
	
	
	
	public static void main(String[] args) {
		int[] a1 = {2, 1, 4, 3, 2, 1, 1, 4};
		int l1 = 2, r1 = 4;
		
		int[] a2 = {109, 1, 1, 1, 1, 1, 108};
		int l2 = 108, r2 = 109;
		
		int[] a3 = {1, 3, 5, 7};
		int l3 = 3, r3 = 5;
		
		System.out.println(solution(a1, l1, r1));
		System.out.println(solution(a2, l2, r2));
		System.out.println(solution(a3, l3, r3));
	}
}
