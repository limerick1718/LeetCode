package stack;

import java.util.LinkedList;

public class Evaluate_Reverse_Polish_Notation {
	
	public int evalRPN(String[] tokens) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < tokens.length; i ++) {
			cal(linkedList, tokens[i]);
		}
		return linkedList.peek();
	}
	
	private void cal(LinkedList<Integer> linkedList, String token) {
		if ("+".equals(token)) {
			Integer a = linkedList.pollLast();
			Integer b = linkedList.pollLast();
			linkedList.add(a + b);
			return;
		}
		if ("-".equals(token)) {
			Integer a = linkedList.pollLast();
			Integer b = linkedList.pollLast();
			linkedList.add(b - a);
			return;
		}
		if ("*".equals(token)) {
			Integer a = linkedList.pollLast();
			Integer b = linkedList.pollLast();
			linkedList.add(a * b);
			return;
		}
		if ("/".equals(token)) {
			Integer a = linkedList.pollLast();
			Integer b = linkedList.pollLast();
			linkedList.add(b / a);
			return;
		}
		Integer integer = new Integer(token);
		linkedList.add(integer);
	}

	public static void main(String[] args) {
		String[] tokens = new String[] {"4", "13", "5", "/", "+"};
		Evaluate_Reverse_Polish_Notation evaluate_Reverse_Polish_Notation = new Evaluate_Reverse_Polish_Notation();
		int evalRPN = evaluate_Reverse_Polish_Notation.evalRPN(tokens);
		System.out.println(evalRPN);
	}

}
