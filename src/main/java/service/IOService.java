package service;

public enum IOService {

	// Database
	DATABASE_IO("jdbc:mysql://localhost:3306/address_book_database?&useSSL=false", "root", "Chanti_0704"),
	DRIVER_IO("com.mysql.cj.jdbc.Driver");

	public String file;
	
	public String url;
	public String userName;
	public String password;
	// File
	IOService(String file) {
		this.file = file;
	}
	// database
	IOService(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
}
