package pt.tecnico.airlineflightsmanagement.exception;

public class NameAlreadyExistsException extends AirlineFlightsManagementException {

	private static final long serialVersionUID = 1L;

	private String conflictingName;
	
	public NameAlreadyExistsException(String conflictingName) {
		this.conflictingName = conflictingName;
	}
	
	public String getConflictingName() {
		return this.conflictingName;
	}
	
}
