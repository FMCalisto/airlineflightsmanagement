package pt.tecnico.airlineflightsmanagement;

import java.util.Set;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.TransactionManager;

import pt.tecnico.airlineflightsmanagement.domain.AirlineFlightsManagement;
import pt.tecnico.airlineflightsmanagement.domain.Contact;
import pt.tecnico.airlineflightsmanagement.domain.Person;

import javax.transaction.*;

public class AirlineFlightsManagementApplication {

    public static void main(String[] args) {
   	System.out.println("Welcome to the Airline Flights Management application!");

	TransactionManager tm = FenixFramework.getTransactionManager();
    	boolean committed = false;

   	try {
	    tm.begin();

	    AirlineFlightsManagement pb = AirlineFlightsManagement.getInstance();
	    populateDomain(pb);

	    for (Airport airport : pb.getAirportSet()) {
		System.out.println("The Number information of " + airport.getNumber() + " :");
		for(Number n : airport.getNumberSet()) {
		    System.out.println("\t Airport: " + n.getAirport() + " phone: " + n.getAirportNumber());
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
	AirlineFlightsManagement ap = AirlineFlightsManagement.getInstance();

	ap.importFromXML(jdomDoc.getRootElement());
    }

    static void populateDomain(AirlineFlightsManagement ap) {
	if (!ap.getAirportSet().isEmpty())
	    return;

	// setup the initial state if airlineflightsmanagement is empty

	Airport airport = new Airport("Porto");
 	ap.addAirport(airport);
	airport.addNumber(new Number("06:50", 1951));
	Number n = new Number("21:55", 1988);
	n.setAirport(airport);

	airport.addNumber(new Number("14:20", 0651));
    }
	
    @Atomic
    public static org.jdom2.Document convertToXML() {
	AirlineFlightsManagement ap = AirlineFlightsManagement.getInstance();
	
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

    // removes the first person of the AirlineFlightsManagement application.
    @Atomic
    static void removeAllAirport() {
	AirlineFlightsManagement ap = AirlineFlightsManagement.getInstance();

	for (Airport a : ap.getAirportSet()) {
	    a.delete();
	}
    }
}
