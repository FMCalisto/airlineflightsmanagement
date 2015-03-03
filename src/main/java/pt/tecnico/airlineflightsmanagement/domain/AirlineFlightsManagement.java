package pt.tecnico.airlineflightsmanagement.domain;

import pt.ist.fenixframework.FenixFramework;

import org.jdom2.Content;
import org.jdom2.Content.CType;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.List;

import pt.tecnico.airlineflightsmanagement.exception.AirportDoesNotExistException;
import pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException;

/**
 * This class implements the Singleton design pattern.
 **/

public class AirlineFlightsManagement extends AirlineFlightsManagement_Base {
    
    public static AirlineFlightsManagement getInstance() {
	AirlineFlightsManagement ap = FenixFramework.getDomainRoot().getAirlineflightsmanagement();
	if (ap == null)
	    ap = new AirlineFlightsManagement();

	return ap;
    }


    private AirlineFlightsManagement() {
	FenixFramework.getDomainRoot().setAirlineflightsmanagement(this);
    }
    
    public Element exportToXML() {
	Element element = new Element("airlineflightsmanagement");

	Element airportElement = new Element("airport");
	element.addContent(airportElement);

	for (Airport airport : getAirportSet()) {
	    airportElement.addContent(airport.exportToXML());
	}

	return element;
    }

    public void importFromXML(Element airlineflightsmanagementElement) {
	Element airport = airlineflightsmanagementElement.getChild("airport");
	
	for (Element airport : airport.getChildren("airport")) {
	    Airport a = new Airport();
	    a.importFromXML(airport);
	    addAirport(p);
	}
    }

    private Airport getAirportByName(String name) {
	for(Airport airport : getAirportSet()) {
	    if(airport.getName().equals(name)) {
		return airport;
	    }
	}
	return null;
    }
    
    public boolean hasAirport(String airportName) {
	return getAirportByName(airportName) != null;
    }
    
    @Override
    public void addAirport(Airport airportToBeAdded) throws NameAlreadyExistsException {
	if (hasAirport(airportToBeAdded.getName()))
	    throw new NameAlreadyExistsException(airportToBeAdded.getName());
	
	super.addAirport(airportToBeAdded);
    }
    
    public void removeAirport(String airportName) throws AirportDoesNotExistException {
    	Airport toRemove = getAirportByName(airportName);
    	if (toRemove == null)
	    throw new AirportDoesNotExistException(airportName);
	
    	removeAirport(toRemove);
    }

    public List<Airport> searchAirport(String token) {
	List<Airport> matchingAirports = new ArrayList<Airport>();

	for(Airport existingAirport : this.getAirportSet()) {
	    if(existingAirport.getName().contains(token)) {
		matchingAirports.add(existingAirport);
	    }
	}

	return matchingAirports;
    }
}
