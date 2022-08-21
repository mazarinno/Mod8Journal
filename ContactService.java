package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	// contacts will be held here 
	private List<Contact> contacts;
	
	// contact list initialized 
    public ContactService()
    {
        contacts = new ArrayList<>();
    }
   
    // The contact service shall be able to add contacts with a unique ID
    public boolean addContact(Contact contact, String contactID)
    {    
    	// go through each contact to check if there is an ID match
        for (Contact contactElement : contacts)
        {
            //if equals to contactID, do not add this contact since ID is not unique
            if (contactElement.getContactID().equals(contactID))
            {
            	return false;
            }
        }
        
        // if func has not found error, contact will be added 
        return contacts.add(contact);
    }
    
    // The contact service shall be able to delete contacts per contact ID.
    public boolean deleteContact(String contactID)
    {
        // go through each contact to check if there is an ID match
        for (Contact contactElement : contacts)
        {
            // if match found, delete contact
            if (contactElement.getContactID().equals(contactID))
            {
                return contacts.remove(contactElement);
            }
        }
        
        //no match found, exit
        throw new IllegalArgumentException("User does not exist");
    }
    
    // The contact service shall be able to update contact fields per contact ID. 
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address)
    {
        //run through contact loop
        for (Contact contactList:contacts)
        {
        	// if match found, update contact
            if (contactList.getContactID().equals(contactID))
            {
                //set each of the values as long as meet's requirements nor empty
                if(firstName != null && !(firstName.length()>10))
                {
                    contactList.setFirstName(firstName);
                }
                if(lastName != null && !(lastName.length()>10))
                {
                    contactList.setLastName(lastName);
                }
                if(phone != null && (phone.length()==10))
                {
                    contactList.setPhone(phone);
                }
                if(address != null && !(address.length()>30))
                {
                    contactList.setAddress(address);
                }
             
                return true;
            }
        }

        //no match found, exit
        throw new IllegalArgumentException("User does not exist");
    }
}
