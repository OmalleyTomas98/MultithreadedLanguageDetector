package ie.gmit.sw;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Tomas O'Malley
 * @version 2.0
 * @since 1.8
 * 
 * 
 * 
 *        Public class <b>MENU</b> holds the user interface where the user and main
 *        internals of the program meet.
 * 
 *
 */

public class Menu {

	public static void start() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object

		// input for the menu
		int userInput = 0;
		String lang =null;

		try {
			while (userInput != 2) {

				/**
				 * Program Header Greeting the Client and summarizing the Programs nature 
				 */
				// User Prompt
				System.out.println("********************************************");
				System.out.println("*		                           *");
				System.out.println("* Dept- Computer Science & Applied Physics *");
				System.out.println("*         Text Language Dectector          *");
				System.out.println("*	 	                           *");
				System.out.println("********************************************");

				System.out.println("Press 1.Detect langauge  \nPress 2.To Quit Program");
				userInput = myObj.nextInt();// Ask user for input f1or program

				switch (userInput) {
				// calls method for parsing the file

				/**
				 * Switch case statement for user to progress to detect language or exit on entering 2.
				 */
				case 1:
					System.out.println("Enter WILI Data Location>");
					String db = myObj.nextLine(); // Read user input
					System.out.println("db  entered: " + db); // Output user input
					System.out.println("Building subject database ... please wait... /n");

					System.out.println("Enter Query File Location>");
					String queryFile = myObj.nextLine(); // Read user input
					System.out.println("The text appears to be written in" + lang);
					
					Parser.analyseQuery(queryFile);
					
					// exits the program through a break
				case 2:
					System.out.println("Exiting....");
					break;
				default:
					System.out.println("Invalid input in menu try again");
				}// switch

			} // while

			// try and catch in Case the user enters char ,float etc instead of expected
			// input (1 or 2)
		} catch (InputMismatchException e) {
			System.out.println("ERROR \n Please restart Program");
			userInput = 0;
		} // catch
	}// start
}// menu