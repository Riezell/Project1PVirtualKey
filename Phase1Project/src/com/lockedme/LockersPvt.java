package com.lockedme;

import java.util.Scanner;
import java.io.File;

public class LockersPvt {

	public static void main(String[] args) {
		System.out.println("\n \n  \t\t\t=START=");

		System.out.println("\t\t*************************\n");
		System.out.println("\t \t  Welcome to LOCKED ME\n");
		System.out.println(" \t    Where Luxury Products Awaits You!\n");
		System.out.println("\t*****************************************\n");
		System.out.println("\t \t  BY: LOCKERS Pvt.Ltd\n");
		System.out.println(" \t \t \t******");
		System.out.println("\t\tDeveloper:Riezell Fanny Tacata");
		System.out.println("\t  \t   Software Touch Solutions");

		System.out.println();

		Scanner scan = new Scanner(System.in);
		String path = "E://Fanny//";

		File file;
		char et;
		char subOptions;
		try {
			do {
				System.out.println("Please Choose Option:\n" + "1: List of Files\n" + "2: Business Operations\n"
						+ "\tA: Add New File\n" + "\tB:Delete File\n" + "\tC:Search File\n"
						+ "\tD:Return to Main Menu\n" + "3: Close Application");

				int select = scan.nextInt();
				switch (select) {
				case 1: // list of files or option1
					path = "E://Fanny//";
					file = new File(path);
					System.out.println("Files list : ");
					if (file.list() != null) {
						for (String l : file.list()) {
							System.out.println(l);
						}
					} else {
						System.out.println("Directory is empty");
					}
					break;

				case 2: // option2
					while (true) {
						System.out.println("     A:Add File \n" + "     B: Delete File \n" + "     C: Search File \n"
								+ "     D: Return to Main Menu \n");

						subOptions = scan.next().charAt(0);
						switch (subOptions) {
						case 'A': // option a
						case 'a':
							System.out.println("Enter a File Name to Add");
							String newFileName = scan.next();
							path = "E://Fanny//";
							path = path + newFileName + ".txt";
							file = new File(path);
							if (file.createNewFile()) {
								System.out.println("File Successfully Created");
							}
							break;

						case 'B':// option b delete
						case 'b':
							System.out.println("Enter File Name to Delete");
							String deleteFileName = scan.next();
							path = "E://Fanny//";
							path = path + deleteFileName;
							file = new File(path);
							if (file.exists()) {
								if (file.delete()) {
									System.out.println("File Successfully Deleted");
								} else {
									System.out.println("Sorry File Not Deleted, File Not Found)");
								}
							}
							break;
						case 'C': // option c search
						case 'c':
							System.out.println("Enter File Name to  Search");
							String searchFileName = scan.next();
							path = "E://Fanny//";
							path = path + searchFileName;
							file = new File(path);
							if (file.exists()) {
								System.out.println("File Search Successfully ");
							} else {
								System.out.println("Sorry File not Found");
							}
							break;
						case 'D':
						case 'd':
							System.out.println("Go Back to Main and Navigate");
							break;
						default:
							System.out.println("Invalid, Pleae Try Again");
							break;
						}
						if (subOptions == 'E' || subOptions == 'e')
							;
						{
							break;
						}
					}
					break;

				case 3:
					System.out.println("You have Quitted");
					System.exit(0);
					break;
				default:
					System.out.println("Default, Try Again");

				}
				System.out.println("\nDo you want to continue? Type y or n \n");
				et = scan.next().charAt(0);

			} while (et == 'Y' || et == 'y');
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	static int validateUserInput(Scanner sc) throws UserInputException {
		int choice = sc.nextInt();
		if (choice != 1 || choice != 2 || choice != 3) {
			throw new UserInputException("Please Enter Correct Option");
		}
		return choice;
	}

}

class UserInputException extends Exception {
	UserInputException(String s) {
		super(s);
	}
}
