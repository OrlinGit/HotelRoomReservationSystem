import services.RoomManagement;
import services.UserManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		inputDialog();
		Scanner sc = new Scanner(System.in);
		System.out.print("Your choice: ");
		String userChoice = sc.nextLine();
		String validInput = validInput(userChoice);
		String userID = null;
		String employeeID = null;
		switch (validInput) {
			case "1":
				userID = logAsUser();
				break;
			case "2":
				visitor();
			case "3":
				userID = registerUser();
				break;
			case "4":
				employeeID = logAsEmployee();
				break;
			case "5":
				employeeID = registerEmployee();
				break;
			case "6":
				System.out.println("Have a good day!");
				System.exit(0);
				break;
		}

		System.out.println(employeeID);
	}
	/*
	This is just an initial dialog.
	 */
	public static void inputDialog() {
		System.out.println("""
				Hello to our Hotel management system!\
				
				If you are registered guest of our hotel enter 1.\
				
				If you are just visiting our site, enter 2.\
				
				If you would like to register as guest enter 3.\
				
				In case you are our employee login into the system enter 4.\
				
				For new employee registration enter 5.\
				
				Would you like ot exit the program, enter 6.\
				""");


	}

	/*
	This method checks if the input from the console is valid.
	 */
	public static String validInput(String input) {
		Scanner sc = new Scanner(System.in);
		List<String> validChoices = List.of("1", "2", "3", "4", "5", "6");
		while (!validChoices.contains(input)) {
			System.out.println("Your choice is not valid! Please choose again!");
			System.out.print("Your choice: ");
			input = sc.nextLine();
		}
		return input;
	}

	/*
	This method just prints all rooms in the hotel with their specifics.
	The only function available for non-registered users.
	 */
	public static void visitor() throws IOException {
		System.out.println("""
				As a non registered visitor you will see a full list of all our rooms.\
				""");
		RoomManagement rm = new RoomManagement();
		rm.allRooms();
	}

	/*
	This method registers new user. Returns String with the userID.
	 */
	public static String registerUser() throws FileNotFoundException {
		UserManagement user = new UserManagement();
		return user.registerUser();
	}

	/*
	This method checks if the user is already registered by checking if username and password exist and match with the
	database in Users.csv
	Return string with the userID.
	 */
	public static String logAsUser() throws IOException {
		UserManagement user = new UserManagement();
		return user.userLogIn();
	}

	/*
	This method checks if the user is already registered by checking if username and password exist and match with the
	database in Users.csv
	Return string with the userID.
	 */
	public static String logAsEmployee() throws FileNotFoundException {
	UserManagement user = new UserManagement();
	return user.employeeLogIn();
	}

	/*
	This functionality was build without safety measures. For now, it wis OK as I need just the functionality.
	All checks and validations will be added later.
	 */
	public static String registerEmployee() throws FileNotFoundException {
		UserManagement user = new UserManagement();
		return user.registerEmployee();
	}

	public void availableRooms(){}

	public void cancelReservation() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter room number to cancel reservation:");
		String roomNumber = sc.nextLine();
		RoomManagement room = new RoomManagement();
		double cancellationFee = room.cancelReservation(roomNumber);
		System.out.println("You cancellation fee is: " + cancellationFee);
	}

	public void bookRoom(){}


}
