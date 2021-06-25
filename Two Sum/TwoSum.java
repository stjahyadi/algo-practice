import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 1 };
		int target = 6;
		int[] output = twoSum(nums, target);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		//Brute Force with time complexity O(n^2) and space complexity O(1)
		/*
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		*/
		
		//Use two-pointer with time complexity O(n*log(n)) due to sort
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target)
				return new int[] { left, right };
			else if (nums[left] + nums[right] < target)
				left++;
			else
				right++;
		}
		
		
		//Time complexity O(n) and space complexity O(n)
		/*
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		*/
		throw new IllegalArgumentException("No Solution!");
	}
}
