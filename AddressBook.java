package AddressBook;

import java.util.*;
import javax.swing.*;

/*
 * UC1 Ability to create a Contacts in Address Book with first and last names,
 * address, city, state, zip, phone number and email...
 */
class Person {

	String First_name, Last_name, address, phoneNum, zip, city, state, email;
	public Object name;

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
		System.out.println(
				"\n\n*****************************************************************************************");
	}
}

class Addressbook1 {

	ArrayList<Person> P_list = new ArrayList<>();
	/*
	 * UC2
	 */
	public void AddPreson( ) {
		
		String First_name = JOptionPane.showInputDialog("Enter First name");
		String Last_name = JOptionPane.showInputDialog("Enter Last name");
		String address = JOptionPane.showInputDialog("Enter address");
		String phoneNum = JOptionPane.showInputDialog("Enter phone number");
		String zip = JOptionPane.showInputDialog("Enter zip");
		String city = JOptionPane.showInputDialog("Enter city");
		String state = JOptionPane.showInputDialog("Enter state");
		String email = JOptionPane.showInputDialog("Enter Mail");

		Person data = new Person(First_name, Last_name, address, phoneNum, zip, city, state, email);

		// add the above PersonInfo object to arraylist
		P_list.add(data);
		P_list.toString();
		for (Person p : P_list) {
			p.print();
		}
	}

	/*
	 * UC3
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
	 * UC4
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
}

class AddressBook {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			Person s1 = new Person("Ashwath", "Naidu", "123ash,nea rsai baba temple road,", "934058XXX", "560037",
//					"Bangalour", "Karnataka", "Ashwath@xyz.in");
//			s1.print();

		Addressbook1 b = new Addressbook1();
		b.AddPreson(); // first person
		b.AddPreson(); // second person
		b.EditePeson("ashwath", "naidu");
		b.DeletePerson("naidu");

	}
}
