/*----------------------------------------
 * Program: Contact Service V 1.0
 * Programmer: Jacob Sullivan
 * Date: 3/19/2022
 * ---------------------------------------
 */

package contactService;

import java.util.List;
import java.util.ArrayList;

//The following class contains methods to modify created contact objects
public class ContactService {
	
	//define an array list to hold created contacts
	//other data structures may be implemented in future versions
	public static List<Contact> contactList =  new ArrayList<Contact>();

	//This method handles the adding of a newly created contact object to the array list
	public void addContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		
		if (!(contactList.isEmpty())) {
			for (Contact c:contactList) {
				if (c.getContactId().equals(contactId)) {
					throw new IllegalArgumentException("Duplicate ID");
				}
			}
		}
		
		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
		contactList.add(contact);
		
	}
	
	//this method handles the deleting of existing contacts in the list
	public void deleteContact(String contactId) {
		
		//iterate through the list until the searched id is found, then remove that contact
		for (int i = 0; i < contactList.size(); i++) {
			Contact c = contactList.get(i);
			if (c.getContactId().equals(contactId)) {
				contactList.remove(i);
			}
		}
	}
	
	//this method allow the user to edit the first name of a given
	//contact by searching for the associated contact ID
	public void editFirstName(String contactId, String firstName) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact c = contactList.get(i);
			if (c.getContactId().equals(contactId)) {
				c.setFirstName(firstName);
			}
		}
	}
	
	//this method allows the user to edit the last name in the same fashion
	public void editLastName(String contactId, String lastName) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact c = contactList.get(i);
			if (c.getContactId().equals(contactId)) {
				c.setLastName(lastName);
			}
		}
	}
	
	//this method allows the user to edit the phone number of a given contact
	public void editPhone(String contactId, String phoneNumber) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact c = contactList.get(i);
			if (c.getContactId().equals(contactId)) {
				c.setPhoneNumber(phoneNumber);
			}
		}
	}
	
	//this method allows the user to edit the address of a given contact
	public void editAddress(String contactId, String address) {
		for (int i = 0; i < contactList.size(); i++) {
			Contact c = contactList.get(i);
			if (c.getContactId().equals(contactId)) {
				c.setAddress(address);
			}
		}
}
}
