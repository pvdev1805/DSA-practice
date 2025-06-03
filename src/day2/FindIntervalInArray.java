package day2;

import java.util.HashMap;

public class FindIntervalInArray {
	
	// Solution: Sliding Window
	// Time Complexity: O(N)
	// - N = a.length
	// Space Complexity: O(m + k)
	// - m = freq.size()
	// - k = r - l + 1
	public static int s1(int[] a, int l, int r) {
		int n = a.length;
		HashMap<Integer, Integer> range = new HashMap<>();
		for(int i = l; i <= r; i++) {
			range.put(i, 1);
		}
		
		int minLength = Integer.MAX_VALUE;
		int inRangeQuantity = 0;
		int requiredCount = r - l + 1;
		
		HashMap<Integer, Integer> freq = new HashMap<>();
		
		int leftPtr = 0;
		for(int rightPtr = 0; rightPtr < n; rightPtr++) {
			int rightNum = a[rightPtr];
			freq.put(rightNum, freq.getOrDefault(rightNum, 0) + 1);
			
			if(range.containsKey(rightNum) && freq.get(rightNum).equals(range.get(rightNum))) {
				inRangeQuantity++;
			}
			
			while(inRangeQuantity == requiredCount && leftPtr <= rightPtr) {
				minLength = Math.min(minLength, rightPtr - leftPtr + 1);
				
				int leftNum = a[leftPtr];
				freq.put(leftNum, freq.get(leftNum) - 1);
				if(range.containsKey(leftNum) && freq.get(leftNum) < range.get(leftNum)) {
					inRangeQuantity--;
				}
				leftPtr++;
			}
		}
		
		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
	// End - Solution
	
	public static void main(String[] args) {
		int[] a1 = {2, 1, 4, 3, 2, 1, 1, 4};
		int l1 = 2, r1 = 4;
		
		int[] a2 = {109, 1, 1, 1, 1, 1, 108};
		int l2 = 108, r2 = 109;
		
		int[] a3 = {1, 3, 5, 7};
		int l3 = 3, r3 = 5;
		
		System.out.println(s1(a1, l1, r1));
		System.out.println(s1(a2, l2, r2));
		System.out.println(s1(a3, l3, r3));
	}
}
