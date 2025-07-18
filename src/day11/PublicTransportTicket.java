package day11;

public class PublicTransportTicket {
	public static void main(String[] args) {
		int[] testCase1 = {1, 2, 4, 5, 7, 29, 30};
		int[] testCase2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int[] testCase3 = {2, 5, 6, 9, 15, 23, 27};
        int[] testCase4 = {1, 2, 3, 28, 29, 30};
        int[] testCase5 = {2, 5, 9, 15, 18, 23, 37};
        int[] testCase6 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        
		System.out.println("Min total cost for tickets: " + solution(testCase1));
		System.out.println("Min total cost for tickets: " + solution(testCase2));
		System.out.println("Min total cost for tickets: " + solution(testCase3));
		System.out.println("Min total cost for tickets: " + solution(testCase4));
		System.out.println("Min total cost for tickets: " + solution(testCase5));
		System.out.println("Min total cost for tickets: " + solution(testCase6));
	}
	
	// This method calculates the minimum cost of public transport tickets.
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int solution(int[] A){
        int n = A.length;
        if (n == 0) {
            return 0; // No tickets to process
        }
        int oneDayTicketCost = 2;
        int sevenDayTicketCost = 7;
        int thirtyDayTicketCost = 25;

        int[] costs = new int[n + 1];

        for(int i = 0; i < n; i++){
            // Option 1: Buy a one-day ticket
            int cost1 = costs[i] + oneDayTicketCost;

            // Option 2: Buy a seven-day ticket
            int j = i;
            while(j >= 0 && (A[j] >= A[i] - 6)){
                j--;
            }
            int cost7 = costs[j + 1] + sevenDayTicketCost;

            // Option 3: Buy a thirty-day ticket
            // input considers 30 days only --> option 3 always give $25

            // Choose the minimum cost option
            costs[i + 1] = Math.min(cost1, Math.min(cost7, thirtyDayTicketCost));
        }
        return costs[n];
    }
}
