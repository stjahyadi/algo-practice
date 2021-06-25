
public class RemoveDuplicateSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		print(nums, removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int pointer = 0;
		for (int i = 1; i < n; i++) {
			if (nums[pointer] != nums[i]) {
				pointer++;
				nums[pointer] = nums[i];
			}

		}
		return pointer + 1;
	}

	public static void print(int[] nums, int end) {
		for (int i = 0; i < end; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
	}
}
