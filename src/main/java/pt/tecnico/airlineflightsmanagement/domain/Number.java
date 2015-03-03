package pt.tecnico.airlineflightsmanagement.domain;

import pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException;
import pt.tecnico.airlineflightsmanagement.exception.ImportDocumentException;

import org.jdom2.Element;
import org.jdom2.DataConversionException;

public class Number extends Number_Base {
    
    public Number(String name, Integer airportNumber) {
        setName(name);
        setPhoneNumber(airportNumber);
    }

    Number() {
    }

    public void importFromXML(Element numberElement) {
	setName(numberElement.getAttribute("name").getValue());
	try {
	    setAiportNumber(numberElement.getAttribute("airportNumber").getIntValue());
	} catch (DataConversionException e) { 
	    throw new ImportDocumentException();
	}
    }

    public Element exportToXML() {
	Element element = new Element("number");
	element.setAttribute("name", getName());
	element.setAttribute("airportNumber", Integer.toString(getAirportNumber()));
	
	return element;
    }

    @Override
    public void setAirport(Airport airport) throws NameAlreadyExistsException {
	if (airport == null) {
	    super.setAirport(null);
	    return;
	}

	airport.addNumber(this);
    }

    public void delete() {
	setAirport(null);
	deleteDomainObject();
    }
}
