package day11;

public class PublicTransportTicket {
	public static void main(String[] args) {
		int[] testCase1 = {1, 2, 4, 5, 7, 29, 30};
		System.out.println(solution(testCase1));
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
            j = i;
            while(j >= 0 && (A[j] >= A[i] - 29)){
                j--;
            }
            int cost30 = costs[j + 1] + thirtyDayTicketCost;

            // Choose the minimum cost option
            costs[i + 1] = Math.min(cost1, Math.min(cost7, cost30));
        }
        return costs[n];
    }
}
