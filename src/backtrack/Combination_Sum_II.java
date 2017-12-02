package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		findCombine(list, new ArrayList<>(), candidates, target, 0, 0);
		return list;
	}

	private void findCombine(List<List<Integer>> list, ArrayList<Integer> comb, int[] candidates, int target, int sum,
			int pos) {
		if (sum == target) {
			list.add(new ArrayList<>(comb));
			return;
		}
		for (int j = pos; j < candidates.length; j++) {
			if (j > pos && candidates[j] == candidates[j - 1]) continue;//ignore the duplicates
			if (sum + candidates[j] <= target) {
				comb.add(candidates[j]);
				findCombine(list, comb, candidates, target, sum + candidates[j], j + 1);
				comb.remove(comb.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		Combination_Sum_II combination_Sum = new Combination_Sum_II();
		List<List<Integer>> combinationSum = combination_Sum.combinationSum2(candidates, target);
		combinationSum.forEach(obj -> System.out.println(obj));
	}

}
