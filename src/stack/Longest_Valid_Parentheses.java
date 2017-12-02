package stack;

import java.util.LinkedList;

public class Longest_Valid_Parentheses {
	
	public int longestValidParentheses(String s) {
		LinkedList<Character> linkedList = new LinkedList<>();
		int max = 0;
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			length = putInStack(linkedList, s.charAt(i), length);
			if (length > max && linkedList.size() == 0) {
				max = length;
			}
			else if (length - linkedList.size() > max){
				max = length - linkedList.size();
			}
		}
		return max;
	}

	private int putInStack(LinkedList<Character> linkedList, Character character, Integer length) {
		if (character.equals('(')) {
			linkedList.add('(');
			length ++;
			return length;
		}
		Character pollLast = linkedList.pollLast();
		if (pollLast == null || pollLast != '(') {
			linkedList.clear();
			length = 0;
			return length;
		}
		length ++;
		return length;
	}

	public static void main(String[] args) {
		String s = "(()()(()()";
		Longest_Valid_Parentheses longest_Valid_Parentheses = new Longest_Valid_Parentheses();
		int longestValidParentheses = longest_Valid_Parentheses.longestValidParentheses(s);
		System.out.println(longestValidParentheses);
	}

}
