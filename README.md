**#HotelRoomReservationSystem**
I am trying to make this brach more abstract and implement Interfaces and Abstract classes.
As I needed to change the whole architecture and implementation of the code, so I decided to change the whole code.
It will be also used to train a little bit my git knowledge. 

The hotel room management consoled based application is for my education purposes.
I use a big number of csv files in order to manage the information of the different tasks required form the program.
For sure it is a lot easier to do it with database but curently I do not posses the knowledge to handle and maintain 
database and one of the goes of this project is to learn to manage files.

It is has the following structure and specifics. 
1. The OperationSystem class is only to communicate with the user. It is in a separate UserAvailable package.
This package will contain only applications that will comunicate wih the user.

3. The RoomManagement contains all functions regarding the information management of the rooms.

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

3. UserManagement class contains all functions regarding the information management of the users. Future functuanalities will be added.
 For example - validation that the username and password have the correct atributes and size.

int - registeredUser() - checks if user is registered. If the user is already registered returns an int with the userID.
							This will be later used for the database with the reservations.
       
							
4. User Management contains all functions regarding management of different users functions.

String userLogIn() - gets username and password from user, check if user is registered and returns String with the ID of the user.

String employeeLogIn() - gets username and password from employee, check if user is registered and returns String with the ID of the employee.

String getUserID() - receives username and password from another internal functions, check if user is registered and returns String with the ID of the user. It is used
		     from inetrnal functionalities to check if user is existing and return String with userID.

String registerEmployee() - gets username and password form the console and registers new employee. Returns String with employeeID.

String registerUser() - gets username and password form the console and registers new employee. Returns String with userID.


5. User abstract class - this gives the main structure of all types of users. There are two types for now - user and employee.

String setNewUser() - creates new user and returns String with the userID

String getUserID() - gets username and password from internal functions and returns the UserID of the user.

int usersCount() - returns the count of all registered users. But does not make difference between guests and employees.


6. Guest class - this gives the structure of the users. All Hotel users will have different functions than the others.

Guest() - empty constructor.

Guest(String, String) - constructor taht receives two Strings - username and password.

String setNewUser() - creates new user with role "user" and returns string with userID.

String getUserID() - gets username and password from internal functions and returns the UserID of the user.

void addToHistory(String userID, String reservationID) - this will be future functionality that creates booking history of the user.

7. Employee class - this gives the structure of the employees. All Hotel employees will have different functions than the others.

Employee() - empty constructor.

Employee(String, String) - constructor taht receives two Strings - username and password.

String setNewEmployee() - creates new employee with role "employee" and returns string with employeeID.

String getEmployeeID() - gets username and password from internal functions and returns the employeeID.

boolean modifyRoom(String roomID, RoomType roomType) - this function is available only for employees. It recieves is used to modify the
type of an existing room. Input is String roomID - of the room taht will be modified. String RoomType - the room type that the room will be modified to.

boolean bookRoom() - each employee will be able to create reservation for user. 

boolean deleteReservation() - each employee will be able to delete reservation form the system.

8. Interface Room - this interface is respponsible for all manipulations regarding room management. It holds teh pathways to all files.

double getRoomPrice(String roomNumber) - returns double with the price per night of given room.

double cancellationFee(String roomNumber) - returns double with the cancellation fee of given room.

void availableRooms() - print list of all aveilable rooms.

void allRooms() - print list of all rooms.

void addToHistory() - adds reservation to a file that keeps history of all reservations ever made.

String addToReservations() - adds reservation to a file that keeps history of current reservations and returns String with reservationID.

boolean reserveRoom() - writes the reserved room into the file with the current reservations and deletes the room from the file with available rooms.

int reservationsCount() - returns int with the count of the current reservations. Old functionality used to generate reservationsID before UUID.

int historyCount() - returns int with the count of all reservations ever made. Old functionality used to generate historyID before UUID.

int roomCount() - returns int with the count of all reservations ever made. This functionality was never used to generate roomID.

void makeAvailable() - deletes room from the file with reserved rooms and adds it to the file with available rooms.

void deleteReservedRoom() - deletes reservation from the file with reserved rooms.

void deleteReservation() - deletes reservation from the file with reservations.

9. Interface Room Modifier - this interface is used to modify room types of existing rooms. It is done as Interface as different classes of users will be able to use it.
				For now only one class Employee exists, but in future other classes will be added.

10 Enumeration RoomType - here the different types of rooms are defined.


Files:
1. AllRooms.csv file contains all rooms available in the Hotel with all the information for them. 
2. Users.csv - contains all registered users. Every new user is added to the file.
3. AvailableRooms.csv - contains only room available for booking.
4. Reservations.csv - keeps history of the current active reservations. 
5. History.csv - keeps the history of all reservations.
6. ReservedRooms.csv - keeps the information about the rooms that are booked.
7. temp.csv - this file is used just to hold temporary data. When a file is beeing modified you can not just modify one line.
              You have to write the data with the modified line in new file. Delete the data in the original file. And write the data from the temp.csv to the original destination.
