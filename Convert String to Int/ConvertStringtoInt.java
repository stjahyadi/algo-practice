
public class ConvertStringtoInt {

	public static void convertStringToInteger() {
		String str = "123";
		int result = 0;
		String tmp = str;
		if (str.contains("-"))
			tmp = tmp.replace("-", "");
		for (int i = 0; i < tmp.length(); i++) {
			// Subtract 48 from the current digit 
			result = result * 10 + (tmp.charAt(i) - '0');
		}
		if (str.contains("-"))
			result *= -1;
		System.out.println(result);
	}

	public static void main(String[] args) {
		convertStringToInteger();
	}
}
