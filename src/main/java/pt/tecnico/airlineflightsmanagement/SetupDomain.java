package pt.tecnico.airlineflightsmanagement;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

import pt.ist.fenixframework.Config;

import pt.tecnico.airlineflightsmanagement.domain.AirlineFlightsManagement;
import pt.tecnico.airlineflightsmanagement.domain.Number;
import pt.tecnico.airlineflightsmanagement.domain.Airport;

public class SetupDomain {

    @Atomic
    public static void main(String[] args) {
	populateDomain();
    }
    
    static void populateDomain() {
	AirlineFlightsManagement ap = AirlineFlightsManagement.getInstance();

	Airport airport = new Airport("Porto");
 	pb.addAirport(airport);
	airport.addNumber(new Number("06:50", 1951));
	Number c = new Number("21:55", 1988);
	c.setAirport(airport);

	try {
	    c = new Number("06:50", 1951);
	    c.setAirport(airport);
	    System.out.println("Error! Business rule violated!");
	} catch (pt.tecnico.airlineflightsmanagement.exception.NameAlreadyExistsException nae) {
	    System.out.println("Could not add two equals numbers to the same airport");
	}
    }
}
