package services;

import models.Room;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;



public class RoomManagement implements Room {

	public void availableRooms() throws IOException {
		Room.availableRooms();
	}

	public void allRooms() throws IOException {
		Room.allRooms();
	}

	public void bookRoom(String userID) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose from available rooms:");
		Room.availableRooms();
		System.out.println("Enter room number: ");
		String roomNumber = sc.nextLine();
		System.out.println("Enter arrival date in format yyyy-mm-dd: ");
		String arrivalDateString = sc.nextLine();
		System.out.println("Enter departure date in format yyyy-mm-dd: ");
		String departureDateString = sc.nextLine();
		LocalDate arrivalDate = LocalDate.parse(arrivalDateString);
		LocalDate departureDate = LocalDate.parse(departureDateString);
		double priceForStay = reservation(roomNumber, arrivalDate, departureDate, userID);
		System.out.println("Your room is booked. The price for your stay is " + priceForStay);
	}

	private double reservation(String roomNumber, LocalDate arrival, LocalDate departure, String userID) throws IOException {
		int stay = departure.getDayOfYear() - arrival.getDayOfYear();
		double roomPrice = Room.getRoomPrice(roomNumber);
		String reservationID = Room.addToReservations(userID, roomNumber,arrival, departure);
		boolean isRoomReserved = Room.reserveRoom(roomNumber);
		Room.addToHistory(reservationID, userID, roomNumber, arrival, departure);
		return (roomPrice * stay);
	}

	public double cancelReservation(String roomNumber) throws IOException {
		Room.makeAvailable(roomNumber);
		Room.deleteReservedRoom(roomNumber);
		return Room.cancellationFee(roomNumber);
	}

}
