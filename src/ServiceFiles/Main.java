package ServiceFiles;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Guest newGuest = new Guest("someguy", "workingpassword");
		newGuest.setNewUser();

	}
}
