package ServiceFiles;

import java.util.List;

/*
I will use this interface to manipulate the file(database) tha holds the list with all rooms,
with all their respective information.
First it will contain only methods to create and delete rooms to the file(database).
Afterwords it can be extended to manipulate the information as new needs occur.
 */
public interface Room {

	String pathToAllRooms = "F:\\Coding\\Sirma Academy\\GitDocs\\HotelRegistrationSystem\\abstract_branch\\" +
							"HotelRoomReservationSystem\\src\\ServiceFiles\\AllRooms.csv";


}
