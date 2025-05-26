package ServiceFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
I use this class in order to manage all functions for the user management:
register new user, check for existing user, password validation, etc.
In future this class needs to be upgraded with all checks:
valid username, valid password,
I have created separate methods for Employee and for Guests. They have the same code but have separate methods,
as they are different objects with different functions. They need to be separated.
 */
public class UserManagement {
	public String registeredUser(String availableRegistration) throws IOException {
		Scanner sc = new Scanner(System.in);
		String isRegistered = null;
		if (availableRegistration.equals("y")) {
			System.out.println("Please Sign in!");
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();
			isRegistered = checkGuest(username, password);
			System.out.println("User successfully signed in!");
		} else {
			isRegistered = registerGuest();
		}
		return isRegistered;
	}

	protected String checkEmployee(String username, String password) throws FileNotFoundException {
		Employee employee = new Employee();
		return employee.getUserID(username, password);
	}

	protected String checkGuest(String username, String password) throws FileNotFoundException {
		Guest guest = new Guest();
		return guest.getUserID(username, password);
	}

	protected String registerEmployee() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String userID = null;
		System.out.println("Enter username:");
		String username = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		Employee newEmployee = new Employee(username, password);
		boolean isRegistered = newEmployee.setNewUser();
		if (isRegistered) {
			System.out.println("User successfully registered!");
			userID = newEmployee.getUserID(username, password);
		}
		return userID;
	}

	protected String registerGuest() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String userID = null;
		System.out.println("Enter username:");
		String username = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		Guest newGuest = new Guest(username, password);
		boolean isRegistered = newGuest.setNewUser();
		if (isRegistered) {
			System.out.println("User successfully registered!");
			userID = newGuest.getUserID(username, password);
		}
		return userID;
	}

	protected boolean isValidUser(String username, String password) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Users.csv"));
		try {
			String line = reader.readLine();
			while (line != null) {
				String[] user = line.split(",");
				String name = user[1];
				String pass = user[2];
				if (name.equals(username) && pass.equals(password)) {
					return true;
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			System.out.println("File is empty!");
		}

		return false;
	}
}