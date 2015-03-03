package pt.tecnico.phonebook.domain;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

import pt.tecnico.phonebook.exception.ContactDoesNotExistException;
import pt.tecnico.phonebook.exception.NameAlreadyExistsException;

public class Person extends Person_Base {
    
    public Person(String name) {
        super();
	setName(name);
    }    	      
    
    Person() {
    }    	      

    public void delete() {
	for (Contact c : getContactSet())
	    c.delete();

	setPhoneBook(null);
	deleteDomainObject();
    }

    public Element exportToXML() {
	Element element = new Element("person");

	element.setAttribute("name", getName());

	Element contactsElement = new Element("contacts");
	element.addContent(contactsElement);

	for (Contact c : getContactSet()) {
	    contactsElement.addContent(c.exportToXML());
	}

	return element;
    }

    public void importFromXML(Element personElement) {
	setName(personElement.getAttribute("name").getValue());
	Element contacts = personElement.getChild("contacts");
	
	for (Element contactElement : contacts.getChildren("contact")) {
	    Contact c = new Contact();
	    c.importFromXML(contactElement);
	    addContact(c);
	}

    }

    private Contact getContactByName(String name) {
	for(Contact contact : getContactSet()) {
	    if(contact.getName().equals(name)) {
		return contact;
	    }
	}
	return null;
    }
    
    public boolean hasContact(String contactName) {
	return getContactByName(contactName) != null;
    }
    
    @Override
    public void addContact(Contact contactToBeAdded) throws NameAlreadyExistsException {
    	if (hasContact(contactToBeAdded.getName()))
    		throw new NameAlreadyExistsException(contactToBeAdded.getName());
	
    	super.addContact(contactToBeAdded);
    }
    
    public void removeContact(String contactName) throws ContactDoesNotExistException {
    	Contact toRemove = getContactByName(contactName);
    	if (toRemove == null)
	    throw new ContactDoesNotExistException(contactName);
	
    	super.removeContact(toRemove);
    }

    public List<Contact> searchContact(String token) {
    	List<Contact> matchingContacts = new ArrayList<Contact>();

    	for(Contact existingContact : this.getContactSet()) {
    		if(existingContact.getName().contains(token)) {
    			matchingContacts.add(existingContact);
    		}
    	}

    	return matchingContacts;
    }
}
