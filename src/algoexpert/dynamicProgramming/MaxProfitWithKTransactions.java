package algoexpert.dynamicProgramming;

public class MaxProfitWithKTransactions {

    public static void main(String[] args) {

        int[] prices = new int[]{5,11,3,50,60,90};
        int k = 2;
        System.out.println(maxProfitWithKTransactions(prices,k));
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {

        if(prices.length==0 || k==0){
            return 0;
        }

        int[][] profit = new int[k+1][prices.length];

        for(int t=0 ; t < k+1 ;t++ ){
            int maxPrevDelta = Integer.MIN_VALUE;
            for(int p=0; p < prices.length ;p++){
                if(t==0 || p==0){
                    profit[t][p] = 0;
                }else{
                    int prevDayProfit = profit[t][p-1];
                    int prevDayPrevTransactionProfit = profit[t-1][p-1] - prices[p-1];
                    maxPrevDelta = Math.max(maxPrevDelta,prevDayPrevTransactionProfit);
                    int profitIfSellToday = prices[p] + maxPrevDelta;
                    int currentProfit = Math.max(prevDayProfit,profitIfSellToday);
                    profit[t][p] = currentProfit;
                }
            }
        }
        return profit[k][prices.length-1];
    }
}
