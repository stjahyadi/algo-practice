import java.util.HashSet;
import java.util.Set;

public class ValidParentheses {
	public static void main(String[] args) {
		//String data = "(1+1)+{1+2}";
		String data = "(1+1)+{1+2)";
		System.out.println(isValid(data));
	}

	public static boolean isValid(String input) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c))
				continue;
			else if ('+' == c || '*' == c || '/' == c || '-' == c)
				continue;
			else {
				switch (c) {
				case '{':
					set.add('{');
					break;
				case '[':
					set.add('[');
					break;
				case '(':
					set.add('(');
					break;
				case '}':
					set.remove('{');
					break;
				case ']':
					set.remove('[');
					break;
				case ')':
					set.remove('(');
					break;
				}
			}
		}

		if (set.size() == 0)
			return true;

		return false;
	}
}
