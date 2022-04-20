package appointmentService;


import java.util.GregorianCalendar;

/* Appointment class to handle creation of Appointment objects
 * @Param String apptId - unique string ID of each appointment
 * @Param GregorianCalendar - date object assigned to each Appointment object
 * @Param String apptDescription - description of appointment object
 */
public class Appointment {
	
	private String apptId;
	private GregorianCalendar date;
	private String apptDescription;
	
	//Appointment(params) constructor
	public Appointment(String apptId, GregorianCalendar date, String apptDescription) {
		
		//if statement validating passed ID meets desired requirements
		if (apptId == null || apptId.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment Id");
		}
		
		//if date is null or in the past, throw exception
		GregorianCalendar currentDate = new GregorianCalendar();
		if(date == null || -1 == date.compareTo(currentDate)) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		//if statement validating passed description meets desired requirements
		if (apptDescription == null || apptDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		//assign validated values to a new appointent object
		this.apptId = apptId;
		this.date = date;
		this.apptDescription = apptDescription;
	}


	//Getters and Setters for each applicable attribute of an appointment object
	//Setters are only defined for updateable attributes and also contain validation of passed data
	public String getApptId() {
		return apptId;
	}

	public GregorianCalendar getDate() {
		return date;
	}


	public void setDate(GregorianCalendar date) {
		
		GregorianCalendar currentDate = new GregorianCalendar();
		
		if(date == null || -1 == date.compareTo(currentDate)) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		this.date = date;
	}


	public String getApptDescription() {
		return apptDescription;
	}


	public void setApptDescription(String apptDescription) {
		
		if (apptDescription == null || apptDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		this.apptDescription = apptDescription;
		
	}
	

}