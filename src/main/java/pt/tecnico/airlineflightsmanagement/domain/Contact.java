package pt.tecnico.airlineflightsmanagement.domain;

import pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException;
import pt.tecnico.airlineflightsmanagement.exception.ImportDocumentException;

import org.jdom2.Element;
import org.jdom2.DataConversionException;

public class Contact extends Contact_Base {
    
    public Contact(String name, Integer phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    Contact() {
    }

    public void importFromXML(Element contactElement) {
	setName(contactElement.getAttribute("name").getValue());
	try {
	    setPhoneNumber(contactElement.getAttribute("phoneNumber").getIntValue());
	} catch (DataConversionException e) { 
	    throw new ImportDocumentException();
	}
    }

    public Element exportToXML() {
	Element element = new Element("contact");
	element.setAttribute("name", getName());
	element.setAttribute("phoneNumber", Integer.toString(getPhoneNumber()));
	
	return element;
    }

    @Override
    public void setPerson(Person person) throws NameAlreadyExistsException {
	if (person == null) {
	    super.setPerson(null);
	    return;
	}

	person.addContact(this);
    }

    public void delete() {
	setPerson(null);
	deleteDomainObject();
    }
}
