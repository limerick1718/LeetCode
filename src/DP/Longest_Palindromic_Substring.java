package DP;

public class Longest_Palindromic_Substring {
	
	public String longestPalindrome(String s) {
		int length = s.length();
		int left = 0;
		int right = 0;
		int maxLength = Integer.MIN_VALUE;
		boolean[][] dp = new boolean[length][length];
		for (int i = length - 1; i >= 0; i --) {
			for (int j = i; j < length; j ++) {
				dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <3 ||dp[i + 1][j - 1]);
				if (dp[i][j] && j - i + 1> maxLength ) {
					maxLength = j - i + 1;
					left = i;
					right = j;
				}
			}
		}
		return s.substring(left, right + 1);
	}

	public static void main(String[] args) {
		Longest_Palindromic_Substring longest_Palindromic_Substring = new Longest_Palindromic_Substring();
		String longestPalindrome = longest_Palindromic_Substring.longestPalindrome("cbbd");
		System.out.println(longestPalindrome);
	}

}
