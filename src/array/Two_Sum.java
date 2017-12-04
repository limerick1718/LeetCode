package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 2017/12/4
 * @author limerick
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Two_Sum {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		// initialize the array with 2 size
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		//a hashMap to store the numbers visited
		for (int i = 0; i < numbers.length; i ++) {
			//if the residue of temporary visit number in map, we find the result
			if (hashMap.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = hashMap.get(target - numbers[i]);
				break;
			}
			//else, put it in map
			hashMap.put(numbers[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		Two_Sum two_Sum = new Two_Sum();
		int[] numbers = new int[] {2, 7, 11, 15};
		int target = 9;
		int[] twoSum = two_Sum.twoSum(numbers, target);
		for (int i : twoSum) {
			System.out.println(i);
		}
	}

}
