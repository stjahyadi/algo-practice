import java.util.ArrayList;
import java.util.List;

public class LRUCache {

	public static String lruCache(String[] strArr) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strArr.length; i++) { //O(n)
			String var = strArr[i];
			if (list.indexOf(var) == -1) {
				list.add(var);
			} else {
				list.remove(var);
				int size = list.size();
				list.add(size, var);
			}
		}

		if (list.size() > 5) {
			list = list.subList(list.size() - 5, list.size());
		}
		String result = "";
		for (String str : list) { //O(n)
			if (!result.contains(str)) {
				if (result.isEmpty())
					result = result + str;
				else
					result = result + "-" + str;
			}
		}
		// O(n) + O(n) = O(2n)
		return result;
	}

	public static void main(String[] args) {
		// EXPECTED: C-A-B
		System.out.println(lruCache(new String[] { "A", "B", "A", "C", "A", "B" }));
		// EXPECTED: E-D-Q-Z-C
		System.out.println(lruCache(new String[] { "A", "B", "C", "D", "E", "D", "Q", "Z", "C" }));
		// EXPECTED: C-A-E-D-Z
		System.out.println(lruCache(new String[] { "A", "B", "C", "D", "A", "E", "D", "Z" }));
	}
}
