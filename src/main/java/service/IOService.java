package service;

/**
 * @author Ashwath Naidu <ashwath.bly@gmail.com>
 * 
 * @version openjdk 11.0.12 2021-07-20
 * @version OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * @version OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
public enum IOService {

	// File IO
	FILE_PATH("C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\AdressBookNew\\src\\main\\java\\service\\AddressBookeOutputData.txt"),
	CSV_FILE_PATH("C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\AdressBookNew\\src\\main\\java\\service\\"),
	JSON_FILE_PATH("C:\\Users\\hp\\OneDrive\\BridgeLabz\\eclipse-workspace\\AdressBookNew\\src\\main\\java\\service\\"),

	// Database
	DATABASE_IO("jdbc:mysql://localhost:3306/address_book_database?allowPublicKeyRetrieval=true&useSSL=false", "root", "Chanti_0704"),
	DRIVER_IO("com.mysql.cj.jdbc.Driver");

	public String file;

	public String url;
	public String userName;
	public String password;

	/**
	 * @purpose -> To get the data of file from the enum class
	 * @param file
	 */
	// File
	IOService(String file) {
		this.file = file;
	}

	/**
	 * @purpose -> To get the data of url, userName, password from the enum class
	 * @param url
	 * @param userName
	 * @param password
	 */
	// database
	IOService(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
}
