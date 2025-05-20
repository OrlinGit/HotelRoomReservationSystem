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
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Rooms.csv"));
		String line = reader.readLine();
		while (line != null) {
			String[] room = line.split(",");
			if (room[12].equals("Available")) {
				System.out.println(line);
			}
			//ArrayList<String> roomInfo = new ArrayList<>(Arrays.asList());
			line = reader.readLine();
		}
	}

	public void bookRoom() throws IOException {
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

	}

	private double reservation(int roomID, LocalDate arrival, LocalDate departure, int userId) throws IOException {
		double priceForStay = -1.0;
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Rooms.csv"));
		String line = reader.readLine();
		while (line != null) {
			String[] room = line.split(",");
			if (Integer.parseInt(room[0]) == roomID) {


			}
			line = reader.readLine();

		}
		return priceForStay;
	}

	protected int reservationsCount() throws IOException {
		int count = (int) Files.lines(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\" +
												"SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Users.csv")).count();
		return count;
	}

	protected boolean bookRoom(String roomID) throws IOException {
		BufferedWriter writer;
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																				   "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Rooms.csv"));
		for (String line : lines) {
			if (line.contains(roomID)) {
				writer = new BufferedWriter(new FileWriter("F:\\Coding\\Sirma Academy\\GitDocs\\" +
														   "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Reservations.csv", true));
				writer.write(line);
				writer.newLine();
				writer.close();
				lines.remove(line);
				Files.write(Paths.get("F:\\Coding\\Sirma Academy\\GitDocs\\SirmaOOP\\" +
									  "HotelRoomReservationSystem\\src\\ServiceFiles\\ReservedRooms.csv"), lines);
				return true;
			}

		}

		return false;
	}

	protected double roomPrice(String roomID) throws IOException {
		double pricePerNight = -1.0;
		BufferedReader reader = new BufferedReader(new FileReader("F:\\Coding\\Sirma Academy\\GitDocs\\" +
																  "SirmaOOP\\HotelRoomReservationSystem\\src\\ServiceFiles\\Rooms.csv"));
		String line = reader.readLine();
		while (line != null) {
			if(line.contains(roomID)){
				String[] room = line.split(",");
				pricePerNight = Double.parseDouble(room[11]);
				break;
			}
			line = reader.readLine();
		}
		return pricePerNight;
	}

}
