package ServiceFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
/*
I use this class separate from the management class to use only to
use as communication between my program and the files.
 */
public class Users {
	private String userName;
	private String password;
	/*
	I use the usersCount() only to check how much users are registered.
	For now, it only returns int only to use it as the id for the next user.
	This way we will not use the id when the programs finish execution.
	Files.lines().count returns long, but I cast it into int just for this exercise.
	With fast correction I can extend the number of ids to long count.
	 */
	private int id;



	protected boolean newUser(String userName, String password) throws IOException {
		int usersCount = 10;
		this.userName = userName;
		this.password = password;
		this.id = usersCount;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\Coding\\Sirma Academy\\GitDocs\\" +
					"SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Users.csv", true));
			writer.write("\n" + this.id + "," + this.userName + "," + this.password);
			writer.close();
			return true;
		} catch (IOException String) {
			throw new RuntimeException("File not accessible!");
		}
	}



	protected int getId(String username, String password) throws FileNotFoundException {
		int userId = -1;
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
				"SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Users.csv"));
		try {
			String line = reader.readLine();
			while (line != null) {
				String[] user = line.split(",");
				String name = user[1];
				String pass = user[2];
				if (name.equals(username) && pass.equals(password)) {
					userId = Integer.parseInt(user[0]);
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			System.out.println("File is empty!");
		}
		return userId;
	}
}