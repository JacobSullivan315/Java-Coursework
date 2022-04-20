package appointmentService;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

//AppointmentService class to handle manipulation of application objects
//and the array list they are stored in
public class AppointmentService {
	
	//define an array list to hold appointment objects
	public static List<Appointment> apptList = new ArrayList<Appointment>();
	
	//addAppt method to pass desired values to appointment creator
	public void addAppt(String apptId, GregorianCalendar date, String apptDescription) {
		
		//if list is not empty, check existence in list of passed ID
		//handles prevention of duplicate ID's for multiple appointments
		if (!(apptList.isEmpty())) {
			for (Appointment a:apptList) {
				if (a.getApptId().equals(apptId)) {
					throw new IllegalArgumentException("Duplicate ID");
				}
			}
		}
		
		//create appointment and add it to the array list
		Appointment appt = new Appointment(apptId, date, apptDescription);
		apptList.add(appt);
	}
	
	//deleteAppt method to handle removal of existing appointment objects from the array list
	public void deleteAppt(String apptId) {
		
		//for block iterating through the array list and finding the matching ID for deletion
		for (int i = 0; i < apptList.size(); i++) {
			Appointment a = apptList.get(i);
			if (a.getApptId().equals(apptId)) {
				apptList.remove(i);
			}
		}
	}
	
	//updateApptDate method to handle updating appointment date in the event of rescheduling
	//iterates through array list and updates appointment with matching ID
	public void updateApptDate(String apptId, GregorianCalendar newDate) {
		
		for (int i = 0; i < apptList.size(); i++) {
			Appointment a = apptList.get(i);
			if (a.getApptId().equals(apptId)) {
				a.setDate(newDate);
			}
		}
	}
	
	//updateApptDescription method to handle updating of decsriptions in the same fashion
	public void updateApptDescription(String apptId, String newDescription) {
		
		for (int i = 0; i < apptList.size(); i++) {
			Appointment a = apptList.get(i);
			if (a.getApptId().equals(apptId)) {
				a.setApptDescription(newDescription);
			}
		}
	}

}
