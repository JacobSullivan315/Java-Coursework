/*----------------------------------------
 * Program: Contact Service V 1.0
 * Programmer: Jacob Sullivan
 * Date: 3/19/2022
 * ---------------------------------------
 */

package contactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import contactService.ContactService;
import contactService.Contact;

//This class is the JUnit 5 test class which handles the testing of
//the ContactService class functionality
class ContactServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	//clear the array list after each test to prevent spill over into subsequent tests
	@AfterEach
	void tearDown() throws Exception {
		ContactService.contactList.removeAll(ContactService.contactList);
	}
	
	//This method tests the creation and addition of a new contact object
	// to the array list
	@DisplayName("Test addContact Method - single contact")
	@Test
	final void testAddContact() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Street";
		
		//Create new ContactService object, then use it to create a new Contact object
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		//Assertions to successful creation of contact object and successful addition to the array list
		assertTrue(!(ContactService.contactList.isEmpty()));
		assertEquals(ContactService.contactList.get(0).getContactId(), "1");
		assertEquals(ContactService.contactList.get(0).getFirstName(), "Jake");
		assertEquals(ContactService.contactList.get(0).getLastName(), "Sullivan");
		assertEquals(ContactService.contactList.get(0).getPhoneNumber(), "7774446666");
		assertEquals(ContactService.contactList.get(0).getAddress(), "33 Street Street");
	}
	
	//This method tests the creation and storage of multiple contact in the array list
	@DisplayName("Test addContact Method - multiple contacts")
	@Test
	final void testAddMultipleContacts() {
		
		//Create new ContactService object, then use it to create a new Contact object
		ContactService test = new ContactService();
		test.addContact("1", "Jake", "Sullivan", "7774446666", "33 Street Street");
		test.addContact("2", "Henry", "Ford", "7778889999", "44 Road Road");
		test.addContact("3", "William", "Taft", "5556668888", "55 Rugg Road");
		
		//assign list size to a variable for comparison test
		//assert list size is equal to amount of test objects created
		final int listSize = ContactService.contactList.size();
		assertEquals(3, listSize);
		
		//Assertions to successful creation of each contact object and successful addition to the array list
		assertTrue(!(ContactService.contactList.isEmpty()));
		assertEquals(ContactService.contactList.get(0).getContactId(), "1");
		assertEquals(ContactService.contactList.get(0).getFirstName(), "Jake");
		assertEquals(ContactService.contactList.get(0).getLastName(), "Sullivan");
		assertEquals(ContactService.contactList.get(0).getPhoneNumber(), "7774446666");
		assertEquals(ContactService.contactList.get(0).getAddress(), "33 Street Street");
		
		assertTrue(!(ContactService.contactList.isEmpty()));
		assertEquals(ContactService.contactList.get(1).getContactId(), "2");
		assertEquals(ContactService.contactList.get(1).getFirstName(), "Henry");
		assertEquals(ContactService.contactList.get(1).getLastName(), "Ford");
		assertEquals(ContactService.contactList.get(1).getPhoneNumber(), "7778889999");
		assertEquals(ContactService.contactList.get(1).getAddress(), "44 Road Road");
		
		assertTrue(!(ContactService.contactList.isEmpty()));
		assertEquals(ContactService.contactList.get(2).getContactId(), "3");
		assertEquals(ContactService.contactList.get(2).getFirstName(), "William");
		assertEquals(ContactService.contactList.get(2).getLastName(), "Taft");
		assertEquals(ContactService.contactList.get(2).getPhoneNumber(), "5556668888");
		assertEquals(ContactService.contactList.get(2).getAddress(), "55 Rugg Road");
	}

	//duplicateIdTest to ensure passing a duplicate ID throws an exception
	@DisplayName("ContactService Duplicate ID Test")
	@Test
	final void duplicateIdTest() {
		
		//create ContactService object for test and use it to create a contact object
		ContactService test = new ContactService();
		test.addContact("1", "Jake", "Sullivan", "7774446666", "33 Street Street");
		
		//Assert exception thrown if same ID is passed again
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.addContact("1", "Henry", "Ford", "7778889999", "44 Road Road");
		});
		
	}
	
	//This test ensures existing contact objects are deleted from the array list
	@DisplayName("Test deleteContact Method")
	@Test
	final void testDeleteContact() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		//create new ContactService object and use it to create a new Contact Object
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		//Assert object was created and added to list
		assertTrue(!(ContactService.contactList.isEmpty()));
		
		//if contactList is not empty, pass the ID as a parameter to deleteContact
		if (!(ContactService.contactList.isEmpty())) {
			test.deleteContact(contactId);
		}
		
		//Assert the list is now empty and the object has been deleted
		assertTrue(ContactService.contactList.isEmpty());
	}
	
	/* The following tests validate the functionality of our edit methods
	 * by creating a contact object with predefined parameters and then
	 * calling the appropriate methods to alter the values of the 
	 * created objects attributes
	 */
	@DisplayName("Test editFirstName Method - Valid")
	@Test
	final void testEditFirstName() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testName = "William";
		test.editFirstName(contactId, testName);
		
		//assert the first name attribute of the contact object was updated
		assertEquals(ContactService.contactList.get(0).getFirstName(), "William");
		
	}
	
	//testing of attempted use of first name that is too long
	@DisplayName("Test editFirstName Method - Invalid")
	@Test
	final void testEditFirstNameInvalid() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testName = "Okasjdbkjwfnklaknslkdnqbuwidbjksbajbwj";
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a first name that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editFirstName("1", testName);
		});
		
	}
	
	//testing of attempted use of null first name
	@DisplayName("Test editFirstName Method - Null")
	@Test
	final void testEditFirstNameNull() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testName = null;
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a first name that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editFirstName("1", testName);
		});
		
	}
	
	@DisplayName("Test editLastName Method")
	@Test
	final void testEditLastName() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testName = "Ford";
		test.editLastName(contactId, testName);
		
		//assert the last name attribute of the contact object was updated
		assertEquals(ContactService.contactList.get(0).getLastName(), "Ford");
	}
	
	//testing of attempted use of last name that is too long
	@DisplayName("Test editLastName Method - Invalid")
	@Test
	final void testEditLastNameInvalid() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testName = "Okasjdbkjwfnklaknslkdnqbuwidbjksbajbwj";
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a last name that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editLastName("1", testName);
		});
		
	}
	
	//testing of attempted use of null last name
	@DisplayName("Test editLastName Method - Null")
	@Test
	final void testEditLastNameNull() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testName = null;
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a last name that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editLastName("1", testName);
		});
		
	}

	@DisplayName("Test editPhone (Phone Number) Method - Valid")
	@Test
	final void testEditPhone() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testPhone = "7778889999";
		test.editPhone(contactId, testPhone);
		
		//assert the phone number attribute of the contact object was updated
		assertEquals(ContactService.contactList.get(0).getPhoneNumber(), testPhone);
	}
	
	//testing of attempted use of phone number that is too short
	@DisplayName("Test editPhone Method - Too Short")
	@Test
	final void testEditPhoneTooShort() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testNumber = "5375";
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editPhone("1", testNumber);
		});
		
	}
	
	//testing of attempted use of phone number that is too long
	@DisplayName("Test editPhone Method - Too Long")
	@Test
	final void testEditPhoneTooLong() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testNumber = "537543905719723097340985092839730192";
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editPhone("1", testNumber);
		});
		
	}
	
	//testing of attempted use of null last name
	@DisplayName("Test editPhone Method - Null")
	@Test
	final void testEditPhoneNull() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testNumber = null;
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a null phone number
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editPhone("1", testNumber);
		});
		
	}

	@DisplayName("Test editAddress Method - Valid")
	@Test
	final void testEditAddress() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testAddress = "77 Boulevard Way";
		test.editAddress(contactId, testAddress);
		
		//assert the phone number attribute of the contact object was updated
		assertEquals(ContactService.contactList.get(0).getAddress(), testAddress);
		
	}
	
	@DisplayName("Test editAddress Method - Too Long")
	@Test
	final void testEditAddressTooLong() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testAddress = "77 saiufboibionaklsndkbkjkqjbwkjdkjfzbkjnklvnlkdnslkanibiuwbebdjfksbd"
				+ "oiansdinlkfnalksndlknflknklnlknaklnsldknflnASOIENFOINALKSNDLKFNLKNLAKSNLKDNFLKNLKDFN;L";
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including an address that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editAddress("1", testAddress);
		});
	}
	
	@DisplayName("Test editAddress Method - Null")
	@Test
	final void testEditAddressNull() {
		String contactId = "1";
		String firstName = "Jake";
		String lastName = "Sullivan";
		String phoneNumber = "7774446666";
		String address = "33 Street Strret";
		
		ContactService test = new ContactService();
		test.addContact(contactId, firstName, lastName, phoneNumber, address);
		
		String testAddress = null;
		
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a null address
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.editAddress("1", testAddress);
		});
	}

}



