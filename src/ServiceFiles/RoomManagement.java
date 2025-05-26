package ServiceFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class RoomManagement {

	public void availableRooms() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "HotelRegistrationSystem\\abstract_branch\\" +
																  "HotelRoomReservationSystem\\src\\ServiceFiles\\Rooms.csv"));
		String line = reader.readLine();
		while (line != null) {
			String[] room = line.split(",");
			if (room[12].equals("Available")) {
				System.out.println(line);
			}
			line = reader.readLine();
		}
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
		double roomPrice = getRoomPrice(roomID);
		int reservationID = addToReservations(userID, roomID,arrival, departure);
		boolean isRoomReserved = reserveRoom(roomID);
		addToHistory(reservationID, userID, roomID, arrival, departure);
		priceForStay = roomPrice * stay;
		return priceForStay;
	}

	protected int reservationsCount() throws IOException {
		int count = (int) Files.lines(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\" +
												"SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Reservations.csv")).count();
		return count;
	}

	protected int historyCount() throws IOException {
		int count = (int) Files.lines(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\" +
												"SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\History.csv")).count();
		return count;
	}

	protected boolean reserveRoom(String roomID) throws IOException {
		BufferedWriter writer;
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																				   "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\AvailableRooms.csv"));
		for (String line : lines) {
			if (line.contains(roomID)) {
				writer = new BufferedWriter(new FileWriter("F:\\Coding\\Sirma Academy\\GitDocs\\" +
														   "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\ReservedRooms.csv", true));
				writer.write(line);
				writer.newLine();
				writer.close();
				lines.remove(line);
				Files.write(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\SirmaOOP\\" +
									  "HotelRoomReservationSystem\\src\\ServiceFiles\\AvailableRooms.csv"), lines);
				return true;
			}

		}

		return false;
	}

	protected double getRoomPrice(String roomID) throws IOException {
		double pricePerNight = -1.0;
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\AllRooms.csv"));
		String line = reader.readLine();
		while (line != null) {
			if(line.contains(roomID)){
				String[] room = line.split(",");
				pricePerNight = Double.parseDouble(room[10]);
				break;
			}
			line = reader.readLine();
		}
		return pricePerNight;
	}

	protected int addToReservations(String userID, String roomID, LocalDate arrival, LocalDate departure) throws IOException {
		int reservationID = reservationsCount();
		BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\Coding\\Sirma Academy\\GitDocs\\" +
		"SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Reservations.csv", true));
		String reservationData = String.join(",", String.valueOf(reservationID), String.valueOf(userID),
				roomID, String.valueOf(arrival), String.valueOf(departure));
		writer.write(reservationData);
		writer.newLine();
		writer.close();
		return reservationID;
	}

	protected void addToHistory(int reservationID, String userID, String roomID, LocalDate arrival, LocalDate departure) throws IOException {
		int historyID = historyCount();
		BufferedWriter writer = new BufferedWriter(new FileWriter("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\History.csv", true));
		String historyData = String.join(",", String.valueOf(historyID), String.valueOf(reservationID), String.valueOf(userID),
				roomID, String.valueOf(arrival), String.valueOf(departure));
		writer.write(historyData);
		writer.newLine();
		writer.close();
	}
}
