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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import contactService.Contact;

//This class is a JUnit 5 test class, meant to test the functionality of the Contact Class.
class ContactTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*This test validates the correct creation of a contact object 
	 * and throws an exception if an error occurs
	 * @Param - String contactId - unique contact Id for created contact
	 * @Param - String firstName - holds first name of contact
	 * @Param - String lastName - holds last name of contact
	 * @Param - String phoneNumber - holds phone number of contact
	 * @Param - String address - holds address of contact
	 */
	@DisplayName("Test Creation of Contact Object and Getter Methods")
	@Test
	final void testContactCreation() {
        String contactId = "33355544";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		
		Contact test = new Contact(contactId, firstName, lastName, phoneNumber, address);
			
		//The following assertions ensure the object created retains the passed attributes
		assertEquals(test.getContactId(), contactId);
		assertEquals(test.getFirstName(), firstName);
		assertEquals(test.getLastName(), lastName);
		assertEquals(test.getPhoneNumber(), phoneNumber);
		assertEquals(test.getAddress(), address);
			
	}
      
      	
	
	
	/* This test implements the "setter" methods and validates their functionality
	 * and throws an exception if an error occurs
	 * @Param - String contactId - unique contact Id for created contact
	 * @Param - String firstName - holds first name of contact
	 * @Param - String lastName - holds last name of contact
	 * @Param - String phoneNumber - holds phone number of contact
	 * @Param - String address - holds address of contact
	 */
	@DisplayName("Test Setter Methods")
	@Test
	final void testSetFirstName() {
		String contactId = "33355544";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		Contact test = new Contact(contactId, firstName, lastName, phoneNumber, address);
			
		//define test variables for use in setter methods
		String testFirstName = "Daniel";
		String testLastName = "Johnson";
		String testPhoneNumber = "7776665555";
		String testAddress = "32 Wallaby Way";
	        
		test.setFirstName(testFirstName);
		test.setLastName(testLastName);
		test.setPhoneNumber(testPhoneNumber);
		test.setAddress(testAddress);
	        
		//assertions validating new variables were set as new values for created object
		assertEquals(test.getFirstName(), testFirstName);
		assertEquals(test.getLastName(), testLastName);
		assertEquals(test.getPhoneNumber(), testPhoneNumber);
		assertEquals(test.getAddress(), testAddress);
		
        
	}
	
	/* The rest of the following tests validate the proper handling of invalid inputs
	 * Each throws an exception if an the input is invalid occurs, confirming
	 * proper functionality
	 * @Param - String contactId - unique contact Id for created contact
	 * @Param - String firstName - holds first name of contact
	 * @Param - String lastName - holds last name of contact
	 * @Param - String phoneNumber - holds phone number of contact
	 * @Param - String address - holds address of contact
	 */
	@DisplayName("Test Invalid Contact Id - Too Long")
	@Test
	final void testIdTooLong() {
		
		String contactId = "120947097102973092340917092";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including an ID that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
        
	}
	
	@DisplayName("Test Null Id")
	@Test
	final void testNullId() {
		
		String contactId = null;
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including an ID that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
	
	@DisplayName("Test First Name - Null")
	@Test
	final void testNullFirstName() {
      	String contactId = "12345";
      	String firstName = null;
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
    
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a first name that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
	@DisplayName("Test First Name - Too Long")
	@Test
	final void testFirstNameTooLong() {
		
		String contactId = "12345";
      	String firstName = "snoiandaoindwoiandonawidnaodn";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a first name that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
	
	@DisplayName("Test Last Name Too Long")
	@Test
	final void testLastNameTooLong() {
		
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = "SullivanaoiusbfoignoianoisndoifnioNOIANEOIFNDASFDKJGBKJABKSJDBFKJB";
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a last name that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	@DisplayName("Test Last Name - Null")
	@Test
	final void testNullLastName() {
		
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = null;
        String phoneNumber = "5555555555";
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a last name that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	
	@DisplayName("Test Phone Number - Too Long")
	@Test
	final void testPhoneNumberTooLong() {
		
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "21894372398798712938794823798794" ;
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	@DisplayName("Test Phone Number - Too Short")
	@Test
	final void testPhoneNumberTooShort() {
		
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "777555666" ;
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	@DisplayName("Test Phone Number - Null")
	@Test
	final void testPhoneNumberNull() {
		
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = null;
        String address = "55 Street Street";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
	}
	
	
	
	@DisplayName("Test Invalid Address - Too Long")
	@Test
	final void testInvalidAddress() {
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = "osdnfioaosbdjfbkjbqwkjeblfbisdbjlbaksdklsdfbka"
        		+ "oasdbfoinkasndlkfnklnlkanslkdnlknlknkdsnalknvklnaiusdif"
        		+ "sdnfknlkasndlknflknlkasdf";
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
	@DisplayName("Test Invalid Address - Null")
	@Test
	final void testNullAddress() {
		String contactId = "12345";
      	String firstName = "Jake";
        String lastName = "Sullivan";
        String phoneNumber = "5555555555";
        String address = null;
        
		//assert an exception is thrown when Contact(params) is passed these test params
		//including a phone number that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phoneNumber, address);
		});
		
	}
	
}
