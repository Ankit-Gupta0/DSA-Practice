package dailyDsa;

public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {7,5,6,8,2,6};
        System.out.println(profit(prices));

    }
    static public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(prices[i] < prices[j]) {
                    maxProfit = Math.max((prices[j] - prices[i]), maxProfit);
                }
            }
        }
        return maxProfit;
    }
    // O(n)
    static int profit(int[] arr) {
        int lpsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lpsf > arr[i]) {
                lpsf = arr[i];
            }
            pist = arr[i] - lpsf;
            if (op < pist) {
                op = pist;
            }
        }
        return op;
    }
 }
