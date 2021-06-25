
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 3, 5, 7, 8 };
		int n = nums1.length;
		int[] nums2 = { 2, 3, 6, 9, 10 };
		int m = nums2.length;

		int[] nums3 = new int[n + m];

		for (int i = 0; i < n; i++) {
			nums3[i] = nums1[i];
		}
		for (int i = n; i < nums3.length; i++) {
			nums3[i] = nums2[i - n];
		}
		// Arrays.sort(nums3);
		sort(nums3);
		print(nums3);
		print(merge(nums1, nums2));

	}
	
	public static int[] merge(int[] foo, int[] bar) {
		//Merge Sort 
		//Only work with sorted array / non-decreasing order
		int fooLength = foo.length;
		int barLength = bar.length;

		int[] merged = new int[fooLength + barLength];

		int fooPosition, barPosition, mergedPosition;
		fooPosition = barPosition = mergedPosition = 0;

		while (fooPosition < fooLength && barPosition < barLength) {
			if (foo[fooPosition] < bar[barPosition]) {
				merged[mergedPosition++] = foo[fooPosition++];
			} else {
				merged[mergedPosition++] = bar[barPosition++];
			}
		}

		while (fooPosition < fooLength) {
			merged[mergedPosition++] = foo[fooPosition++];
		}

		while (barPosition < barLength) {
			merged[mergedPosition++] = bar[barPosition++];
		}

		return merged;
	}

	public static void sort(int arr[]) {
		// Insertion Sort O(n^2)
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(", ");
			else
				System.out.print("\n");
		}
	}

}
