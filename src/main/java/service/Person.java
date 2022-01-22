package service;

/**
 * @author Ashwath Naidu <ashwath.bly@gmail.com>
 * 
 * @version openjdk 11.0.12 2021-07-20
 * @version OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * @version OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
public class Person {

	private String First_name;
	private String Last_name;
	private String address;
	private String phoneNum;
	private String zip;
	private String city;
	private String state;
	private String email;
	private String type;

	public Person() {
		super();
	}

	/**
	 * @param F_name
	 * @param L_name
	 * @param Addr
	 * @param MobileNum
	 * @param ZipCode
	 * @param City
	 * @param State
	 * @param Mail
	 */
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

	/**
	 * @param F_name
	 * @param L_name
	 * @param Addr
	 * @param MobileNum
	 * @param ZipCode
	 * @param City
	 * @param State
	 * @param Mail
	 * @param Type
	 */
	public Person(String F_name, String L_name, String Addr, String MobileNum, String ZipCode, String City,
			String State, String Mail, String Type) {
		First_name = F_name;
		Last_name = L_name;
		address = Addr;
		phoneNum = MobileNum;
		zip = ZipCode;
		city = City;
		state = State;
		email = Mail;
		type = Type;
	}

	/**
	 * @return First name
	 */
	public String getFirst_name() {
		return First_name;
	}
	/**
	 * @param first_name
	 */
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	
	/**
	 * @return Last name
	 */
	public String getLast_name() {
		return Last_name;
	}
	/**
	 * @param last_name
	 */
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	/**
	 * @return Address 
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return Phone Number 
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * @param phone Number
	 */
	public void setPhoneNum(String phoneNumber) {
		this.phoneNum = phoneNumber;
	}
	/**
	 * @return Zip Code 
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip Code
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return City
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return State
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Person{" + "First_name='" + First_name + '\'' + ", Last_name='" + Last_name + '\'' + ", address='"
				+ address + '\'' + ", phoneNum='" + phoneNum + '\'' + ", zip='" + zip + '\'' + ", city='" + city + '\''
				+ ", state='" + state + '\'' + ", email='" + email + '\'' + ", type='" + type + '\'' + '}';
	}
	/**
	 * @purpose -> This will display data in the console
	 */
	public void print() {
		System.out.println("\nFirst Name : " + First_name + "\nLast Name : " + Last_name + "\nAddress : " + address
				+ "\nEmial : " + email + "\nPhone No : " + phoneNum + "\nZip Code : " + zip + "\nCity : " + city
				+ "\nState : " + state);
		System.out.println("\n\n***************************************************************************");
	}

}
