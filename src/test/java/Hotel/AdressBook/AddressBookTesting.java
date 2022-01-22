package Hotel.AdressBook;

/**
 * @author Ashwath Naidu <ashwath.bly@gmail.com>
 * 
 * @version openjdk 11.0.12 2021-07-20
 * @version OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * @version OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 *
 */
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.AddessBook;
import service.IOService;
import service.Person;

public class AddressBookTesting {
	
	@Test 
	public void givenAddressDB_whenRetrieve_shouldMatchEmployeeCount() {
		List<Person> addressBookDataJDBCs = AddessBook.readAddressBookData(IOService.DATABASE_IO);
		Assert.assertEquals(14, addressBookDataJDBCs.size());
	}

	@Test // UC17
	public void givenNewSalaryForEmployee_whenUpdated_shouldMatchSyncWithDBStatemnt() {
		AddessBook addessBook = new AddessBook();
		long updatedRowsInDB = addessBook.updateAddressBookData("Friend", "Ashwath", "Naidu");
		Assert.assertEquals(1, updatedRowsInDB);
	}

	@Test // UC18
	public void givenDateRange_shouldReturnContactsAddedCount() throws SQLException {
		AddessBook addessBook = new AddessBook();
		LocalDate startDate = LocalDate.of(2021, 10, 01);
		LocalDate endDate = LocalDate.of(2021, 12, 30);
		List<Person> updatedRowsInDB = addessBook.queryAddressBookDBReturnParticularPeriod(startDate, endDate);
		Assert.assertEquals(4, updatedRowsInDB.size());
	}

	@Test // UC19
	public void givenEmployeeName_shouldMatchSyncWithDBPreparedStatemnt() throws SQLException {
		AddessBook addessBook = new AddessBook();
		List<Person> updatedRowsInDB = addessBook.queryAddressBookDataUsingPreparedStatemnt("Kurnool");
		Assert.assertEquals(3, updatedRowsInDB.size());
	}

	@Test // UC20
	public void givenAddressBookdata_shouldAddIntoAddressDatabase_ReturnCountofAddressBook() throws SQLException {
		AddessBook addessBook = new AddessBook();
		LocalDate startDate = LocalDate.of(2019, 03, 01);
		int updatedRowsInDB = addessBook.addDataIntoAddressBook("Harini", "Reddy", startDate, "Family", "BTM_Layout","Bengaluru", "Karanatak", "560001", "852147963", "xyzgmail.com");
		Assert.assertEquals(1, updatedRowsInDB);
	}

}
