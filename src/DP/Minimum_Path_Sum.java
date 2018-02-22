package DP;

/***
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author limerick1718
 *
 */
public class Minimum_Path_Sum {
	
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] path = new int[n][m];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if (i == 0 && j == 0) {
					path[i][j] = grid[i][j];
					continue;
				}
				if (i == 0) {
					path[i][j] = path[i][j - 1] + grid[i][j];
					continue;
				}
				if (j == 0) {
					path[i][j] = path[i - 1][j] + grid[i][j];
					continue;
				}
				path[i][j] = Math.min(path[i][j - 1] + grid[i][j], path[i - 1][j] + grid[i][j]);
			}
		}
		return path[n - 1][m - 1];
	}

	public static void main(String[] args) {

	}
}
