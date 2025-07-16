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
	
	// Time Complexity: O(6^4) = O(1296) due to nested loops for each digit
    // but O(6!) = O(720) for permutations is more significant
    // Space Complexity: O(6) for the digits array + O(6) for the isUsed array + O(2) for remainingDigits array + O(2) for secondCases array
	public static String solution(int A, int B, int C, int D, int E, int F){
        int[] digits = {A, B, C, D, E, F};
        Arrays.sort(digits);
        String earliestTime = null;

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(j == i) continue;
                int h1 = digits[i];
                int h2 = digits[j];
                int hour = h1 * 10 + h2;
                if(hour >= 24) continue;

                boolean[] isUsed = new boolean[6];
                isUsed[i] = true;
                isUsed[j] = true;

                for(int k = 0; k < 6; k++){
                    if(isUsed[k]) continue;
                    for(int l = 0; l < 6; l++){
                        if(isUsed[l] || l == k) continue;
                        int m1 = digits[k];
                        int m2 = digits[l];
                        int minute = m1 * 10 + m2;
                        if(minute >= 60) continue;

                        isUsed[k] = true;
                        isUsed[l] = true;

                        int[] remainingDigits = new int[2];
                        int index = 0;
                        for(int m = 0; m < 6; m++){
                            if(!isUsed[m]){
                                remainingDigits[index] = digits[m];
                                index++;
                            }
                        }
                        int s1 = remainingDigits[0];
                        int s2 = remainingDigits[1];
                        int[] secondCases = {s1 * 10 + s2, s2 * 10 + s1};
                        for(int second : secondCases){
                            if(second < 60){
                                String time = String.format("%02d:%02d:%02d", hour, minute, second);
                                if(earliestTime == null || time.compareTo(earliestTime) < 0){
                                    earliestTime = time;
                                }
                            }
                        }

                        isUsed[k] = false;
                        isUsed[l] = false;
                    }
                }
            }
        }

        return earliestTime != null ? earliestTime : "NOT POSSIBLE";
    }
}
