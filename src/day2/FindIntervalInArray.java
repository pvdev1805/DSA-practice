package day2;

import java.util.HashMap;

public class FindIntervalInArray {
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
			freq.put(a[r], freq.getOrDefault(a[r], 0) + 1);
			
			if(range.containsKey(a[r]) && freq.get(a[r]).equals(range.get(a[r]))) {
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
	
	
	
	public static void main(String[] args) {
		
	}
}
