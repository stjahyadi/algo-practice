import java.util.Scanner;

public class DiamondStructure {

	public static void printDiamond(int input) {
		int middle = Math.round((float) input / 2);
		int c = 64;
		for (int i = 1; i <= middle; i++) {
			for (int j = 1; j <= middle - i; j++) {
				System.out.print(" ");
			}
			c = c + 1;
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print((char) c);
			}
			System.out.println();
		}

		for (int i = input / 2; i >= 1; i--) {
			for (int j = 1; j <= middle - i; j++) {
				System.out.print(" ");
			}
			c = c + 1;
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print((char) c);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("User input: ");
		int i = in.nextInt();
		//for (int i = 1; i <= 10; i++) {
			printDiamond(i);
			//System.out.println();
		//}
		in.close();
	}

}
