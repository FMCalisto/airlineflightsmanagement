package pt.tecnico.airlineflightsmanagement.exception;

public class NumberAlreadyExistsException extends AirlineFlightsManagementException {

	private static final long serialVersionUID = 1L;

	private String conflictingNumber;
	
	public NumberAlreadyExistsException(String conflictingNumber) {
		this.conflictingNumber = conflictingNumber;
	}
	
	public String getConflictingNumber() {
		return this.conflictingNumber;
	}
	
}
