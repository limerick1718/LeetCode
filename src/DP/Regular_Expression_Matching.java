package DP;

/***
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * @author limerick1718
 *
 */
public class Regular_Expression_Matching {
/**
 * This is wrong solution. exclude the case below:
 * 		"aab", "c*a*b"
 * because "a" match "a*" when text ignore "c*" in pattern.
 * 	public boolean isMatch(String text, String pattern) {
		boolean[][] dp = new boolean[text.length()][pattern.length()];
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < pattern.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
					continue;
				}
				if (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
					continue;
				}
				if (pattern.charAt(j) == '*'
						&& (text.charAt(i) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
					dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
					continue;
				}
				dp[i][j] = false;
			}
		}
		return dp[text.length() - 1][pattern.length() - 1];
	}
*/
	public boolean isMatch(String text, String pattern) {
		/**
		 * This matrix represent if pattern[0 ~ j] match text[0 ~ i]
		 */
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		/**
		 * This is coresponse to the case below:
		 * if (text == "" && pattern == "") return true;
		 */
		dp[0][0] = true;
		/**
		 * start from i = 0 since no pattern match text
		 */
		for (int i = 0; i <= text.length(); i ++) {
			for (int j = 1; j <= pattern.length(); j ++) {
				
				int textCursor = i - 1;//real cursor point in text
				int patternCursor = j - 1;//real cursor point in pattern
				
				/*
				 * i > 0 for valid comparison between text and pattern
				 */
				if (i > 0 && (text.charAt(textCursor) == pattern.charAt(patternCursor) || pattern.charAt(patternCursor) == '.')) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				if (pattern.charAt(patternCursor) == '*') {
					/*
					 * i == 0 for text not match with pattern, thus both * and the character before it will be discard. Just judge according to j-2
					 */
					if ( i == 0 || (text.charAt(textCursor) != pattern.charAt(patternCursor - 1) && pattern.charAt(patternCursor - 1) != '.')) {
						dp[i][j] = dp[i][j - 2];
					} else {
						/*
						 * for text "abcc" pattern "a*b*"
						 * dp[i - 1][j] for text match more than one 'a'
						 * dp[i][j - 1] for text match one 'a'
						 * dp[i][j - 2] for text match no letter
						 */
						dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
					}
				}
			}
		}
		return dp[text.length()][pattern.length()];
	}
	
	public static void main(String[] args) {
		Regular_Expression_Matching regular_Expression_Matching = new Regular_Expression_Matching();
		boolean match = regular_Expression_Matching.isMatch("aab", "c*a*b");
		System.out.println(match);
	}
}
