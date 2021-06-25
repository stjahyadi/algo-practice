import java.util.LinkedList;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
		next = null;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeSortedList {
	public static void main(String[] args) {
		//ListNode l1 = arrayToList(new int[] { 1, 3, 8, 10 });
		//ListNode l2 = arrayToList(new int[] { 1, 4, 5, 6 });
		
		ListNode l1 = arrayToList(new int[] { 10, 20, 30 });
	    ListNode l2 = arrayToList(new int[] { 1, 2, 3 });
	    
		System.out.print("List1 = ");
		printList(l1);
		System.out.println();
		System.out.print("List2 = ");
		printList(l2);
		System.out.println();
		ListNode l3 = mergeSortedList(l1, l2);
		System.out.print("List3 = ");
		printList(l3);
		
		ListNode l4 = arrayToList(new int[] { 1, 4, 5 });
		ListNode[] nodes = new ListNode[] {l1, l2, l4};
		ListNode output = mergeSortedKList(nodes);
		System.out.print("Output = ");
		printList(output);
	}
	
	public static ListNode mergeSortedKList(ListNode[] listNodes) {
		if (listNodes.length == 0)
		      return null;
		
		Queue<ListNode> queue = new LinkedList<ListNode>();
		for(ListNode node : listNodes) queue.add(node);
		
		while(queue.size() > 1) {
			ListNode l1 = queue.remove();
			ListNode l2 = queue.remove();
			ListNode merged = mergeSortedList(l1, l2);
			queue.add(merged);
		}
		return queue.remove();
	}

	public static ListNode mergeSortedList(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		while(l1 != null || l2 != null) {
			if(l2 == null || (l1 != null && l1.val < l2.val)) {
				node.next = l1;
				l1 = l1.next;
			}else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		return head.next;
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

	public static void printList(ListNode root) {
		while (root != null) {
			System.out.print(root.val);
			if (root.next != null) {
				System.out.print(" --> ");
			}
			root = root.next;
		}
	}
}
