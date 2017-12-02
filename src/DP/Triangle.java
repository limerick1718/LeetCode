package DP;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	public int minimumTotal(List<List<Integer>> triangle) {
		int result = 0;
		int size = triangle.size();
		List<Integer> minPath = triangle.get(size - 1);
		for (int i = size - 2; i >= 0 ; i --) {
			for (int j = 0; j < i; j ++) {
				minPath.set(j, Math.min(minPath.get(j), minPath.get(j + 1)));
			}
		}
		return minPath.get(0);
	}

	public static void main(String[] args) {
Triangle triangle = new Triangle();
List<List<Integer>> tri = new ArrayList<List<Integer>>();
int minimumTotal = triangle.minimumTotal(tri);
System.out.println(minimumTotal);
	}

}
