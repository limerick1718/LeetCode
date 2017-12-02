package stack;

import java.util.HashMap;
import java.util.LinkedList;

public class Valid_Parentheses {
	public boolean isValid(String s) {
		HashMap<Character,Character> initMap = initMap();
		LinkedList<Character> linkedList = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i ++) {
			char charAt = s.charAt(i);
			if (initMap.containsKey(charAt)) {
				linkedList.add(charAt);
				continue;
			}
			Character peekLast = linkedList.peekLast();
			Character character = initMap.get(peekLast);
			if (character == null || character != charAt) {
				return false;
			}
			linkedList.pollLast();
		}
		if (linkedList.size() != 0) {
			return false;
		}
		return true;
	}
	
	private HashMap<Character,Character> initMap(){
		HashMap<Character,Character> hashMap = new HashMap<>();
		hashMap.put('(', ')');
		hashMap.put('[', ']');
		hashMap.put('{', '}');
		return hashMap;
	}

	public static void main(String[] args) {
		String s = "[";
		Valid_Parentheses valid_Parentheses = new Valid_Parentheses();
		boolean valid = valid_Parentheses.isValid(s);
		System.out.println(valid);
	}

}
