import java.util.HashMap;
import java.util.Map;

public class StringExpression {

	public static String stringExpression(String str) {
		Map<String, String> input = new HashMap<String, String>();
		input.put("zero", "0");
		input.put("one", "1");
		input.put("two", "2");
		input.put("three", "3");
		input.put("four", "4");
		input.put("five", "5");
		input.put("six", "6");
		input.put("seven", "7");
		input.put("eight", "8");
		input.put("nine", "9");

		Map<String, String> output = new HashMap<String, String>();
		output.put("negative", "-");
		output.put("0", "zero");
		output.put("1", "one");
		output.put("2", "two");
		output.put("3", "three");
		output.put("4", "four");
		output.put("5", "five");
		output.put("6", "six");
		output.put("7", "seven");
		output.put("8", "eight");
		output.put("9", "nine");

		int n = str.length();
		String val = "";
		String num = "";
		String lastOperator = "";
		Integer total = 0;
		Integer tmp = 0;
		for (int i = 0; i < n; i++) {
			val += str.charAt(i);
			if (input.containsKey(val)) {
				num += input.get(val);
				val = "";
			}

			if ("minus".equals(val)) {
				tmp = Integer.parseInt(num);
				lastOperator = val;
				num = "";
				val = "";
			} else if ("plus".equals(val)) {
				tmp = Integer.parseInt(num);
				lastOperator = val;
				num = "";
				val = "";
			}

			if (i == n - 1) {
				if ("minus".equals(lastOperator)) {
					total = tmp - ((!"".equals(num)) ? Integer.parseInt(num) : 0);
				} else if ("plus".equals(lastOperator)) {
					total = tmp + ((!"".equals(num)) ? Integer.parseInt(num) : 0);
				}
			}
		}

		String totalStr = String.valueOf(total);
		str = "";
		for (int i = 0; i < totalStr.length(); i++) {
			if (output.containsKey("" + totalStr.charAt(i))) {
				str += output.get("" + totalStr.charAt(i));
			}
		}
		return str;
	}

	public static void main(String[] args) {
//		System.out.println(stringExpression("onezeropluseight"));
//		System.out.println(stringExpression("oneminusoneone"));
		System.out.println(stringExpression("foursixminustwotwoplusonezero"));
	}
}
