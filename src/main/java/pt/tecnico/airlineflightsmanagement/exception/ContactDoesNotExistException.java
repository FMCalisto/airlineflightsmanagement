package pt.tecnico.airlineflightsmanagement.exception;

public class ContactDoesNotExistException extends AirlineFlightsManagementException {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private String contactName;

	public ContactDoesNotExistException(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactName() {
		return this.contactName;
	}
}
