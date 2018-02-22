package DP;

/***
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * @author limerick1718
 *
 */
public class Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dis = new int[m][n];
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dis[i][j] = 0;
					continue;
				}
                if (i == 0 && j == 0) {
                    dis[i][j] = 1;
                    continue;
                }
				if (i == 0) {
					if (dis[i][j - 1] == 0) {
						dis[i][j] = 0;
						continue;
					}
					dis[i][j] = 1;
					continue;
				}
				if (j == 0) {
					if (dis[i - 1][j] == 0) {
						dis[i][j] = 0;
						continue;
					}
					dis[i][j] = 1;
					continue;
				}
				dis[i][j] = dis[i][j - 1] + dis[i - 1][j];
			}
		}
		return dis[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
