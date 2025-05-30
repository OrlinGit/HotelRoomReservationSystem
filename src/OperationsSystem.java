import services.RoomManagement;
import services.UserManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OperationsSystem {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("""
				Welcome to our Hotel management system!\
				
				Write the number of your desired option:\
				
				1.View all rooms\
				
				2.Book a room\
				
				3.Cancel reservation\
				
				4. Exit program
				""");

		String initialNavigation = sc.nextLine();
		RoomManagement rooms = new RoomManagement();
		ArrayList<String> validChoices = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
		while (!validChoices.contains(initialNavigation)) {
			System.out.println("""
					Invalid choice\
					
					Please choose again!
					""");
			initialNavigation = sc.nextLine();
		}
		switch (initialNavigation) {
			case "1":
				rooms.allRooms();
				break;
			case "2":
				roomBooking();
				break;
			case "3":
				cancelReservation();
				break;
			case "4":
				System.out.println("Good day!");
				System.exit(0);
		}

	}

	private static void roomBooking() throws IOException {
		/*
		This needs to be optimized. Registration and user validation should be separate from the booking
		functionality.
		 */
		Scanner sc = new Scanner(System.in);
		UserManagement user = new UserManagement();
		System.out.println("""
				In order to book a room you need to be a registered user.\
				
				"Are you a registered user? Y/N""");
		String registration = sc.nextLine().toLowerCase();
		// I use while statement to be sure that I will take from the user only Y or N answer.
		while (!registration.equals("y") && !registration.equals("n")) {
			System.out.println("Invalid input.\nAre you a registered user? Y/N");
			registration = sc.nextLine().toLowerCase();
		}

		String userID = user.registeredUser(registration);
		if(!userID.equals(null)){
			RoomManagement roomBooking = new RoomManagement();
			roomBooking.bookRoom(userID);
		}

	}

	private static void allRooms() throws IOException {
		RoomManagement roomBooking = new RoomManagement();
		roomBooking.allRooms();
	}

	private static void cancelReservation() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter room number to cancel reservation:");
		String roomNumber = sc.nextLine();
		RoomManagement room = new RoomManagement();
		double cancellationFee = room.cancelReservation(roomNumber);
		System.out.println("You cancellation fee is: " + cancellationFee);
	}


}
