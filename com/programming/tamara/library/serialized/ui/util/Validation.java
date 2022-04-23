package programming.tamara.library.serialized.ui.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validation {

	private static Scanner in = new Scanner(System.in);
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public static Integer numberEntry(Integer min, Integer max) {
		while (true) {
			String entry = in.nextLine();
			if (entry.equalsIgnoreCase("x")) {
				return null;
			}

			try {
				int number = Integer.parseInt(entry);
				
				if (min != null && number < min) {
					System.out.println("The number must be greater than "+ min +"or equal to " + min);
					continue;
				}
				if (max != null && number > max) {
					System.out.println("The number must be less than"+max+ "or equal to" + max);
					continue;
				}

				return number;

			} catch (Exception e) {
				System.out.println("You must enter a number!");
				continue;
			}

		}

	}

	public static Integer numberEntry() {
		return numberEntry(null, null);
	}

	public static String textEntry(Integer min, Integer max) {
		while (true) {
			String entry = in.nextLine();
			entry = entry.strip();
			if (min != null && entry.length() < min) {
				System.out.println("Lenght of text must bee greater than " + min + "or equal to " + min);
				continue;
			}
			if (max != null && entry.length() > max) {
				System.out.println("Lenght of text must bee less than "+ max +" or equal to " + max);
				continue;
			}

			return entry;
		}

	}

	public static String textEntry() {
		return textEntry(null, null);
	}

	public static LocalDate dateEntry(String entry) {

		try {
			LocalDate date = LocalDate.parse(entry, dtf);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	public static LocalDate parsedDate() {
		LocalDate date;
		do {
			date = dateEntry(Validation.textEntry());
			if (date == null) {
				System.out.println("Wrong date format, enter again: ");
			}
		} while (date == null);

		return date;

	}

	public static String checkMail() {
		String text = "";
		while (!text.contains("@"))
			text = in.nextLine();
		return text;
	}

}
