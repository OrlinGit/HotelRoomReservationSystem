package ServiceFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/*
I will use this interface to manipulate the file(database) tha holds the list with all rooms,
with all their respective information.
First it will contain only methods to create and delete rooms to the file(database).
Afterwords it can be extended to manipulate the information as new needs occur.
 */
public interface Room {

	String pathToAllRooms = "F:\\Coding\\Sirma Academy\\GitDocs\\HotelRegistrationSystem\\abstract_branch\\" +
							"HotelRoomReservationSystem\\src\\ServiceFiles\\AllRooms.csv";
	String pathToAvailableRooms = "F:\\Coding\\Sirma Academy\\GitDocs\\HotelRegistrationSystem\\abstract_branch\\" +
								  "HotelRoomReservationSystem\\src\\ServiceFiles\\AvailableRooms.csv";
	String pathToHistory = "F:\\Coding\\Sirma Academy\\GitDocs\\HotelRegistrationSystem\\abstract_branch\\" +
						   "HotelRoomReservationSystem\\src\\ServiceFiles\\History.csv";
	String pathToReservations = "F:\\Coding\\Sirma Academy\\GitDocs\\HotelRegistrationSystem\\abstract_branch\\" +
								"HotelRoomReservationSystem\\src\\ServiceFiles\\Reservations.csv";
	String pathToReservedRooms = "F:\\Coding\\Sirma Academy\\GitDocs\\HotelRegistrationSystem\\abstract_branch\\" +
								 "HotelRoomReservationSystem\\src\\ServiceFiles\\ReservedRooms.csv";

	static void createRoom() {
	}

	static void deleteRoom() {
	}

	static double getRoomPrice(String roomID) throws IOException {
		double pricePerNight = -1.0;
		BufferedReader reader = new BufferedReader(new FileReader(pathToAllRooms));
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

	static double cancellationFee(String roomID) throws IOException {
		double cancellationFee = -1.0;
		BufferedReader reader = new BufferedReader(new FileReader(pathToAllRooms));
		String line = reader.readLine();
		while (line != null) {
			if(line.contains(roomID)){
				String[] room = line.split(",");
				cancellationFee = Double.parseDouble(room[11]);
				break;
			}
			line = reader.readLine();
		}
		return cancellationFee;
	}

	static void availableRooms() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(pathToAvailableRooms));
		String line = reader.readLine();
		while (line != null) {
			line = reader.readLine();
		}
	}

	static void allRooms() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(pathToAvailableRooms));
		String line = reader.readLine();
		while (line != null) {
			line = reader.readLine();
		}
	}

	static void addToHistory(String reservationID, String userID, String roomID, LocalDate arrival, LocalDate departure) throws IOException {
		String historyID = String.valueOf(UUID.randomUUID());
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathToHistory, true));
		String historyData = String.join(",", historyID, reservationID, String.valueOf(userID),
				roomID, String.valueOf(arrival), String.valueOf(departure));
		writer.write(historyData);
		writer.newLine();
		writer.close();
	}

	static String addToReservations(String userID, String roomID, LocalDate arrival, LocalDate departure) throws IOException {
		String reservationID = String.valueOf(UUID.randomUUID());
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathToReservations, true));
		String reservationData = String.join(",", reservationID, String.valueOf(userID),
				roomID, String.valueOf(arrival), String.valueOf(departure));
		writer.write(reservationData);
		writer.newLine();
		writer.close();
		return reservationID;
	}

	static boolean reserveRoom(String roomID) throws IOException {
		BufferedWriter writer;
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(pathToAvailableRooms));
		for (String line : lines) {
			if (line.contains(roomID)) {
				writer = new BufferedWriter(new FileWriter(pathToReservedRooms, true));
				writer.write(line);
				writer.newLine();
				writer.close();
				lines.remove(line);
				Files.write(Paths.get(pathToAvailableRooms), lines);
				return true;
			}

		}

		return false;
	}

	static int reservationsCount() throws IOException {
		int count = (int) Files.lines(Paths.get(pathToReservations)).count();
		return count;
	}

	static int historyCount() throws IOException {
		int count = (int) Files.lines(Paths.get(pathToHistory)).count();
		return count;
	}

}

