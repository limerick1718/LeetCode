package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

	public List<String> generateParenthesis(int n) {
		List<String> arrayList = new ArrayList<>();
		addParentheses(arrayList, new StringBuilder(), 0, 0, n);
		return arrayList;
	}

	private void addParentheses(List<String> arrayList, StringBuilder sb, int left, int right, int n) {
		if (left == n && right == n) {
			arrayList.add(sb.toString());
			return;
		}
		if (left < n && right <= left) {
			addParentheses(arrayList, sb.append("("), left + 1, right, n);
			sb.setLength(sb.length() - 1);
		}
		if (right < n) {
			addParentheses(arrayList, sb.append(")"), left, right + 1, n);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		Generate_Parentheses generate_Parentheses = new Generate_Parentheses();
		List<String> generateParenthesis = generate_Parentheses.generateParenthesis(3);
		generateParenthesis.forEach(obj -> System.out.println(obj));
	}

}
