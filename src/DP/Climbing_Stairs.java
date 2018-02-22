package DP;

/***
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * @author limerick1718
 *
 */
public class Climbing_Stairs {
	
	public int climbStairs(int n) {
		int[] fib = new int[n + 1];
		for (int i = 0; i <= n; i ++) {
			if (i == 0 || i == 1) {
				fib[i] = 1;
				continue;
			}
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static void main(String[] args) {

	}
}
