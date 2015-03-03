package pt.tecnico.airlineflightsmanagement.exception;

public class AirportDoesNotExistException extends AirlineFlightsManagementException {

	/**
	 */
	private static final long serialVersionUID = 1L;

	private String AirportNumber;

	public AirportDoesNotExistException(String AirportNumber) {
		this.AirportNumber = AirportNumber;
	}
	
	public String getAirportNumber() {
		return this.AirportNumber;
	}
}
