package ServiceFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


public class RoomManagement implements Room{

	public void availableRooms() throws IOException {
		Room.availableRooms();
	}

	public void bookRoom(String userID) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\" +
																  "ServiceFiles\\AvailableRooms.csv"));
		String line = reader.readLine();
		System.out.println("Choose from available rooms:");
		while (line != null) {
			String[] room = line.split(",");
			System.out.println("RoomID: " + room[0] + ", room type: " + room[3] + ", room price: " + room[10]);
			line = reader.readLine();
		}

		System.out.println("Enter room ID: ");
		String roomID = sc.nextLine();
		System.out.println("Enter arrival date in format yyyy-mm-dd: ");
		String arrivalDateString = sc.nextLine();
		System.out.println("Enter departure date in format yyyy-mm-dd: ");
		String departureDateString = sc.nextLine();
		LocalDate arrivalDate = LocalDate.parse(arrivalDateString);
		LocalDate departureDate = LocalDate.parse(departureDateString);
		double priceForStay = reservation(roomID, arrivalDate, departureDate, userID);
		System.out.println("Your room is booked. The price for your stay is " + priceForStay);
	}

	private double reservation(String roomID, LocalDate arrival, LocalDate departure, String userID) throws IOException {
		double priceForStay = -1.0;
		int stay = departure.getDayOfYear() - arrival.getDayOfYear();
		double roomPrice = Room.getRoomPrice(roomID);
		String reservationID = Room.addToReservations(userID, roomID,arrival, departure);
		boolean isRoomReserved = Room.reserveRoom(roomID);
		Room.addToHistory(reservationID, userID, roomID, arrival, departure);
		priceForStay = roomPrice * stay;
		return priceForStay;
	}

}
