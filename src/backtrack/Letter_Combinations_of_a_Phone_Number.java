package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
	public List<String> letterCombinations(String digits) {
		List<String> arrayList = new ArrayList<String>();
		if ("".equals(digits)) return arrayList;
		List<String> trans = new ArrayList<String>();
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		char[] charArray = digits.toCharArray();
		for (int i = 0; i < charArray.length ; i++ ) {
			char c = charArray[i];
			String string = mapping[Character.getNumericValue(c)];
			if ("0".equals(string) || "1".equals(string)) continue;
			trans.add(string);
		}
		findCombines(arrayList, trans, new StringBuilder(), 0, 0);
		return arrayList;
	}
	
	private void findCombines(List<String> arrayList, List<String> trans, StringBuilder sb, int pos, int curs) {
		if (pos == trans.size()) {
			arrayList.add(sb.toString());
			return;
		}
		for (int i = curs; i < trans.get(pos).length(); i ++) {
			char[] charArray = trans.get(pos).toCharArray();
			sb.append(charArray[i]);
			findCombines(arrayList, trans, sb, pos + 1, curs);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		Letter_Combinations_of_a_Phone_Number letter_Combinations_of_a_Phone_Number = new Letter_Combinations_of_a_Phone_Number();
		List<String> letterCombinations = letter_Combinations_of_a_Phone_Number.letterCombinations("23");
		letterCombinations.forEach(obj->System.out.println(obj));
	}

}
