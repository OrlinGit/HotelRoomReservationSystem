package ServiceFiles;

import java.io.FileNotFoundException;

public class Employee extends User{
	public Employee() {
	}

	public Employee(String username, String password) {
		super(username, password);
	}

	@Override
	protected boolean setNewUser() {
		return super.setNewUser();
	}

	@Override
	protected String getUserID(String username, String password) throws FileNotFoundException {
		return super.getUserID(username, password);
	}

	protected boolean createNewRoom(){

		return false;
	}

	protected boolean deleteRoom(String UUID){
		return false;
	}

	/*
	Here the employee will be able to create reservation and manipulate the files by directly manipulating the files.
	 */
	protected boolean makeReservation(){
		return false;
	}

	protected boolean deleteReservation(){
		return false;
	}
}
