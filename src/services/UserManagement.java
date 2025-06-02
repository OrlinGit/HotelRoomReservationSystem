package services;

import models.Employee;
import models.Guest;

import java.io.FileNotFoundException;
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
	public String userLogIn() throws IOException {
		Scanner sc = new Scanner(System.in);
		String userID;
		System.out.println("Enter username:");
		String username = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		userID = getUserID(username, password);
		System.out.println("User successfully signed in!");
		return userID;
	}

	public String employeeLogIn() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String employeeID;
		System.out.println("Enter username:");
		String username = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		employeeID = getEmployeeID(username, password);
		System.out.println("User successfully signed in!");
		return employeeID;
	}

	protected String getUserID(String username, String password) throws FileNotFoundException {
		Guest guest = new Guest();
		return guest.getUserID(username, password);
	}

	public String registerEmployee() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String userID = null;
		System.out.println("Enter username:");
		String username = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		Employee newEmployee = new Employee(username, password);
		userID = newEmployee.setNewUser();
		System.out.println("Employee successfully registered!");
		return userID;
	}
	protected String getEmployeeID(String username, String password) throws FileNotFoundException {
		Employee employee = new Employee();
		return employee.getEmployeeID(username, password);
	}

	public String registerUser() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String userID = null;
		System.out.println("Enter username:");
		String username = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		Guest newGuest = new Guest(username, password);
		System.out.println("User successfully registered!");
		return userID = newGuest.setNewUser();
	}

}