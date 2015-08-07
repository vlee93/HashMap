import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Hashmap {

	public static void main(String[] args) throws FileNotFoundException {
		
		//get a filename
		System.out.println((System.getProperty("user.dir") + File.separatorChar + "mybooks.txt"));
		String filename = (System.getProperty("user.dir") + File.separatorChar + "mybooks.txt");
		
		
		// Creating HashMap
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		
		//Creating Scanner
		Scanner sc = new Scanner(System.in);
		
		//Entering Data
		myMap.put(1, "one");
		myMap.put(2, "two");
		myMap.put(3, "three");
		myMap.put(4, "four");
		myMap.put(5, "five");
		myMap.put(6, "six");
		myMap.put(7, "seven");
		myMap.put(8, "eight");
		myMap.put(9, "nine");
		myMap.put(10, "ten");
		
		int key = 0;
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
				System.out.println("The value you entered is currently available.");
				System.out.println("Please add that to the map.");
				System.out.println("Please enter key again: ");
				key = sc.nextInt();
				

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
		writer = new PrintWriter (new File(filename));
		
		Iterator it = myMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			writer.println(pair.getKey() + " = " + pair.getValue());
	        it.remove();
		}
		writer.close();

		
	}
}
