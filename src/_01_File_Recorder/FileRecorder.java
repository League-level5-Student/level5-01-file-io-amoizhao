package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String args[]) {
		try {
			System.out.println("Type a message: ");
			Scanner scanner = new Scanner(System.in);

			FileWriter fw = new FileWriter("src/_01_File_Recorder/frTest.txt", true);
			fw.write(scanner.nextLine());
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
