package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import service.Person;

/*
 * UC1 :- Ability to create a Contacts in AddressBook with first and last names, address,city, state, zip, phone number and email...
 * Every UC is in a separate Git Branch and then merged with main
 * Naming Convention, Indentation, etc Code Hygiene will be checked during
 * Review Git Check In Comments and Version History will be monitored
 *
 */

class Addressbook {
	final static String FILE_PATH = "C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\AdressBookNew\\src\\main\\java\\service\\AddressBookeOutputData.txt";
	final static String CSV_FILE_PATH = "C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\AdressBookNew\\src\\main\\java\\service\\";
	static ArrayList<Person> P_list = new ArrayList<>();
	// static String First_name, Last_name, address, phoneNum, zip, city, state,
	// email;
	// static int cityAndStateCount = 0;s
	static Scanner sc = new Scanner(System.in);

	/*
	 * UC2 :- Ability to add a new Contact to Address Book - Use Console to add
	 * person details from AddressBookMain class - Use Object Oriented Concepts to
	 * manage relationship between AddressBook and Contact Person
	 */
	public void AddPreson() {
		Person data1 = new Person("Krishna", "Reddy", "Near more super market", "900XXXXXXX", "560037", "Bangeluru",
				"Karnataka", "XYZ@Domain.com");
		Person data2 = new Person("Raja", "Kumar", "sai baba temple road,Kundhalli gate", "885XXXXXXX", "560001",
				"Hampi", "Andhra pradesh", "APC@Domain.com");

		// if (P_list.contains(First_name.concat(Last_name))) {
		// System.out.println("\nError : " + First_name + " " + Last_name + " already
		// exists on this address book.");
		// break;
		// }
		// add the above PersonInfo object to arraylist
		P_list.add(data1);
		P_list.add(data2);
		try {
			addArrayListInToFile(P_list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * UC3 :- Ability to edit existing contact person using their name - Use Console
	 * to edit person details
	 */
	public void EditePeson(String name, String name1) {
		for (Person i : P_list) {
			if (name.equals(i.getFirst_name())) {
				i.setFirst_name(name1);
				i.print();
			}

		}
	}

	/*
	 * UC4 :- Ability to delete a person using person's name - Use Console to delete
	 * a person.
	 */
	public void DeletePerson(String name) {
		for (int i = 0; i < P_list.size(); i++) {
			Person p = P_list.get(i);
			if (name.equals(p.getFirst_name())) {
				P_list.remove(i);
				System.out.println("Person got deleted");
				System.out.println(P_list);
			} else
				System.out.println("Person with this given name not found!!!!!");
		}
	}

	/*
	 * UC5 :- Ability to add multiple person to Address Book - Use Console to add
	 * person details one at a time - Use Collection Class to maintain multiple
	 * contact persons in Address Books
	 */
	public void addMultiPerson() {
		// System.out.print("How many person you want to add :");
		// int Count = sc.nextInt();
		// for (int i = 1; i <= Count; i++) {
		AddPreson();
		// }
		for (Person p : P_list) {
			p.print();
		}
	}

	/*
	 * Ability to search Person in a City or State
	 */
	public void searchPersonsCity() throws IOException {
		// Hashtable<Integer, Person> hashTable = new Hashtable<Integer, Person>();

		String name, cityOrState, personName, stateName;
		name = JOptionPane.showInputDialog(
				"choose what you want to search \nFind city or state by person? -> press (1) \nFind perons by city or state? -> press  (2)\nFind the contact persons by city or state? -> (3)\nFind the sorted the by city's? --> (4)\nFind the sorted the by zip code? --> (5)\nTo display the data press -->(6)");
		switch (name) {
		/*
		 * UC8 :- Ability to search Person in a City or State across the multiple
		 * AddressBook - Search Result can show multiple person in the city or state
		 */
		case "1":
			personName = JOptionPane
					.showInputDialog("Enter the person first and last name without space (eg:- KrishnaReddy)");
			List<Person> list1 = P_list.stream()
					.filter(p_Name -> p_Name.getFirst_name().concat(p_Name.getLast_name()).equals(personName))
					.collect(Collectors.toList());
			for (Person p : list1) {
				System.out.println(personName + " found in city : " + p.getCity() + " and state : " + p.getState());
				// hashTable.put(, p)
			}
			break;
		/*
		 * UC9 :- Ability to view Persons by City or State - Maintain Dictionary of City
		 * and Person as well as State and Person - Use Collection Library to maintain
		 * Dictionary
		 */
		case "2":
			cityOrState = JOptionPane.showInputDialog("Enter the state name ");
			List<Person> list = P_list.stream().filter(p_Name -> p_Name.getState().equals(cityOrState))
					.collect(Collectors.toList());
			for (Person p : list) {
				System.out.println("Person name: " + p.getFirst_name() + " " + p.getLast_name());
			}
			break;

		/*
		 * UC10 :- Ability to get number of contact persons i.e. count by City or State
		 * - Search Result will show count by city and by state
		 */
		case "3":
			stateName = JOptionPane.showInputDialog("Enter the state name");
			List<Person> list3 = P_list.stream().filter(p_Name -> p_Name.getState().equals(stateName))
					.collect(Collectors.toList());
			for (Person p : list3) {
				System.out.println("\nPerson Name: " + p.getFirst_name().concat(p.getLast_name()) + "\nPhone number : "
						+ p.getPhoneNum());
			}
			break;
		/*
		 * UC11 :- Ability to sort the entries in the address book alphabetically by
		 * Person�s name
		 */
		case "4":
			List<Object> sortedPersonNameList = P_list.stream().map(c -> {
				Person person = new Person();
				person.setFirst_name(c.getFirst_name());
				person.setLast_name(c.getLast_name());
				person.setAddress(c.getAddress());
				person.setEmail(c.getEmail());
				person.setPhoneNum(c.getPhoneNum());
				person.setZip(c.getZip());
				person.setCity(c.getCity());
				person.setState(c.getState());
				return person;
			}).sorted(Comparator.comparing(Person::getFirst_name)).collect(Collectors.toList());

			sortedPersonNameList.forEach(System.out::println);
			break;
		/*
		 * UC12 :- Ability to sort the entries in the address book by City, State, or
		 * Zip
		 */
		case "5":
			List<Object> sortedZipCode = P_list.stream().map(c -> {
				Person person = new Person();
				person.setFirst_name(c.getFirst_name());
				person.setLast_name(c.getLast_name());
				person.setAddress(c.getAddress());
				person.setEmail(c.getEmail());
				person.setPhoneNum(c.getPhoneNum());
				person.setZip(c.getZip());
				person.setCity(c.getCity());
				person.setState(c.getState());
				return person;
			}).sorted(Comparator.comparing(Person::getZip).thenComparing(Person::getState))
					.collect(Collectors.toList());
			sortedZipCode.forEach(System.out::println);
			break;
		case "6":
			printData();
			break;
		default:
			System.out.println("Invalid user input");
			break;
		}
	}

	/*
	 * UC13 Ability to Read or Write the Address Book with Persons Contact into a
	 * File using File IO - Using Java File IO
	 */
	public static <T> void addArrayListInToFile(ArrayList<T> emplyDate) throws IOException {
		FileWriter writer = new FileWriter(FILE_PATH);
		emplyDate.forEach(data -> {
			try {
				writer.write(data + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Invaid input");
			}
		});
		writer.close();
	}

	public static void printData() throws IOException {
		Files.lines(new File(FILE_PATH).toPath()).forEach(System.out::println);
	}

	/*
	 * Ability to Read/Write the Address Book with Persons Contact as CSV File UC 14
	 * - Use OpenCSV Library
	 */
	public static void writeDataIntoCSVfile(String fileName) {
		FileWriter fileWrite;
		try {
			fileWrite = new FileWriter(CSV_FILE_PATH + fileName);
			CSVWriter writer = new CSVWriter(fileWrite);
			List<String[]> data = new ArrayList<>();

			data.add(new String[] { "First_name", "Last_name", "Address", "Phone_Number", "Zip code", "City", "State",
					"Email" });
			for (Person person : P_list) {
				data.add(new String[] { person.getFirst_name(), person.getLast_name(), person.getAddress(),
						person.getPhoneNum(), person.getZip(), person.getCity(), person.getState(),
						person.getEmail() });
			}
			writer.writeAll(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Invlid path");
		}

	}

	// Read the data from CSV files
	public static void readCSVDataFromTheFile(String fileName) {
		try {
			FileReader filereader = new FileReader(CSV_FILE_PATH + fileName);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println("File not found at given path");
		}
	}

	/**
	 * UC15 :- Ability to Read or Write the Address Book with Persons Contact as
	 * JSON File - Use GSON Library
	 */
	public void writeDataIntoJsonFile(String jsonFileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			Writer writer = new FileWriter(CSV_FILE_PATH + jsonFileName);
			gson.toJson(P_list, writer); // convert Arraylist to JSON file
			writer.close(); // close writer
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Read the data from JSON files
	public void readDataFromJsonFile(String jsonFileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			System.out.println("Reading data from a JSON file");
			System.out.println("----------------------------");
			Person[] data = gson.fromJson(new FileReader(CSV_FILE_PATH + jsonFileName), Person[].class);
			System.out.println(gson.toJson(data));
		} catch (IOException e) {
			System.err.println("File not found in given path");
		}
	}
}

/*
 * UC6 :- Refactor to add multiple Address Book to the System. Each Address Book
 * has a unique Name - Use Console to add new Address Book - Maintain Dictionary
 * of Address Book Name to Address Book
 *
 */
class AddressHashMap1 {
	static String First_name, Last_name, address, phoneNum, zip, city, state, email;
	static HashMap<String, ArrayList<Person>> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	// static ArrayList<Person> P_list = new ArrayList<>();

	public void AddPresonHashmap() {
		System.out.print("How many person you want to add :");
		int Count = sc.nextInt();
		for (int i = 1; i <= Count; i++) {
			First_name = JOptionPane.showInputDialog("Enter First name");
			Last_name = JOptionPane.showInputDialog("Enter Last name");
			address = JOptionPane.showInputDialog("Enter address");
			phoneNum = JOptionPane.showInputDialog("Enter phone number");
			zip = JOptionPane.showInputDialog("Enter zip");
			city = JOptionPane.showInputDialog("Enter city");
			state = JOptionPane.showInputDialog("Enter state");
			email = JOptionPane.showInputDialog("Enter Mail");
			Person data = new Person(First_name, Last_name, address, phoneNum, zip, city, state, email);

			/*
			 * UC7 :- Ability to ensure there is no Duplicate Entry of the same Person in a
			 * particular Address Book - Duplicate Check is done on Person Name while adding
			 * person to Address Book. - Use Collection Methods to Search Person by Name for
			 * Duplicate Entry
			 *
			 */
			if (map.containsKey(First_name.concat(Last_name))) {
				System.out
						.println("\nError : " + First_name + " " + Last_name + " already exists on this address book.");
				break;
			}
			// add the above PersonInfo object to arraylist
			if (!map.containsKey(data.getFirst_name())) {
				map.put(data.getFirst_name(), new ArrayList<>());
			}
			map.get(data.getFirst_name()).add(data);
		}
		System.out.println(map);
	}

	static void sortByCity() {

		for (Entry<String, ArrayList<Person>> entry : map.entrySet()) {
			ArrayList<Person> value = entry.getValue();
			List<Person> sortedList = value.stream().sorted(Comparator.comparing(Person::getFirst_name))
					.collect(Collectors.toList());

			for (Person contact : sortedList) {
				System.out.println("First Name: " + contact.getFirst_name());
				System.out.println("City Name: " + contact.getCity());
				System.out.println("-------------------------------");
			}
		}
	}
}

public class AddessBook {
	public static void main(String[] args) throws IOException {
		/*
		 * UC1 Ability to create a Contacts in Address Book with first and last names,
		 * address, city, state, zip, phone number and email...
		 */
		// Person s1 = new Person("Ashwath", "Naidu", "123ash,nea rsai baba temple
		// road,", "934058XXX", "560037",
		// "Bangalour", "Karnataka", "Ashwath@xyz.in");
		// s1.print();

		Addressbook b = new Addressbook();
		b.AddPreson(); // first person// UC2
		// b.AddPreson(); // second person // UC2
		// b.EditePeson("ashwath", "naidu"); // UC3
		// b.DeletePerson("naidu"); // UC4
		// b.addMultiPerson(); // UC5
		// b.searchPersonsCity(); // UC8 - UC13
//		 b.writeDataIntoCSVfile("AddressBookDataCSV.csv"); // UC14 (Writing file)
//		 b.readCSVDataFromTheFile("AddressBookDataCSV.csv"); // UC14 (Reading file)
		 b.writeDataIntoJsonFile("AddressBookDataJSON.json"); // UC15 (Writing file)
		 b.readDataFromJsonFile("AddressBookDataJSON.json"); //UC15 Reading file)

		// AddressHashMap n = new AddressHashMap();
		// n.AddPresonHashmap();// UC6 - UC7
		// n.sortByCity();
	}
}
