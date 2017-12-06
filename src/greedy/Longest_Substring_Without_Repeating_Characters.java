package greedy;

import java.util.HashMap;

import javax.swing.text.html.HTML;

/***
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
 * "pwke" is a subsequence and not a substring.
 * @author limerick
 *
 */
public class Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		int left = 0;
		int right = -1;
		int max = -1;
		for (int i = 0; i < charArray.length; i ++) {
			right = i;
			if (hashMap.containsKey(charArray[i])) {
				left = hashMap.get(charArray[i]);
				hashMap.remove(charArray[i]);
				max = Math.max(max, right - left);
			}
			hashMap.put(charArray[i], i);
			max = Math.max(max, right - left);
		}
		max = Math.max(max, right - left);
		if (left == -1) return hashMap.size();
		return max;
	}
	/***
	 * "aab"
	 * "a"
	 * "abcabcbb"
	 * "bbbbb"
	 * "pwwkew"
	 * "ccb"
	 * "abba"
	 * @param args
	 */
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters longest_Substring_Without_Repeating_Characters = new Longest_Substring_Without_Repeating_Characters();
		int lengthOfLongestSubstring = longest_Substring_Without_Repeating_Characters.lengthOfLongestSubstring("abba");
		System.out.println(lengthOfLongestSubstring);
	}

}
