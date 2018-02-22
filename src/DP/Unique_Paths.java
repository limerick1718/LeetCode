package DP;

/***
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there? Note: m and n will be at most 100.
 * 
 * @author limerick1718
 *
 */
public class Unique_Paths {
	public int uniquePaths(int m, int n) {
		int[][] dis = new int[m][n];
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if (i == 0 || j == 0) {
					dis[i][j] = 1;
					continue;
				}
				dis[i][j] = dis[i - 1][j] + dis[i][j - 1];
			}
		}
		return dis[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Unique_Paths unique_Paths = new Unique_Paths();
		int uniquePaths = unique_Paths.uniquePaths(2, 2);
		System.out.println(uniquePaths);
	}

}
