package AddressBook;

import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;

import javax.swing.*;

import Model.Employee;

import java.util.stream.*;

/*
 * UC1 :- Ability to create a Contacts in AddressBook with first and last names, address,city, state, zip, phone number and email...
 * Every UC is in a separate Git Branch and then merged with main
 * Naming Convention, Indentation, etc Code Hygiene will be checked during
 * Review Git Check In Comments and Version History will be monitored
 * 
 */
class Person {

	String First_name, Last_name, address, phoneNum, zip, city, state, email;

	public Person(String F_name, String L_name, String Addr, String MobileNum, String ZipCode, String City,
			String State, String Mail) {
		First_name = F_name;
		Last_name = L_name;
		address = Addr;
		phoneNum = MobileNum;
		zip = ZipCode;
		city = City;
		state = State;
		email = Mail;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [First_name=" + First_name + ", Last_name=" + Last_name + ", address=" + address + ", phoneNum="
				+ phoneNum + ", zip=" + zip + ", city=" + city + ", state=" + state + ", email=" + email + "]";
	}

	public void print() {
		System.out.println("\nFirst Name : " + First_name + "\nLast Name : " + Last_name + "\nAddress : " + address
				+ "\nEmial : " + email + "\nPhone No : " + phoneNum + "\nZip Code : " + zip + "\nCity : " + city
				+ "\nState : " + state);
		System.out.println("\n\n*****************************************************************************");
	}
}

class Addressbook1 {

	static ArrayList<Person> P_list = new ArrayList<>();
	static String First_name, Last_name, address, phoneNum, zip, city, state, email;
	static int cityAndStateCount = 0;

	/*
	 * UC2 :- Ability to add a new Contact to Address Book - Use Console to add
	 * person details from AddressBookMain class - Use Object Oriented Concepts to
	 * manage relationship between AddressBook and Contact Person
	 */
	public void AddPreson() {

		First_name = JOptionPane.showInputDialog("Enter First name");
		Last_name = JOptionPane.showInputDialog("Enter Last name");
		address = JOptionPane.showInputDialog("Enter address");
		phoneNum = JOptionPane.showInputDialog("Enter phone number");
		zip = JOptionPane.showInputDialog("Enter zip");
		city = JOptionPane.showInputDialog("Enter city");
		state = JOptionPane.showInputDialog("Enter state");
		email = JOptionPane.showInputDialog("Enter Mail");

		Person data = new Person(First_name, Last_name, address, phoneNum, zip, city, state, email);
//		Set<Person> updatedMarks= P_list.stream()
//              .filter(t->Collections.frequency(P_list, data)).collect(Collectors.toSet());

//		if (P_list.contains(First_name.concat(Last_name))) {
//			System.out.println("\nError : " + First_name + " " + Last_name + " already exists on this address book.");
////			break;
//		}

		// add the above PersonInfo object to arraylist
		P_list.add(data);

		P_list.toString();
//		for (Person p : P_list) {
//			p.print();
//		}
	}

	/*
	 * UC3 :- Ability to edit existing contact person using their name - Use Console
	 * to edit person details
	 */
	public void EditePeson(String name, String name1) {
		for (Person i : P_list) {
			if (name.equals(i.First_name)) {
				i.First_name = name1;
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
			if (name.equals(p.First_name)) {
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
		Scanner sc = new Scanner(System.in);
		System.out.print("How many person you want to add :");
		int Count = sc.nextInt();
		for (int i = 1; i <= Count; i++) {
			AddPreson();
		}
		for (Person p : P_list) {
			p.print();
		}
	}

	/*
	 * Ability to search Person in a City or State
	 */
	public void searchPersonsCity() {
		Hashtable<Integer, Person> hashTable = new Hashtable<Integer, Person>();

		String name, cityOrState, personName;
		name = JOptionPane.showInputDialog(
				"choose what you want to search \nFind city or state by person? -> press (1) \nFind perons by city or state? -> press  (2)\nFind the contact persons by city or state? -> (3)\nFind the sorted the by city's? --> (4)\nFind the sorted the by zip code? --> (5)");
		switch (name) {
		/*
		 * UC8 :- Ability to search Person in a City or State across the multiple
		 * AddressBook - Search Result can show multiple person in the city or state
		 */
		case "1":
			personName = JOptionPane
					.showInputDialog("Enter the person first and last name without space (eg:- KrishnaReddy)");
			List<Person> list1 = P_list.stream()
					.filter(p_Name -> p_Name.First_name.concat(Last_name).equals(personName))
					.collect(Collectors.toList());
			for (Person p : list1) {
				System.out.println(personName + " found in city : " + p.city + " and state : " + p.state);
//				hashTable.put(, p)
			}
			break;
		/*
		 * UC9 :- Ability to view Persons by City or State - Maintain Dictionary of City
		 * and Person as well as State and Person - Use Collection Library to maintain
		 * Dictionary
		 */
		case "2":
			cityOrState = JOptionPane.showInputDialog("Enter the state name ");
			List<Person> list = P_list.stream().filter(p_Name -> p_Name.state.equals(cityOrState))
					.collect(Collectors.toList());
			for (Person p : list) {
				System.out.println("Person name: " + p.First_name + " " + p.Last_name);
			}
			break;

		/*
		 * UC10 :- Ability to get number of contact persons i.e. count by City or State
		 * - Search Result will show count by city and by state
		 */
		case "3":
			cityOrState = JOptionPane.showInputDialog("Enter the city or state name");
			List<Person> list3 = P_list.stream().filter(p_Name -> p_Name.state.equals(cityOrState))
					.collect(Collectors.toList());
			for (Person p : list3) {
				System.out.println("\nPerson Name: " + p.First_name + " " + p.phoneNum);
			}
			break;
		/*
		 * UC11 :- Ability to sort the entries in the address book alphabetically by
		 * Person’s name
		 */
		case "4":
			List<String> sortedPersonNameList = P_list.stream().map(c -> c.First_name.concat(c.Last_name)).sorted()
					.collect(Collectors.toList());
			sortedPersonNameList.forEach(System.out::println);
			break;
		/*
		 * UC12 :- Ability to sort the entries in the address book by City, State, or
		 * Zip
		 */
		case "5":
			List<String> sortedZipCode = P_list.stream().map(c -> c.zip).sorted().collect(Collectors.toList());
			sortedZipCode.forEach(System.out::println);
			break;
		default:
			System.out.println("Invalid user input");
			break;
		}
	}

}

/*
 * UC6 :- Refactor to add multiple Address Book to the System. Each Address Book
 * has a unique Name - Use Console to add new Address Book - Maintain Dictionary
 * of Address Book Name to Address Book
 * 
 */
class AddressHashMap {
	static String First_name, Last_name, address, phoneNum, zip, city, state, email;
	static HashMap<String, ArrayList<Person>> map = new HashMap<>();
//	static ArrayList<Person> P_list = new ArrayList<>();

	public void AddPresonHashmap() {
		Scanner sc = new Scanner(System.in);
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

class AddressBook {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * UC1 Ability to create a Contacts in Address Book with first and last names,
		 * address, city, state, zip, phone number and email...
		 */
//			Person s1 = new Person("Ashwath", "Naidu", "123ash,nea rsai baba temple road,", "934058XXX", "560037",
//					"Bangalour", "Karnataka", "Ashwath@xyz.in");
//			s1.print();
		
		Addressbook1 b = new Addressbook1();
//		b.AddPreson(); // first person// UC2
//		b.AddPreson(); // second person // UC2
//		b.EditePeson("ashwath", "naidu"); // UC3
//		b.DeletePerson("naidu"); // UC4
//		b.addMultiPerson(); // UC5
		b.searchPersonsCity(); // UC8 - UC12

		AddressHashMap n = new AddressHashMap();
		n.AddPresonHashmap();// UC6 - UC7
//		n.sortByCity();
	}
}
