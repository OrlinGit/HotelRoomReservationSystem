package models;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/*
This is an abstract class that will be used to set the frame for the different user types in the system.
I am using the ID as string as it works fine with the system and I currently do not need it as other format.
If there is future need the ID can be parsed into UUID object again and used as such.
I created the abstract class as package-private as would like ot work with it and his subclasses
accessible only form the package itself.
 */
public abstract class User {
	private UUID USERID;
	private String username;
	private String password;
	private String role;

	public User (){
	}

	public User(String username, String password, String role) {
		this.USERID = UUID.randomUUID();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/*
	I need to implement a check for existing users!
	If user is already created not to register it again.
	 */
	String pathUsersFile = "F:\\Coding\\Sirma Academy\\GitDocs\\" +
						   "HotelRegistrationSystem\\abstract_branch\\" +
						   "HotelRoomReservationSystem\\src\\" +
						   "storage\\Users.csv";
	public String setNewUser() {
		User newUser = this;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(pathUsersFile, true));
			writer.write( newUser.USERID + "," + newUser.username + "," + newUser.password + "," + newUser.role);
			writer.newLine();
			writer.close();
			return String.valueOf(this.USERID);
		} catch (IOException String) {
			throw new RuntimeException("File not accessible!");
		}

	}

	public String getUserID(String username, String password, String inputRole) throws FileNotFoundException {
		String userId = null;
		BufferedReader reader = new BufferedReader(new FileReader(pathUsersFile));
		try {
			String line = reader.readLine();
			while (line != null) {
				if(line.contains(username)) {
					String[] user = line.split(",");
					String name = user[1];
					String pass = user[2];
					String role = user[3];
					if (name.equals(username) && pass.equals(password) && role.equals(inputRole)) {
						userId = user[0];
						return userId;
					}
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			System.out.println("File is empty!");
		}
		return userId;
	}

	/*
	This was left from the previous version of the system when the count of the registered users was used to set userID.
	It still can return the number of the registered users. As both Employees and Guest are stored in the same file,
	it will be the same count. If we would like to have them separate we need to create two file and make the program to
	read the different files.
	 */
	public int usersCount() throws IOException {
		int count = (int) Files.lines(Paths.get(pathUsersFile)).count();
		return count;
	}

}
