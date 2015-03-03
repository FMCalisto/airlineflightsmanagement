package pt.tecnico.phonebook;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

import pt.ist.fenixframework.Config;

import pt.tecnico.phonebook.domain.PhoneBook;
import pt.tecnico.phonebook.domain.Contact;
import pt.tecnico.phonebook.domain.Person;

public class SetupDomain {

    @Atomic
    public static void main(String[] args) {
	populateDomain();
    }
    
    static void populateDomain() {
	PhoneBook pb = PhoneBook.getInstance();

	Person person = new Person("Manel");
 	pb.addPerson(person);
	person.addContact(new Contact("SOS", 112));
	Contact c = new Contact("IST", 214315112);
	c.setPerson(person);

	try {
	    c = new Contact("IST", 214315112);
	    c.setPerson(person);
	    System.out.println("Error! Business rule violated!");
	} catch (pt.tecnico.phonebook.exception.NameAlreadyExistsException nae) {
	    System.out.println("Could not add two equals contacts to the same person");
	}
    }
}
