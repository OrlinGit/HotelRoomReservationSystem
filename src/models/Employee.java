package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class Employee extends User implements RoomModifier, Room{
	static String role = "employee";

	public Employee() {
	}

	public Employee(String username, String password) {
		super(username, password, role);
	}

	public String setNewEmployee() {
		return super.setNewUser();
	}

	public String getEmployeeID(String username, String password) throws FileNotFoundException {
		String role = "employee";
		return super.getUserID(username, password, role);
	}

	/*
	As the rooms in a hotel are fixed in terms of number and size, all an employee can do is modify its Type.
	 */
	public boolean modifyRoom(String roomID, RoomType roomType) throws IOException {
		return RoomModifier.modifyRoom(roomID, roomType);
	}

	public boolean deleteRoom(String UUID){
		return false;
	}

	/*
	Here the employee will be able to create reservation and manipulate the files by directly manipulating the files.
	 */
	public boolean bookRoom(String userID, String roomNumber, LocalDate arrivalDate, LocalDate departureDate) throws IOException {
		Room.addToReservations(userID, roomNumber, arrivalDate, departureDate);
		return false;
	}

	public boolean deleteReservation(String roomNumber) throws IOException {
		Room.deleteReservation(roomNumber);
		return false;
	}


}
