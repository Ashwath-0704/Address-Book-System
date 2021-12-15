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
		// System.out.println(
		// 		"\n\n*****************************************************************************************");
	}
}


class AddressBook {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * UC1 Ability to create a Contacts in Address Book with first and last names,
		 * address, city, state, zip, phone number and email...
		 */
			Person s1 = new Person("Ashwath", "Naidu", "123ash,nea rsai baba temple road,", "934058XXX", "560037",
					"Bangalour", "Karnataka", "Ashwath@xyz.in");
			s1.print();


	}
}