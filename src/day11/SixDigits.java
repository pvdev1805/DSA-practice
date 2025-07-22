package day11;

import java.util.Arrays;

public class SixDigits {
	public static void main(String[] args) {
		System.out.println(solution(1, 2, 3, 4, 5, 6)); // Expected: "12:34:56"
		System.out.println(solution(0, 0, 0, 0, 0, 0)); // Expected: "00:00:00"
		System.out.println(solution(2, 3, 4, 5, 6, 7)); // Expected: "23:46:57"
		System.out.println(solution(1, 1, 1, 1, 1, 1)); // Expected: "11:11:11"
		System.out.println(solution(1, 8, 3, 2, 6, 4)); // Expected: "12:36:48"
		System.out.println(solution(0, 0, 0, 7, 8, 9)); // Expected: "07:08:09"
		System.out.println(solution(2, 4, 5, 9, 5, 9)); // Expected: "NOT POSSIBLE"
	}
	
	// Time Complexity: O(6 * 10) = O(60) for counting sort (the worst case: A, B, C, D, E, F are all digit 9) and O(6) for the final check
    // Space Complexity: O(10) for the countDigits array and O(6) for the digits array
    public static String solution(int A, int B, int C, int D, int E, int F){
        int[] countDigits = new int[10];
        countDigits[A]++;
        countDigits[B]++;
        countDigits[C]++;
        countDigits[D]++;
        countDigits[E]++;
        countDigits[F]++;

        int[] digits = new int[6];
        int index = 0;
        // Counting Sort the digits
        for(int i = 0; i < 10; i++){
            while(countDigits[i] > 0){
                digits[index] = i;
                index++;
                countDigits[i]--;
            }
        }

        for(int i = digits.length - 1; i >= 0; i -= 2){
            int limit = i / 2 > 0 ? 59 : 23; // 59 for seconds and minutes, 23 for hours

            int value = digits[i-1] * 10 + digits[i];
            if(value <= limit){
                continue;
            }

            // The smaller digit must be on the left side
            if(digits[i-1] > digits[i]){
                swap(digits, i-1, i);
            }
            boolean isValid = false;
            for(int j = i - 2; j >= 0; j--){
                if(digits[j] * 10 + digits[i] <= limit){
                    swap(digits, j, i - 1);
                    isValid = true;
                    break;
                }
            }
            if(!isValid){
                return "NOT POSSIBLE";
            }
        }
        return String.format("%02d:%02d:%02d", digits[0] * 10 + digits[1], digits[2] * 10 + digits[3], digits[4] * 10 + digits[5]);
    }
    
    // Time Complexity: O(1) for swapping two elements in the array
    // Space Complexity: O(1) for the temporary variable
    public static void swap(int[] digits, int i, int j) {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
