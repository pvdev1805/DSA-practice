package day2;

public class OptimizingFarthestDifferent {
	
	// Solution 1: Two Pointer 
	// Time Complexity: O(N)
	// Space Complexity: O(1)
	public static int solution(int[] a) {
		int n = a.length;
		if(n == 1) return 0;
		
		if(a[0] != a[n-1]) return n - 1;
		
		int left = 0, right = n - 1;
		
		// if a[left] == a[right]
		while(left + 1 <= right && a[left + 1] == a[left]) {
			left++;
		}
		if(left == n - 1) return 0;
		left++;
		
		while(right - 1 >= left && a[right - 1] == a[right]) {
			right--;
		}
		right--;
		
		return Math.max(n - 1 - left, right);
	}
	
	public static void main(String[] args) {
		int[] testCase1 = {4, 6, 2, 2, 6, 6, 4};
		int[] testCase2 = {1, 1, 1, 7, 1, 1, 7, 1, 1, 1, 1};
		
		System.out.println(solution(testCase1));
		System.out.println(solution(testCase2));
	}
}
