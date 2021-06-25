import java.util.HashMap;
import java.util.Map;

public class CashWithdrawalMachine {

	public static void main(String[] args) {
		//Case 1
		Map<Integer, Integer> availableNotes = new HashMap<Integer, Integer>();
//		availableNotes.put(2, 99);
//		availableNotes.put(5, 99);
//		availableNotes.put(10, 99);
//		availableNotes.put(50, 99);
//		availableNotes.put(100, 99);
//		int withdrawalAmount = 15;
		// Expected Output
		// 10 1
		// 5 1
		
		//Case 2
//		availableNotes.put(2, 0);
//		availableNotes.put(5, 0);
//		availableNotes.put(10, 99);
//		int withdrawalAmount = 5;
		// Expected Output -> ATM cannot fulfill the withdrawal due to insufficient notes.
		
		//Case 3
		availableNotes.put(2, 0);
		availableNotes.put(5, 99);
		availableNotes.put(10, 4);
		availableNotes.put(50, 0);
		int withdrawalAmount = 50;
		// Expected Output
		// 10 4
		// 5 2
		printMap(withdraw(availableNotes, withdrawalAmount));
	}

	public static Map<Integer, Integer> withdraw(Map<Integer, Integer> availableNotes, int withdrawalAmount) {
		Map<Integer, Integer> output = new HashMap<Integer, Integer>();
		Integer notes = null;
		Integer count = null;
		while (withdrawalAmount > 0) {
			for (Map.Entry<Integer, Integer> entry : availableNotes.entrySet()) {
				if (entry.getKey() <= withdrawalAmount && entry.getValue() > 0) {
					notes = entry.getKey();
					count = 1;
				}
			}
			if(notes == null) {
				break;
			}
			withdrawalAmount = withdrawalAmount - notes;
			if (output.containsKey(notes)) {
				output.put(notes, output.get(notes) + count);
			} else {
				output.put(notes, count);
			}
			availableNotes.put(notes, availableNotes.get(notes) - count);
			notes = 0;
			count = 0;
		}
		return output;
	}

	public static void printMap(Map<Integer, Integer> map) {
		if (map.isEmpty()) {
			System.out.println("ATM cannot fulfill the withdrawal due to insufficient notes.");
			return;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
