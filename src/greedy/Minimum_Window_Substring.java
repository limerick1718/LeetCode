package greedy;

public class Minimum_Window_Substring {
	
	public String minWindow(String s, String t) {
		int[] map = new int[256];
		for(int i = 0; i < t.length(); i ++) {
			char charAt = t.charAt(i);
			map[charAt] ++;
		}
		int left = 0;
		int right = 0;
		int minLength = Integer.MAX_VALUE;
		int counter = t.length();
		int head = 0;
		int end = 0;
		while (right < s.length()) {
			if (map[s.charAt(right++)]-->0) {
				counter--;
			}
			while (counter == 0) {
				if (right - left < minLength) {
					head = left;
					end = right;
					minLength = right - head;
				}
				if (map[s.charAt(left++)]++==0) {
					counter ++;
				}
			}
		}
		if (minLength == Integer.MAX_VALUE) {
			return "";
		}
		else {
			return s.substring(head, end);
		}
	}

	public static void main(String[] args) {
		Minimum_Window_Substring minimum_Window_Substring = new Minimum_Window_Substring();
		String minWindow = minimum_Window_Substring.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(minWindow);
	}

}
