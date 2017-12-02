package DP;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
		getSubset(arrayList, new ArrayList<>(), 0, nums);
		return arrayList;
    }
	
	private void getSubset(List<List<Integer>> arrayList, ArrayList<Integer> list, int cursor, int[] nums) {
		arrayList.add(new ArrayList<>(list));
		for (int i = cursor; i < nums.length; i ++) {
			list.add(nums[cursor]);
			getSubset(arrayList, list, cursor + 1, nums);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = new int[] {1,2,3};
		List<List<Integer>> result = subsets.subsets(nums);
		result.forEach(obj->System.out.println(obj));
	}
	
	

}
