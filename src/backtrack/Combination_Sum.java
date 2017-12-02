package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);//sth new
		calCombinationSum(list, new ArrayList<>(), candidates, 0, 0, target);
		return list;
	}

	private void calCombinationSum(List<List<Integer>> list, ArrayList<Integer> comb, int[] candidates, int pos,
			int sum, int target) {
		if (sum == target) {
			list.add(new ArrayList<>(comb));
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			if (sum + candidates[i] <= target) {
				comb.add(candidates[i]);
				calCombinationSum(list, comb, candidates, i, sum + candidates[i], target);
				//the use of i as pos, only visit the one after i position
				comb.remove(comb.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = new int[] {2, 3, 6, 7};
		int target = 7;
		Combination_Sum combination_Sum = new Combination_Sum();
		List<List<Integer>> combinationSum = combination_Sum.combinationSum(candidates, target);
		combinationSum.forEach(obj->System.out.println(obj));
		
	}

}
