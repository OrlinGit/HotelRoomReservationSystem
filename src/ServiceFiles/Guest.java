package ServiceFiles;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Guest extends User {
	HashMap<String, ArrayList<String>> userHistory = new HashMap();

	public Guest() {
	}

	public Guest(String username, String password) {
		super(username, password);
	}

	protected boolean setNewUser() {
		return super.setNewUser();
	}

	protected String getUserID(String username, String password) throws FileNotFoundException {
		return super.getUserID(username, password);
	}

	protected void addToHistory(String userID, String reservationID) {
		ArrayList<String> listOfReservations = new ArrayList();
		listOfReservations = this.userHistory.get(userID);
		listOfReservations.add(reservationID);
		this.userHistory.put(userID, listOfReservations);
	}

}

