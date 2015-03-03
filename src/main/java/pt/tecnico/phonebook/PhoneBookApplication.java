package pt.tecnico.phonebook;

import java.util.Set;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.TransactionManager;

import pt.tecnico.phonebook.domain.PhoneBook;
import pt.tecnico.phonebook.domain.Contact;
import pt.tecnico.phonebook.domain.Person;

import javax.transaction.*;

public class PhoneBookApplication {

    public static void main(String[] args) {
   	System.out.println("Welcome to the PhoneBook application!");

	TransactionManager tm = FenixFramework.getTransactionManager();
    	boolean committed = false;

   	try {
	    tm.begin();

	    PhoneBook pb = PhoneBook.getInstance();
	    populateDomain(pb);

	    for (Person person : pb.getPersonSet()) {
		System.out.println("The Contact book of " + person.getName() + " :");
		for(Contact contact : person.getContactSet()) {
		    System.out.println("\t Name: " + contact.getName() + " phone: " + contact.getPhoneNumber());
		}
	    }
	    tm.commit();
	    committed = true;
	}catch (SystemException| NotSupportedException | RollbackException| HeuristicMixedException | HeuristicRollbackException ex) {
	    System.err.println("Error in execution of transaction: " + ex);
	} finally {
	    if (!committed) 
		try {
		    tm.rollback();
		} catch (SystemException ex) {
		    System.err.println("Error in roll back of transaction: " + ex);
		}
    	}

	org.jdom2.Document doc = convertToXML();

	printDomainInXML(doc);

	removeAllPeople();

	org.jdom2.Document doc2 = convertToXML();

	printDomainInXML(doc2);

	recoverFromBackup(doc);

	doc2 = convertToXML();

	printDomainInXML(doc2);

    }

    @Atomic
    private static void recoverFromBackup(org.jdom2.Document jdomDoc) {
	PhoneBook pb = PhoneBook.getInstance();

	pb.importFromXML(jdomDoc.getRootElement());
    }

    static void populateDomain(PhoneBook pb) {
	if (!pb.getPersonSet().isEmpty())
	    return;

	// setup the initial state if phonebook is empty

	Person person = new Person("Manel");
 	pb.addPerson(person);
	person.addContact(new Contact("SOS", 112));
	Contact c = new Contact("IST", 214315112);
	c.setPerson(person);

	person = new Person("Maria");
 	pb.addPerson(person);
	person.addContact(new Contact("SOS", 112));
	c = new Contact("IST", 214315112);
	c.setPerson(person);

	person.addContact(new Contact("Manel", 333333333));
    }
	
    @Atomic
    public static org.jdom2.Document convertToXML() {
	PhoneBook pb = PhoneBook.getInstance();
	
	org.jdom2.Document jdomDoc = new org.jdom2.Document();

	jdomDoc.setRootElement(pb.exportToXML());

	return jdomDoc;
    }

    @Atomic
    public static void printDomainInXML(org.jdom2.Document jdomDoc) {
	XMLOutputter xml = new XMLOutputter();
	xml.setFormat(Format.getPrettyFormat());
	System.out.println(xml.outputString(jdomDoc));
    }

    // removes the first person of the PhoneBook application.
    @Atomic
    static void removeAllPeople() {
	PhoneBook pb = PhoneBook.getInstance();

	for (Person p : pb.getPersonSet()) {
	    p.delete();
	}
    }
}
