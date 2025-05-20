package ServiceFiles;

import java.io.IOException;
import java.util.Scanner;
/*
I use this class in order to manage all functions for the user management:
register new user, check for existing user, password validation, etc.
In future this class needs to be upgraded with all checks:
valid username, valid password,
 */
public class UserManagement {
	public int registeredUser(String registeredUser) throws IOException {
		Scanner sc = new Scanner(System.in);
		Users user = new Users();
		boolean isRegistered = false;
		int userId = -1;
		if (registeredUser.equals("y")) {
			System.out.println("Please Sign in!");
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();
			isRegistered = user.isValidUser(username, password);
			if(isRegistered){
				System.out.println("User successfully signed in!");
				userId = user.getId(username, password);
			}
			return userId;
		} else {
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();
			isRegistered = user.newUser(username, password);
			if (isRegistered){
				System.out.println("User successfully registered!");
				userId = user.getId(username, password);
			}
			return userId;
			/*I do not require the user to repeat the password.
			In order not to complicate the code.
			 */
		}
	}
}