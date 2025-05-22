**#HotelRoomReservationSystem**
This repo is created to upload all small projects I have created in the OOP course.
The code was written using only the principals of Encapsulation, and to test the comunicaton between the program and the files.
In the next step the program will be made more abstract. Interfaces and different classes will implemented.

The hotel room management consoled based application is for my education purposes.
I use a big number of csv files in order to manage the information of the different tasks required form the program.
For sure it is a lot easier to do it with database but curently I do not posses the knowledge to handle and maintain 
database and one of the goes of this project is to learn to manage files.

It is has the following structure and specifics. 
1. The Managemensystem class is only to communicate with the user. It is in a separate UserAvailable package.
This package will contain only applications that will comunicate wih the user.
2. The RoomManagement contains all functions regarding the information management of the rooms.

void - availableRooms() - prints out a list of all rooms with their respectfull atributes - max. guest capacity, bed size, amenities, 
							menu type, price per night, cancalation fee etc.
void - bookRoom() - prints out only the available rooms with their ID, room type, and room price. After thart takes the information
					regarding arrival and departure date in order to book the room for the mentioned dates. 
					* This can be split into 2 separate functions in future.
double - reservation() - takes data from the user. Makes transfers the resrved room in the Reservations file, and takes it out
						 from the availbale rooms. Returns double with th eprice of the stay. 
						 * Could be optimized in the future.

boolean reservesRoom() - Receives the roomID as String. Delites the room with the ID from the file with aveilable rooms
					 and adds it to the file with ReservedRooms.csv

2. UserManagement class contains all functions regarding the information management of the users. Future functuanalities will be added.
 For example - validation that the username and password have the correct atributes and size.

int - registeredUser() - checks if user is registered. If the user is already registered returns an int with the userID.
							This will be later used for the database with the reservations.
							

3. Users class is only resposible for the comunictaion between the program and the files that keep the user infromation.

int - usersCount() - returns int with the number of already registered users. This is used to count the users and asign 
					 unique user ID of the next registered user. There are better ways to assign unique ID but for the 
					 current level of knowledge this is sufficiant. 
					 
boolean - newUser() - registers the new user and returns true if the process is succesfull. In future functionality that double 
					  checks the file for the user can be added.
					  
boolean - isValidUser() - check if the use that is signing in is in the database and checks if the passwords corresponds with
						  the registered username. Returns true if the username and password match.
						  
int - getId() - returns the ID of the user that is signed in. This is used for the history of reservations.

4. Rooms.csv file contains all rooms available in the Hotel with all the information for them. 

5. Users.csv - contains all registered users. Every new user is added to the file.

6. Reservations.csv - keeps history of the current active reservations. 

7. History.csv - keeps the history of all reservations.

8. ReservedRooms.csv - keeps the information about the rooms that are booked.
