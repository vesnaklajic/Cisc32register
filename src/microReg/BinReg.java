package microReg;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinReg {

	public static void main(String[] args) {

		Scanner sci = new Scanner(System.in);
		int n = sci.nextInt();
		
		
		while (n<=100 && n != 0) {
			// reserve a string place for register
			String[] register = new String[32];
			// set all the values to "?"
			for (int i = 0; i < 32; i++) {
				register[i] = "?";
			}

			// input n commands
			for (int j = 0; j < n; j++) {
				// readCommand;
				Scanner sc = new Scanner(System.in);
					
				String test = sc.nextLine();
				
				System.out.println(test);
				//spliting command into tokens
				String[] tokens = test.split("\\s");
				//making string varibles out of tokens
				String commandStr = tokens[0];
				int placeLeft = Integer.parseInt(tokens[1]);
				int placeRight = 0;
				try {
					placeRight = Integer.parseInt(tokens[2]);
				} catch (Exception e) {
				}
				// change register;
				switch (commandStr) {
				case "CLEAR":
					register[31 - placeLeft] = "0";
					break;
				case "SET":
					register[31 - placeLeft] = "1";
					break;
				case "OR":
					if ((register[31 - placeLeft].equalsIgnoreCase("1"))
							|| (register[31 - placeRight].equalsIgnoreCase("1"))) {
						register[31 - placeLeft] = "1";
					} else
						register[31 - placeLeft] = "?";
					break;
				case "AND":
					if ((register[31 - placeLeft].equalsIgnoreCase("1"))
							&& (register[31 - placeRight].equalsIgnoreCase("1"))) {
						register[31 - placeLeft] = "1";
					} else
						register[31 - placeLeft] = "?";
					break;
				}
			} // for
			// print register;
			for (int i = 0; i < 32; i++) {
				System.out.print(register[i]);
			}
			n = sci.nextInt();
		} // while

	}// PSVM

}
