/*----------------------------------------
 * Program: Contact Service V 1.0
 * Programmer: Jacob Sullivan
 * Date: 3/19/2022
 * ---------------------------------------
 */

package contactService;
 
//This class creates instances of the Contact class
public class Contact {
	
	//Declaration of needed variables 
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	//constructor with passed parameters
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		
		/* The following if statements validate each passed parameter
		 * ensuring each meets the specified requirements given
		 * by the client. If not, an exception is thrown and the object
		 * is not created.
		 * 
		 */
		
		if ((contactId == null) || (contactId.length() > 10)) {
			throw new IllegalArgumentException("Invalid Contact Id");
		}
		
		if ((firstName == null) || (firstName.length() > 10)) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		if ((lastName == null) || (lastName.length() > 10)) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if ((phoneNumber == null) || !(phoneNumber.length() == 10)) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		if ((address == null) || (address.length() > 30)) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	//Getters and Setters for each given parameter
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {		
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		if ((firstName == null) || (firstName.length() > 10)) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		
		if ((lastName == null) || (lastName.length() > 10)) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		
		if ((phoneNumber == null) || !(phoneNumber.length() == 10)) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		
		if ((address == null) || (address.length() > 30)) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.address = address;
	}
	
	
}
