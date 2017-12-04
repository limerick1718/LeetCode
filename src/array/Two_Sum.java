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
		//the result
		int[] result = new int[2];
		//key: value; value: position
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    //loop the numbers
	    for (int i = 0; i < numbers.length; i++) {
	    	//if map contains the residue -- find the answer
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        //still does not find the res pair, go ahead
	        map.put(numbers[i], i);
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
