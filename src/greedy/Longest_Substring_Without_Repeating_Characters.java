package greedy;

import javax.imageio.ImageTypeSpecifier;

public class Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {
		int[] map = new int[256];
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map[s.charAt(i)] == 0) {
				map[s.charAt(i)]++;
				counter ++;
			}
		}
		int left = 0, right = 0, begin = 0, end = 0;
		int max = Integer.MIN_VALUE;
		while (left < s.length()) {
			if (map[s.charAt(right ++)] -- == 0) {
				counter--;
			}
			while (counter == 0) {
				if (right - left >  max) {
					max = right - left;
					begin = left;
					end = right;
				}
				if (map[s.charAt(left ++)] ++ == 1) {
					counter ++;
				}
			}
		}
		if (max == Integer.MIN_VALUE) {
			return s.length();
		}
		else {
			return end - begin;
		}

	}

	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters longest_Substring_Without_Repeating_Characters = new Longest_Substring_Without_Repeating_Characters();
		int lengthOfLongestSubstring = longest_Substring_Without_Repeating_Characters.lengthOfLongestSubstring("abcabcbb");
		System.out.println(lengthOfLongestSubstring);
	}

}
