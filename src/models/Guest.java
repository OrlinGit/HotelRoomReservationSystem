package models;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Guest extends User {
	HashMap<String, ArrayList<String>> userHistory = new HashMap();
	/*
	In the super class User there is a variable role to define a user.
	For all users the role is pre-defined as "user". This is why it is hard coded.
	 */
	static String role = "user";
	public Guest() {
	}

	public Guest(String username, String password) {
		super(username, password, role);
	}

	public String setNewUser() {
		return super.setNewUser();
	}

	public String getUserID(String username, String password) throws FileNotFoundException {
		String role = "user";
		return super.getUserID(username, password, role);
	}

	public void addToHistory(String userID, String reservationID) {
		ArrayList<String> listOfReservations = new ArrayList();
		listOfReservations = this.userHistory.get(userID);
		listOfReservations.add(reservationID);
		this.userHistory.put(userID, listOfReservations);
	}

}

