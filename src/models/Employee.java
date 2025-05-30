package models;

import java.io.FileNotFoundException;

public class Employee extends User {
	public Employee() {
	}

	public Employee(String username, String password) {
		super(username, password);
	}

	@Override
	public boolean setNewUser() {
		return super.setNewUser();
	}

	@Override
	public String getUserID(String username, String password) throws FileNotFoundException {
		return super.getUserID(username, password);
	}

	public boolean createNewRoom(){

		return false;
	}

	public boolean deleteRoom(String UUID){
		return false;
	}

	/*
	Here the employee will be able to create reservation and manipulate the files by directly manipulating the files.
	 */
	public boolean makeReservation(){
		return false;
	}

	public boolean deleteReservation(){
		return false;
	}
}
