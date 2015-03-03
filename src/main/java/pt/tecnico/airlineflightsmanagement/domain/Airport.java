package pt.tecnico.airlineflightsmanagement.domain;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

import pt.tecnico.airlineflightsmanagement.exception.NumberDoesNotExistException;
import pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException;

public class Airport extends Airport_Base {
    
    public Airport(String name) {
        super();
	setName(name);
    }    	      
    
    Airport() {
    }    	      

    public void delete() {
	for (Number n : getNumberSet())
	    n.delete();

	setAirlineFlightsManagement(null);
	deleteDomainObject();
    }

    public Element exportToXML() {
	Element element = new Element("airport");

	element.setAttribute("name", getName());

	Element numbersElement = new Element("numbers");
	element.addContent(numbersElement);

	for (Number n : getNumberSet()) {
	    numbersElement.addContent(n.exportToXML());
	}

	return element;
    }

    public void importFromXML(Element airportElement) {
	setName(airportElement.getAttribute("name").getValue());
	Element numbers = airportElement.getChild("numbers");
	
	for (Element numberElement : numbers.getChildren("number")) {
	    Number c = new Number();
	    c.importFromXML(numberElement);
	    addNumber(c);
	}

    }

    private Number getNumberByName(String name) {
	for(Number number : getNumberSet()) {
	    if(number.getName().equals(name)) {
		return number;
	    }
	}
	return null;
    }
    
    public boolean hasNumber(String numberName) {
	return getNumberByName(numberName) != null;
    }
    
    @Override
    public void addNumber(Number numberToBeAdded) throws NameAlreadyExistsException {
    	if (hasNumber(numberToBeAdded.getName()))
    		throw new NameAlreadyExistsException(numberToBeAdded.getName());
	
    	super.addNumber(numberToBeAdded);
    }
    
    public void removeNumber(String numberName) throws NumberDoesNotExistException {
    	Number toRemove = getNumberByName(numberName);
    	if (toRemove == null)
	    throw new NumberDoesNotExistException(numberName);
	
    	super.removeNumber(toRemove);
    }

    public List<Number> searchNumber(String token) {
    	List<Number> matchingNumbers = new ArrayList<Number>();

    	for(Number existingNumber : this.getNumberSet()) {
    		if(existingNumber.getName().contains(token)) {
    			matchingNumbers.add(existingNumber);
    		}
    	}

    	return matchingNumbers;
    }
}
