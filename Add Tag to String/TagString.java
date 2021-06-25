
public class TagString {
	public static void main(String[] args) {
		//Expected: <bold>abc/bold>xyz<bold>123</bold>
//		String input = "abc,123";
//		String transformed = "abcxyz123";
		
		//Expected: <bold>aabbc</bold>c
		String input = "aa,bb,c";
		String transformed = "aabbcc";
		System.out.println(tagString(input, transformed));
	}

	public static String tagString(String input, String transformed) {
		String[] tmp = input.split(",");
		for (int i = 0; i < tmp.length; i++) {
			int start = transformed.indexOf(tmp[i]);
			if (start != -1) {
				int end = start + tmp[i].length();
				String replace = transformed.substring(start, end);
				transformed = transformed.replace(replace, "<bold>" + replace);
				transformed = transformed.replace(replace, replace + "</bold>");
			}
		}
		return transformed;
	}

}
