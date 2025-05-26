
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Test {
	public static void main(String[] args) throws IOException {
		String path = "F:\\Coding\\Sirma Academy\\GitDocs\\" +
					  "HotelRegistrationSystem\\abstract_branch\\" +
					  "HotelRoomReservationSystem\\src\\" +
					  "ServiceFiles\\Users.csv";
		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
		writer.write("\n" + "This is test with a variable");
		writer.close();
	}
}
