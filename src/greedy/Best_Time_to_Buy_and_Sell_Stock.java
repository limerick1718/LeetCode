package greedy;

public class Best_Time_to_Buy_and_Sell_Stock {
	
	public int maxProfit(int[] prices) {
		int max = 0;
		int length = prices.length;
		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		for (int i = 0; i < length; i ++) {
			int now = prices[i];
			if (now < left) {
				left = now;
				right = Integer.MIN_VALUE;
				continue;
			}
			if (now > right) {
				right = now;
				if (right - left > max) {
					max = right - left;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {7, 6, 4, 3, 1};
		Best_Time_to_Buy_and_Sell_Stock best_Time_to_Buy_and_Sell_Stock = new Best_Time_to_Buy_and_Sell_Stock();
		int maxProfit = best_Time_to_Buy_and_Sell_Stock.maxProfit(numbers);
		System.out.println(maxProfit);
	}

}
