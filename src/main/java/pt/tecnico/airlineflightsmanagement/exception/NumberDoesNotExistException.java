package pt.tecnico.airlineflightsmanagement.exception;

public class NumberDoesNotExistException extends AirlineFlightsManagementException {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private String stringNumber;

	public NumberDoesNotExistException(String stringNumber) {
		this.stringNumber = stringNumber;
	}
	
	public String getNumber() {
		return this.stringNumber;
	}
}
