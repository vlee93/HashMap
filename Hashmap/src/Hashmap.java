import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;

public class Hashmap {

	public static void main(String[] args) throws FileNotFoundException {

		// get a filename

		String filename = (System.getProperty("user.dir") + File.separatorChar + "myHashMap.txt");

		System.out.println(filename);

		// Create a HashMap

		HashMap<Integer, String> myMap = new HashMap<Integer, String>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {

				String[] key_value_pair = line.split("\t");
				System.out.println("KV Pair:" + key_value_pair[0] + " "
						+ key_value_pair[1]);

				myMap.put(Integer.parseInt(key_value_pair[0]),
						key_value_pair[1]);
				line = reader.readLine();

			}

			reader.close();

		} catch (IOException e) {

			System.out.println("File does not exist!");

		}

		// //Enter Data

		// myMap.put(1, "one");

		// myMap.put(2, "two");

		// myMap.put(3, "three");

		// myMap.put(4, "four");

		// myMap.put(5, "five");

		// myMap.put(6, "six");

		// myMap.put(7, "seven");

		// myMap.put(8, "eight");

		// myMap.put(9, "nine");

		// myMap.put(10, "ten");

		// Creating Scanner
		Scanner sc = new Scanner(System.in);
		
		// initialize key and value
		int key = 0;

		// the following values are used when the number isn't stored in the
		// HashMap yet
		String keyvalue = "";
		String choice = "y";
		
		// Prompt the User
		while (choice.equalsIgnoreCase("y"))
		{
			System.out.println("Prompt: Enter a number: ");
			int number = sc.nextInt();
			if (myMap.containsKey(number) == true)
			{
				String value = myMap.get(number);
				System.out.println("You entered " + value + ".");
				System.out.println("Would you like to try again? Y/N");
				choice = sc.next();
				sc.nextLine();
			}
			else
			{
				System.out.println("The value you entered is currently unavailable.");
				System.out.println("Please add that to the map.");
				System.out.println("Please enter key again: ");
				key = number;
				System.out.println("Please enter value: ");
				sc.nextLine();
				keyvalue = sc.nextLine();
				myMap.put(key, keyvalue);
				System.out.println("New data has been stored!");
				System.out.println("Would you like to try again? Y/N");
				choice = sc.next();
				sc.nextLine();
			}
		}

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e)

		{
			System.out.println("File does not exist!");
		}

		for (int k : myMap.keySet())
		{
			writer.println(k + "\t" + myMap.get(k));
		}
		writer.close();
	}

}