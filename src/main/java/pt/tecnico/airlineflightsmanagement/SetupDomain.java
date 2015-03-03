package pt.tecnico.airlineflightsmanagement;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

import pt.ist.fenixframework.Config;

import pt.tecnico.airlineflightsmanagement.domain.AirlineFlightsManagement;
import pt.tecnico.airlineflightsmanagement.domain.Contact;
import pt.tecnico.airlineflightsmanagement.domain.Person;

public class SetupDomain {

    @Atomic
    public static void main(String[] args) {
	populateDomain();
    }
    
    static void populateDomain() {
	AirlineFlightsManagement pb = AirlineFlightsManagement.getInstance();

	Person person = new Person("Manel");
 	pb.addPerson(person);
	person.addContact(new Contact("SOS", 112));
	Contact c = new Contact("IST", 214315112);
	c.setPerson(person);

	try {
	    c = new Contact("IST", 214315112);
	    c.setPerson(person);
	    System.out.println("Error! Business rule violated!");
	} catch (pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException nae) {
	    System.out.println("Could not add two equals contacts to the same person");
	}
    }
}
