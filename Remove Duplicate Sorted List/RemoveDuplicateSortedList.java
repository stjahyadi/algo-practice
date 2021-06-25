
public class RemoveDuplicateSortedList {
	public static void main(String[] args) {
		//ListNode l1 = arrayToList(new int[] { 1, 1, 2, 3, 3, 3 });
		//ListNode l1 = arrayToList(new int[] { 0, 0, 0, 0, 0 });
		ListNode l1 = arrayToList(new int[] { 0, 0, 0, 0, 3 });
		ListNode output = removeDuplicate(l1);
		printList(output);
	}
	
	public static ListNode removeDuplicate(ListNode head) {
		if(head == null)
			return null;
		
		ListNode current = head;
		while(current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			}else
				current = current.next;
		}
		return head;
	}
	
	public static void printList(ListNode root) {
		while (root != null) {
			System.out.print(root.val);
			if (root.next != null) {
				System.out.print(" --> ");
			}
			root = root.next;
		}
	}
	
	public static ListNode arrayToList(int[] nums) {
		ListNode node = new ListNode(0);
		ListNode head = node;

		for (int num : nums) {
			node.next = new ListNode(num);
			node = node.next;
		}

		return head.next;
	}
}
