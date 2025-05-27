package day1;

import java.util.Arrays;

public class SameSumDice {
	// Solution1:
	// Time Complexity: O((M+N) * log(M+N)) --> O(N * logN)
	// Space Complexity: O(M+N) --> O(N)
	public static int Solution1(int[] a, int[] b) {
		int n = a.length, m = b.length;
		int sumA = 0, sumB = 0;
		
		for(int num: a) {
			sumA += num;
		}
		
		for(int num: b) {
			sumB += num;
		}
		if(sumA == sumB) return 0;
		
		int[] biggerSumArr;
		int[] smallerSumArr;
		
		if(sumA > sumB) {
			biggerSumArr = a;
			smallerSumArr = b;
		} else {
			biggerSumArr = b;
			smallerSumArr = a;
		}
		
		int diffSum = Math.abs(sumA - sumB);
		
		int[] diffElements = new int[m+n];
		int idx = 0;
		
		for(int num: biggerSumArr) {
			diffElements[idx] = (num - 1);
			idx++;
		}
		
		for(int num: smallerSumArr) {
			diffElements[idx] = (6 - num);
			idx++;
		}
		
		Arrays.sort(diffElements);
		
		int cnt = 0;
		
		for(int i = m + n - 1; i > 0; i--) {
			cnt++;
			diffSum -= diffElements[i];
			if(diffSum <= 0) return cnt;
		}
		return -1;
	}
	// End - Solution1
	
	// Solution 2
	// Time Complexity: O(max(M, N, 5)) --> O(N)
	// Space Complexity: O(max(M, N, 5)) --> O(N)
	public static int Solution2(int[] a, int[] b) {
		int n = a.length, m = b.length;
		
		if((6*n < m) || (6*m < n)) return -1;
		
		int sumA = 0, sumB = 0;
		
		for(int num: a) {
			sumA += num;
		}
		
		for(int num: b) {
			sumB += num;
		}
		if(sumA == sumB) return 0;
		
		int[] biggerSumArr;
		int[] smallerSumArr;
		
		if(sumA > sumB) {
			biggerSumArr = a;
			smallerSumArr = b;
		} else {
			biggerSumArr = b;
			smallerSumArr = a;
		}
		
		int diffSum = Math.abs(sumA - sumB);
		
		int[] freq = new int[6];
		for(int num: biggerSumArr) {
			freq[num - 1]++;
		}
		for(int num: smallerSumArr) {
			freq[6 - num]++;
		}
		
		int cnt = 0;
		for(int i = 5; i >= 1; i--) {
			if(diffSum <= freq[i] * i) {
				cnt += (int) Math.ceil((double) diffSum/i );
				break;
			} else {
				diffSum -= freq[i] * i;
				cnt += freq[i];
			}
		}
		return cnt;
	}
	// End - Solution 2
	
	public static void main(String[] args) {
		// Test Case 1:
		int[] a1 = {5};
		int[] b1 = {1, 1, 6};
		
		// Test Case 2:
		int[] a2 = {2, 3, 1, 1, 2};
		int[] b2 = {5, 4, 6};
		
		// Test Case 3:
		int[] a3 = {5, 4, 1, 2, 6, 5};
		int[] b3 = {2};
		
		// Test Case 4:
		int[] a4 = {1, 2, 3, 4, 3, 2, 1};
		int[] b4 = {6};
		
		System.out.println(Solution1(a1, b1));
		System.out.println(Solution1(a2, b2));
		System.out.println(Solution1(a3, b3));
		System.out.println(Solution1(a4, b4));
		
		System.out.println();
		
		System.out.println(Solution2(a1, b1));
		System.out.println(Solution2(a2, b2));
		System.out.println(Solution2(a3, b3));
		System.out.println(Solution2(a4, b4));
	}
}
