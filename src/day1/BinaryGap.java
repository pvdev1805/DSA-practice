package day1;

public class BinaryGap {
	// Solution 1:
	// Time Complexity: O(logN)
	// Space Complexity: O(logN)
	public static String binaryConversion(int n) {
		if(n == 0) return "0";
		
		StringBuilder result = new StringBuilder();
		
		while(n > 0) {
			result.insert(0, n%2);
			n /= 2;
		}
		
		return result.toString();
	}
	
	public static int Solution1(int n) {
		String binary = binaryConversion(n);
		if(binary == "0") return 0;
		
		int cnt = 0, result = 0;
		for(int i = 1; i < binary.length(); i++) {
			if(binary.charAt(i) == '0') {
				++cnt;
			} else if(binary.charAt(i) == '1') {
				result = Math.max(result, cnt);
				cnt = 0;
			}
		}
		return result;
	}
	// End - Solution 1
	
	// Solution 2: Bit Manipulation
	// Time Complexity: O(logN)
	// Space Complexity: O(1)
	public static int Solution2(int n) {
		if(n == 0) return 0;
		int cnt1 = 0, cnt0 = 0, result = 0;
		
		while(n > 0) {
			if((n & 1) == 1) {
				cnt1++;
				if(cnt1 == 2) {
					result = Math.max(cnt0, result);
					cnt0 = 0;
					cnt1 = 1;
				}
			} else if((n & 1) == 0 && cnt1 == 1) {
				cnt0++;
			}
			n >>= 1;
		}
		
		return result;
	}
	// End - Solution 2
	
	public static void main(String[] args) {
		int testCase1 = 9;
		int testCase2 = 529;
		int testCase3 = 20;
		int testCase4 = 15;
		int testCase5 = 32;
		
		System.out.printf("%d = %s --> has %s binary gap(s).\n", testCase1, binaryConversion(testCase1) , Solution1(testCase1));
		System.out.printf("%d = %s --> has %s binary gap(s).\n", testCase2, binaryConversion(testCase2) , Solution1(testCase2));
		System.out.printf("%d = %s --> has %s binary gap(s).\n", testCase3, binaryConversion(testCase3) , Solution1(testCase3));
		System.out.printf("%d = %s --> has %s binary gap(s).\n", testCase4, binaryConversion(testCase4) , Solution1(testCase4));
		System.out.printf("%d = %s --> has %s binary gap(s).\n", testCase5, binaryConversion(testCase5) , Solution1(testCase5));
		
		System.out.println(Solution2(testCase1));
		System.out.println(Solution2(testCase2));
		System.out.println(Solution2(testCase3));
		System.out.println(Solution2(testCase4));
		System.out.println(Solution2(testCase5));
	}
}
