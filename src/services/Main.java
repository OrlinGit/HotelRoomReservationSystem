package services;

import models.Guest;

import java.io.FileNotFoundException;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Guest newGuest = new Guest("someguy", "workingpassword");
		newGuest.setNewUser();

	}
}
