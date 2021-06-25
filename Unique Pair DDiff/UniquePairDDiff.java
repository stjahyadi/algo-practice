import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePairDDiff {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		int d = 1;
		// Expected Output -> 4 (1,2) (2,3) (3,4) (4,5)

//		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1, 5));
//		int d = 2;
		// Expected Output -> 2 (1,3) and (3,5)

//		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(-1, -2, -3));
//		int d = 1;
		// Expected Output -> 2 (-1,-2) and (-2,-3)
		System.out.println(findUniqueDDiffPairs(arr, d));
	}

	public static int findUniqueDDiffPairs(List<Integer> arr, int d) {
		int output = 0;
		List<String> dummy = new ArrayList<String>();
		for (int i = 0; i < arr.size(); i++) {
			int pointer = i + 1;
			while (pointer < arr.size()) {
				String data = String.valueOf(arr.get(i) + "," + arr.get(pointer));
				if ((Math.abs(arr.get(i) - arr.get(pointer))) == d && !dummy.contains(data)) {
					dummy.add(data);
					output++;
				}
				pointer++;
			}
		}
		printList(dummy);
		return output;
	}

	public static void printList(List<String> arr) {
		for (String str : arr) {
			System.out.println(str);
		}
	}
}
