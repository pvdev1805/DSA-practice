package day11;

public class CalculateTheSquare {
	public static void main(String[] args) {
		System.out.println(solution(10, 20));
		System.out.println(solution(6000, 7000));
	}
	
	// This method finds the maximum integer i such that there exists an integer x where a <= x^(2^i) <= b.
	// Time complexity: O(30 * b^(1/(2^i))
	// Space complexity: O(1)
    public static int solution(int a, int b){
        for(int i = 30; i >= 1; i--){
            long exponent = 1L << i;
            long maxBase = (long) Math.ceil(Math.pow(b, 1.0 / exponent));
            for(long base = 1; base <= maxBase; base++){
                long currentValue = binaryExponentiation(base, exponent);
                if(currentValue > b){
                    break;
                }
                if(currentValue < a) {
                    continue;
                }
                if(currentValue >= a && currentValue <= b){
                	// System.out.println(currentValue);
                    return i;
                }
            }
        }
        return 0;
    }
    
    // This method calculates the power of a base raised to an exponent using binary exponentiation.
    // Time complexity: O(log n)
    // Space complexity: O(1)
    private static long binaryExponentiation(long base, long exponent){
        long result = 1;
        while(exponent > 0){
            if(exponent % 2 == 1){
                result *= base;
            }
            exponent /= 2;
            base *= base;
        }
        return result;
    }
}
