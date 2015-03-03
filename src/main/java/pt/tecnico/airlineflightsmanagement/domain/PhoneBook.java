package pt.tecnico.airlineflightsmanagement.domain;

import pt.ist.fenixframework.FenixFramework;

import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.List;

import pt.tecnico.airlineflightsmanagement.exception.PersonDoesNotExistException;
import pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException;

/**
 * This class implements the Singleton design pattern.
 **/

public class AirlineFlightsManagement extends AirlineFlightsManagement_Base {
    
    public static AirlineFlightsManagement getInstance() {
	AirlineFlightsManagement pb = FenixFramework.getDomainRoot().getAirlineflightsmanagement();
	if (pb == null)
	    pb = new AirlineFlightsManagement();

	return pb;
    }


    private AirlineFlightsManagement() {
	FenixFramework.getDomainRoot().setAirlineflightsmanagement(this);
    }
    
    public Element exportToXML() {
	Element element = new Element("phonebbok");

	Element peopleElement = new Element("people");
	element.addContent(peopleElement);

	for (Person person : getPersonSet()) {
	    peopleElement.addContent(person.exportToXML());
	}

	return element;
    }

    public void importFromXML(Element airlineflightsmanagementElement) {
	Element people = airlineflightsmanagementElement.getChild("people");
	
	for (Element person : people.getChildren("person")) {
	    Person p = new Person();
	    p.importFromXML(person);
	    addPerson(p);
	}
    }

    private Person getPersonByName(String name) {
	for(Person person : getPersonSet()) {
	    if(person.getName().equals(name)) {
		return person;
	    }
	}
	return null;
    }
    
    public boolean hasPerson(String personName) {
	return getPersonByName(personName) != null;
    }
    
    @Override
    public void addPerson(Person personToBeAdded) throws NameAlreadyExistsException {
	if (hasPerson(personToBeAdded.getName()))
	    throw new NameAlreadyExistsException(personToBeAdded.getName());
	
	super.addPerson(personToBeAdded);
    }
    
    public void removePerson(String personName) throws PersonDoesNotExistException {
    	Person toRemove = getPersonByName(personName);
    	if (toRemove == null)
	    throw new PersonDoesNotExistException(personName);
	
    	removePerson(toRemove);
    }

    public List<Person> searchPerson(String token) {
	List<Person> matchingPersons = new ArrayList<Person>();

	for(Person existingPerson : this.getPersonSet()) {
	    if(existingPerson.getName().contains(token)) {
		matchingPersons.add(existingPerson);
	    }
	}

	return matchingPersons;
    }
}
