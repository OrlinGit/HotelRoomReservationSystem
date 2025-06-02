package models;

import java.io.*;

import static models.Room.pathToAllRooms;

/*
In this Interface I use Strings and a lot of conversations of variables due to the CSV format I have chosen to
keep my data.
I need to concat all variables with coma ",". That is why I have to parse or cast every variable into String.
I haven't found an easy way to manipulate the whole string into the while cycle and write it into the file.
This is why I make it into array and manipulate every single value.
This method returns true if successful and false if not. Currently, it returns only true as the logic for
exceptions, errors etc. is not yet implemented.
 */
public interface RoomModifier {

	static boolean modifyRoom(String roomID, RoomType roomType) throws IOException {
		boolean isRoomUpdated = true;
		BufferedReader reader = new BufferedReader(new FileReader(Room.pathToAllRooms));
		String[] roomToModify = new String[12];

		String line = reader.readLine();
		while (line != null) {
			if (line.contains(roomID)) {
				roomToModify = line.split(",");
				break;
			}
			line = reader.readLine();
		}
		/*
		Everything needs to be in string in order to be written in the file.
		I am making everything in string here in order to be sure that the information is consistent before being
		written in the file.
		 */
		String floor = roomToModify[1];
		String roomNumber = roomToModify[2];
		String type = String.valueOf(roomType);
		String numberOfGuests = String.valueOf(roomType.getMaxGuests());
		String typeOfBed = roomType.getBeds();
		String amenity1 = roomType.getAmenity1();
		String amenity2 = roomType.getAmenity2();
		String amenity3 = roomType.getAmenity3();
		String menu = roomType.getMenu();
		String price = String.valueOf(roomType.getPricePerNight());
		String cancellationFee = String.valueOf(roomType.getCancellationFee());
		String newRoom = String.join(",", roomID, floor, roomNumber, type, numberOfGuests, typeOfBed, amenity1,
				amenity2, amenity3, menu, price, cancellationFee);
		updateRoom(roomID, newRoom);
		return isRoomUpdated;

	}

	/*
	This method writes the information from the original file and transfers it to a temporary file while
	changing the needed line.
	 */
	static void updateRoom(String roomID, String newRoom) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(pathToAllRooms));
		BufferedWriter writer = new BufferedWriter(new FileWriter(Room.pathToTemp, true));
		String line = reader.readLine();
		while (line != null) {
			if (line.contains(roomID)) {
				writer.write(newRoom);
				writer.newLine();
			} else {
				writer.write(line);
				writer.newLine();
			}
			line = reader.readLine();
		}
		reader.close();
		writer.close();
		overWriteFiles(pathToAllRooms, Room.pathToTemp);
	}

	/*
	This method exchanges the content of two files.
	Deletes the content of the original file. Writes the content of the temp file and writes it to the original file.
	Then deletes the content of the temp file.
	 */
	static void overWriteFiles(String originalFilePath, String tempFilePath) throws IOException {
		new FileWriter(originalFilePath, false).close();
		BufferedReader reader = new BufferedReader(new FileReader(tempFilePath));
		BufferedWriter writer = new BufferedWriter(new FileWriter(originalFilePath, true));
		String line = reader.readLine();
		while (line != null) {
			writer.write(line);
			writer.newLine();
			line = reader.readLine();
		}
		reader.close();
		writer.close();
		new FileWriter(tempFilePath, false).close();
	}

}
