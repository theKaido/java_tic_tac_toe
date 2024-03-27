package entree;

import java.util.Scanner;

public class Entree {

	//METHODS STATIC
	public static int readInt(Scanner scan) {
		String entree = scan.nextLine();
		int result = -1;
		
		try {
			result = Integer.parseInt(entree);
		} catch (NumberFormatException e) {
		}
		
		return result;
	}
	
}
