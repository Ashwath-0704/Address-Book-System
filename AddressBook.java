package AddressBook;

import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;

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

	public void print() {
		System.out.println("\nFirst Name : " + First_name + "\nLast Name : " + Last_name + "\nAddress : " + address
				+ "\nEmial : " + email + "\nPhone No : " + phoneNum + "\nZip Code : " + zip + "\nCity : " + city
				+ "\nState : " + state);
		System.out.println("\n\n*****************************************************************************");
	}
}

class Addressbook1 {

	ArrayList<Person> P_list = new ArrayList<>();
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
//		if(P_list.contains(city)) {
//			System.out.println("city name is given already!"+city);
//		}else {
//			cityAndStateCount++;
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
		Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();

		String name, cityOrState, personName;
		name = JOptionPane.showInputDialog(
				"choose what you want to search \nFind city or state by person? -> press (1) \nFind perons by city or state? -> press  (2)\nFind the contact persons by city or state? -> (3)");
		switch (name) {
		/*
		 * UC8 :- Ability to search Person in a City or State across the multiple
		 * AddressBook - Search Result can show multiple person in the city or state
		 */
		case "1":
			personName = JOptionPane
					.showInputDialog("Enter the person first and last name without space (eg:- KrishnaReddy)");
			for (int i = 0; i < P_list.size(); i++) {
				Person p = P_list.get(i);
				if (personName.equals(p.First_name.concat(p.Last_name))) {
					hashTable.put(i + 1, p.city);
				} else
					continue;
			}
			System.out.println(personName + " found in " + hashTable);
			break;
}

/*
 * UC6 :- Refactor to add multiple Address Book to the System. Each Address Book
 * has a unique Name - Use Console to add new Address Book - Maintain Dictionary
 * of Address Book Name to Address Book
 * 
 */
class AddressHashMap {
	static String First_name, Last_name, address, phoneNum, zip, city, state, email;
	HashMap<String, Person> map = new HashMap<>();

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
			map.put(First_name.concat(Last_name), data);
		}
		printMap(map);
	}

	public void printMap(HashMap<String, Person> map) {
		for (String map1 : map.keySet()) {
			System.out.println("Key: " + map1 + " Value: " + map.get(map1));
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
		b.addMultiPerson(); // UC5
		b.searchPersonsCity(); // UC8 and UC9

//		AddressHashMap n = new AddressHashMap();
//		n.AddPresonHashmap();// UC6 and UC7
	}
}
