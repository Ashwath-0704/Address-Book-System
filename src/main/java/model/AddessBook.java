package model;

/**
 * @author Ashwath Naidu <ashwath.bly@gmail.com>
 * 
 * @version openjdk 11.0.12 2021-07-20
 * @version OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * @version OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 *
 */
//********************************************************************************************************************************************************************

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

import service.IOService;
import service.Person;

/**
 *@purpose   UC1 :- Ability to create a Contacts in AddressBook with first and last names, address,city, state, zip, phone number and email...
 *		 	   Every UC is in a separate Git Branch and then merged with main
 * 		 	   Naming Convention, Indentation, etc Code Hygiene will be checked during
 * 		 	   Review Git Check In Comments and Version History will be monitored
 * 
 * @return It provied the person details of each address book
 * 
 */
class Addressbook {
	
	static ArrayList<Person> P_list = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	/**
	 * @purpose -> UC2 :- Ability to add a new Contact to Address Book - Use Console to add
	 * 			   person details from AddressBookMain class - Use Object Oriented Concepts to
	 * 			   manage relationship between AddressBook and Contact Person
	 * 
	 * @return ->  This function returns person data that stord into ArrayList (ArrayList<Person> P_list)
	 */
	public void AddPreson() {
		Person data1 = new Person("Krishna", "Reddy", "Near more super market", "900XXXXXXX", "560037", "Bangeluru","Karnataka", "XYZ@Domain.com");
		Person data2 = new Person("Raja", "Kumar", "sai baba temple road,Kundhalli gate", "885XXXXXXX", "560001","Hampi", "Andhra pradesh", "APC@Domain.com");

		// add the above PersonInfo object to arraylist
		P_list.add(data1);
		P_list.add(data2);
		
		// transferring array list data to file
		try {
			addArrayListInToFile(P_list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @purpose -> UC3 :- Ability to edit existing contact person using their name
	 * @param name -> user provides existing data
	 * @param name1 -> user provides new data
	 * 
	 * @return  It returns the edited values.
	 * 
	 */
	public void EditePeson(String name, String name1) {
		for (Person i : P_list) {
			if (name.equals(i.getFirst_name())) { // "true" if the given object represents a String equivalent to this string, "false "otherwise
				i.setFirst_name(name1);
				i.print();
			}
		}
	}
	
	/**
	 * @purpose -> UC4 :- Ability to delete a person using person's name - Use Console to delete a person.
	 * 
	 * @param name -> This name provided by user 
	 * 
	 * @return -> This method returns an deleted AddressBook person details
	 * 
	 */
	public void DeletePerson(String name) {
		for (int i = 0; i < P_list.size(); i++) {
			Person p = P_list.get(i);
			if (name.equals(p.getFirst_name().concat(p.getLast_name()))) {
				P_list.remove(i);
				System.out.println("Person got deleted");
				System.out.println(P_list);
			} else
				System.out.println("Person with this given name not found!!!!!");
		}
	}

	/**
	 * @purpose -> UC5 :- Ability to add multiple person to Address Book - Use Console to add
	 * 			   person details one at a time - Use Collection Class to maintain multiple
	 * 			   contact persons in Address Books
	 * @return It returns Multiple person data 
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

	/**
	 * @purpose -> UC6 :- Ability to search Person in a City or State
	 * 
	 * @return -> It returns the peroson data which depends on user input
	 * 
	 * @throws IOException
	 */
	public void searchPersonsCity() throws IOException {

		String name, cityOrState, personName, stateName;
		name = JOptionPane.showInputDialog(
				"choose what you want to search \nFind city or state by person? -> press (1) \nFind perons by city or state? -> press  (2)\nFind the contact persons by city or state? -> (3)\nFind the sorted the by city's? --> (4)\nFind the sorted the by zip code? --> (5)\nTo display the data press -->(6)");
		switch (name) {
	
	/**
	 * @purpose -> UC8 :- Ability to search Person in a City or State across the multiple
	 *  		   AddressBook - Search Result can show multiple person in the city or state
	 *  
	 *  @return -> This case return multiple person data that matches with city or state in AddressBook
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
		
		/**
		 * @purpose -> UC9 :- Ability to view Persons by City or State - Maintain Dictionary of City
		 *			   and Person as well as State and Person - Use Collection Library to maintain
		 * 			   Dictionary
		 * 
		 * @return -> It return an person data which match with state name
		 * 
		 */
		case "2":
			cityOrState = JOptionPane.showInputDialog("Enter the state name ");
			List<Person> list = P_list.stream().filter(p_Name -> p_Name.getState().equals(cityOrState))
					.collect(Collectors.toList());
			for (Person p : list) {
				System.out.println("Person name: " + p.getFirst_name() + " " + p.getLast_name());
			}
			break;
			
		/**
		 * @purpose -> UC10 :- Ability to get number of contact persons i.e. count by City or State  
		 * 			   Search Result will show count by city and by state
		 * 
		 * @return -> It return the number of contact person that match with city or state
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
		
		/**
		 * @purpose -> UC11 :- Ability to sort the entries in the address book alphabetically by
		 * 			   Persons name
		 * 
		 * @return -> It returns the sorted AddressBook i.e,(Person Data) by names 
		 */
		case "4":
			List<Object> sortedPersonNameList = P_list.stream().map(c -> {
				Person person = new Person();
				person.setFirst_name(c.getFirst_name()); // Ashwath
				person.setLast_name(c.getLast_name());   // naidu
				person.setAddress(c.getAddress());		// BTM layout
				person.setEmail(c.getEmail());			// xyz@gmail.com
				person.setPhoneNum(c.getPhoneNum());	// 852741963
				person.setZip(c.getZip());				// 560037
				person.setCity(c.getCity());		// bangalour
				person.setState(c.getState());		// karnataka
				return person;
			}).sorted(Comparator.comparing(Person::getFirst_name)).collect(Collectors.toList());

			sortedPersonNameList.forEach(System.out::println);
			break;
		
		/**
		 * @purpose -> UC12 :- Ability to sort the entries in the address book by City, State, or Zip
		 * 
		 * @return -> It return the sotred AddressBook by city or state or zip code that provided in AddressBook Data
		 * 
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
			}).sorted(Comparator.comparing(Person::getZip).thenComparing(Person::getState)).collect(Collectors.toList());
			
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

	/**
	 * @purpose  UC13 Ability to Read or Write the Address Book with Persons Contact into a
	 * 			 File using File IO - Using Java File IO
	 * 
	 * @param <T> -> any Class or dataType can be used [ eg : <AddressBook> or <String>] 
	 * @param emplyDate -> Take as ArrayLIst Data 
	 * @throws IOException 
	 * 
	 * @return -> It writes the ArrayList data into File
	 * 
	 */
	public static <T> void addArrayListInToFile(ArrayList<T> emplyDate) throws IOException {
		FileWriter writer = new FileWriter(IOService.FILE_PATH.file);
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

	/**
	 * @purpose -> Ability to read the data from the file 
	 * 
	 * @throws IOException
	 * 
	 * @return -> It prints the data in console whcih is reading the data from the file 
	 */
	public static void printData() throws IOException {
		Files.lines(new File(IOService.FILE_PATH.file).toPath()).forEach(System.out::println);
	}

	/**
	 * @purpose -> Ability to Read/Write the Address Book with Persons Contact as CSV File UC 14
	 * 			   Use OpenCSV Library
	 * 
	 * @param fileName -> user provides the File Name with extension (Eg:- output.csv)
	 * 
	 * @return -> Creates the CSV file in mentioned file path
	 */
	public static void writeDataIntoCSVfile(String fileName) {
		FileWriter fileWrite;
		try {
			fileWrite = new FileWriter(IOService.CSV_FILE_PATH.file + fileName);
			CSVWriter writer = new CSVWriter(fileWrite);
			List<String[]> data = new ArrayList<>();
			
			data.add(new String[] { "First_name", "Last_name", "Address", "Phone_Number", "Zip code", "City", "State","Email" });
			
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

	/**
	 * @purpose -> Read the data from CSV files
	 * 
	 * @param fileName -> user provides the File Name with extension (Eg:- output.csv)
	 * 
	 * @return -> It prints the data in console whcih is reading the data from the CSV File
	 *  
	 */
	public static void readCSVDataFromTheFile(String fileName) {
		try {
			FileReader filereader = new FileReader(IOService.CSV_FILE_PATH.file + fileName);
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
	 * @purpose -> UC15 :- Ability to Read or Write the Address Book with Persons Contact as
	 * 			   JSON File - Use GSON Library 
	 * 
	 * @param jsonFileName -> user provides the File Name with extension (Eg: output.json)
	 * 
	 * @return -> It will write the data into json file and Create an json in mentioned file path
	 * 
	 */
	public void writeDataIntoJsonFile(String jsonFileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			Writer writer = new FileWriter(IOService.JSON_FILE_PATH.file + jsonFileName);
			gson.toJson(P_list, writer); // convert Arraylist to JSON file
			writer.close(); // close writer
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @purpose -> Read the data from JSON files
	 * 
	 * @param jsonFileName -> ser provides the File Name with extension (Eg: output.json)
	 * 
	 * @return -> It prints the data in console whcih is reading the data from the JSON File
	 */
	public void readDataFromJsonFile(String jsonFileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			System.out.println("Reading data from a JSON file");
			System.out.println("----------------------------");
			Person[] data = gson.fromJson(new FileReader(IOService.JSON_FILE_PATH.file + jsonFileName), Person[].class);
			System.out.println(gson.toJson(data));
		} catch (IOException e) {
			System.err.println("File not found in given path");
		}
	}
}


/**
 * @author Ashwath Naidu <ashwath.bly@gmail.com>
 *
 * @version openjdk 11.0.12 2021-07-20
 * @version OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * @version OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 * 
 */
class AddressHashMap {
	
	static String First_name, Last_name, address, phoneNum, zip, city, state, email;
	static HashMap<String, ArrayList<Person>> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	// static ArrayList<Person> P_list = new ArrayList<>();

	/**
	 * @purpose -> UC6 :- Refactor to add multiple Address Book to the System. Each Address Book
	 * 			   has a unique Name - Use Console to add new Address Book - Maintain Dictionary
 	 * 			   of Address Book Name to Address Book
	 * 
	 * @return -> It returns the AddressBoook Person Data in the dictionary 
	 */
	public void AddPresonHashmap() {
		System.out.print("How many person you want to add :");
		int Count = sc.nextInt();
		for (int i = 1; i <= Count; i++) {
			First_name = JOptionPane.showInputDialog("Enter First name");
			Last_name = JOptionPane.showInputDialog("Enter Last name");
			address = JOptionPane.showInputDialog("Enter address");
			phoneNum = JOptionPane.showInputDialog("Enter phone number");
			zip =JOptionPane.showInputDialog("Enter zip");
			city = JOptionPane.showInputDialog("Enter city");
			state = JOptionPane.showInputDialog("Enter state");
			email = JOptionPane.showInputDialog("Enter Mail");
			Person data = new Person(First_name, Last_name, address, phoneNum, zip, city, state, email);

			/**
			 * @purpose -> UC7 :- Ability to ensure there is no Duplicate Entry of the same Person in a
			 * 			   particular Address Book - Duplicate Check is done on Person Name while adding
			 * 			   person to Address Book. - Use Collection Methods to Search Person by Name for
			 * 			   Duplicate Entry
			 * 
			 *  @return -> This process will avoid the duplocate person data into AddressBook
			 */
			if (map.containsKey(First_name.concat(Last_name))) {
				System.out.println("\nError : " + First_name + " " + Last_name + " already exists on this address book.");
				break;
			}
			// add the above PersonInfo object to arraylist
			map.put(data.getFirst_name(), new ArrayList<>());
			map.get(data.getFirst_name()).add(data);
		}
		System.out.println(map);
	}

	static void sortByCity() {
		
		for (Entry<String, ArrayList<Person>> entry : map.entrySet()) {
			ArrayList<Person> value = entry.getValue();
			List<Person> sortedList = value.stream().sorted(Comparator.comparing(Person::getCity)).collect(Collectors.toList());
			for (Person contact : sortedList) {
				System.out.println("\n\nFirst Name: " + contact.getFirst_name()+" zip code : " + contact.getCity());
				System.out.println("-------------------------------");
			}
		}
	}

}

/**
 * @author Ashwath Naidu <ashwath.bly@gmail.com>
 *
 * @version openjdk 11.0.12 2021-07-20
 * @version OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * @version OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 * 
 */
public class AddessBook {
	
	Person person = new Person(); // Object of Person Class

	/**
	 * @return This method will help us into loading Drivers and get Connection to MySql
	 */
	public static void connectToMysql() {
		try {
			Class.forName(IOService.DRIVER_IO.file);
			System.out.println("Driver loaded");
			getConnection();
		} catch (SQLException e) {
			System.out.println("An error occurred while connecting MySQL databse");
			e.getMessage();
		} catch (ClassNotFoundException e) {
			System.out.println("cannot find the driver in the class path !");
			e.getMessage();
		}

	}
	
	/**
	 * @return This method will help us into get connection to MySql Database
	 * 
	 * @throws SQLException
	 */
	private static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(IOService.DATABASE_IO.url, IOService.DATABASE_IO.userName,IOService.DATABASE_IO.password);
		System.out.println("Successfully connected to MySQL database test" + connection);
		return connection;
	}

	/**
	 * @param query -> user has to provid the query which will execute in MySql database and tables
	 * 
	 * @return -> Gives all the stored data in MySql DataBase
	 * 
	 * @throws SQLException
	 */
	private static List<Person> getEmployeeListData(String query) throws SQLException {
		Connection connection;
		List<Person> people = new ArrayList<>();
		
		connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next())
			people.add(new Person(resultSet.getString("firstName"), resultSet.getString("lastName"),
					resultSet.getString("Department_Type"), resultSet.getString("address"), resultSet.getString("city"),
					resultSet.getString("state"), resultSet.getString("zip"), resultSet.getString("phoneNumber"),
					resultSet.getString("email")));
		System.out.println(people.size());
		
		people.forEach(System.out::println);
		statement.close();
		resultSet.close();
		connection.close();
		return people;
	}
	
	/**
	 * @purpose -> UC16 :- Ability for the AddressBook Service to rerieve all the Entries from the DB
	 * 
	 * @param databaseIo -> Take inputs as DataBase Path
	 * 
	 * @return -> It return the person data from the DB
	 */
	public static List<Person> readAddressBookData(IOService databaseIo) {
		String query = "SELECT * FROM address_book;";
		try {
			List<Person> people = getEmployeeListData(query);
			return people;
		} catch (SQLException e) {
			System.out.println("An error occurred while connecting MySQL databse");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @purpose -> UC17 :- Ability to update the Contact Information in the address book for a person and ensure that the Contact Information in the memory is in Sync with the DB
	 * 
	 * @param Type -> type of the perosn 
	 * @param firstName -> First name of the Person
	 * @param lastName -> Last name of the Perosn
	 *  
	 * @return -> It returns the number if affected row in the table
	 */
	public long updateAddressBookData(String Type, String firstName, String lastName) {
		String query = String.format(
				"UPDATE address_book SET Department_Type='%s' WHERE firstName='%s' and lastName='%s';", Type, firstName,
				lastName);
		Connection connection;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			return statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @purpose -> UC18 :- Ability to Retrieve Contacts from the Database that were added in a particular period
	 * 
	 * @param startDate -> Takes the Start Date
	 * @param endDate -> Takes the End Date 
	 * 
	 * @return -> It provides the List of Person Data from database 
	 * @throws SQLException
	 */
	public List<Person> queryAddressBookDBReturnParticularPeriod(LocalDate startDate, LocalDate endDate)
			throws SQLException {
		String query = String.format("SELECT * FROM address_book WHERE stateDate BETWEEN '%s' AND '%s';",
				Date.valueOf(startDate), Date.valueOf(endDate));
		return getEmployeeListData(query);
	}

	/**
	 * @purpose -> UC19 :- Ability to Retrieve number of Contacts in the Database by City or State
	 * 
	 * @param city -> Takes the city name 
	 * 
	 * @return -> This will provid List of data from database which matchs the DB
	 * @throws SQLException
	 */
	public List<Person> queryAddressBookDataUsingPreparedStatemnt(String city) throws SQLException {
		String query = String.format("SELECT * FROM address_book WHERE  city = '%s';", city);
		return getEmployeeListData(query);
	}

	/**
	 * @purpose -> UC20 :- Ability to Add new Contact to the Address Book Database
	 * 
	 * @param firstName -> takes the First name as String DataType
	 * @param lastName -> takes the Last name as String DataType
	 * @param startDate -> takes the Start Date as LocalDate Type
	 * @param Type -> takes the Type as String DataType
	 * @param address -> takes the Address as String DataType
	 * @param city -> takes the City as String DataType
	 * @param state -> takes the State as String DataType
	 * @param zip_code -> takes the Zip Code as String DataType
	 * @param phoneNumber -> takes the phone number as String DataType
	 * @param email -> takes the email as String DataType
	 * 
	 * @return -> It return number of affected rows and prints in console the inserted new Perosn data into table.
	 * @throws SQLException
	 */
	public int addDataIntoAddressBook(String firstName, String lastName, LocalDate startDate, String Type,String address, String city, String state, String zip_code, String phoneNumber, String email) throws SQLException  {
		String insert = String.format("INSERT INTO address_book (`firstName`, `lastName`, `stateDate`, `Department_Type`, `address`, `city`, `state`, `zip`, `phoneNumber`, `email`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",firstName, lastName, startDate, Type, address, city, state, zip_code, phoneNumber, email);
		System.out.println(insert);
		int rs = 0;
		Connection connection = null;
		 try {
			connection = getConnection();
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			rs = statement.executeUpdate(insert);
			connection.commit();
			System.out.println("Transaction is commited.");
		 } catch (Exception e) {
			e.printStackTrace();	
			connection.rollback();
		 }
		 return rs;
	}

	
	public static void main(String[] args) throws IOException {
		
		// Person s1 = new Person("Ashwath", "Naidu", "123ash,nea rsai baba temple
		// road,", "934058XXX", "560037",
		// "Bangalour", "Karnataka", "Ashwath@xyz.in");
		// s1.print();

//		Addressbook b = new Addressbook();
//		 b.AddPreson(); // second person // UC2
//		 b.EditePeson("ashwath", "naidu"); // UC3
		// b.DeletePerson("naidu"); // UC4
		// b.addMultiPerson(); // UC5
//		 b.searchPersonsCity(); // UC8 - UC13
//		 b.writeDataIntoCSVfile("AddressBookDataCSV.csv"); // UC14 (Writing file)
//		 b.readCSVDataFromTheFile("AddressBookDataCSV.csv"); // UC14 (Reading file)
//		 b.writeDataIntoJsonFile("AddressBookDataJSON.json"); // UC15 (Writing file)
//		 b.readDataFromJsonFile("AddressBookDataJSON.json"); //UC15 Reading file)

//		AddressHashMap n = new AddressHashMap();
//		n.AddPresonHashmap();// UC6 - UC7
//		AddressHashMap.sortByCity();

	}

}
