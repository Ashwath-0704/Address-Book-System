package Hotel.AdressBook;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.AddessBook;
import service.IOService;
import service.Person;

public class AddressBookTesting {

	@Test // UC16
	public void givenAddressDB_whenRetrieve_shouldMatchEmployeeCount() {
		List<Person> addressBookDataJDBCs = AddessBook.readAddressBookData(IOService.DATABASE_IO);
		Assert.assertEquals(5, addressBookDataJDBCs.size());
	}
}