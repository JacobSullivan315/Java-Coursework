package appointmentServiceTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

//AppointmentTest class containing all necessary tests for the Appointment class
class AppointmentTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//testAppt method to test functional constructor in Appointment class
	@Test
	final void testAppt() {
			
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		//create Appointment object and pass it test parameters
		Appointment testAppt = new Appointment("14513", testDate, "Test Appointment");
			
		//assert passed test params were properly stored in a new appointment object
		assertTrue(testAppt.getApptId().equals("14513"));
		assertTrue(testAppt.getDate().equals(testDate));
		assertTrue(testAppt.getApptDescription().equals("Test Appointment"));
			
	}
	
	//testApptIdTooLong method to test handling of an ID greater in length than
	//the specified requirements
	@Test
	final void testApptIdTooLong() {
		
		//declaration of test parameters
		String testId = "1029748981638274918273098309273109327";
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		String testDescription = "Regular Check Up";
			
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including an ID that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testId, testDate, testDescription);
		});
	}
		
	//testNullApptId method to test handling of null ID parameter
	@Test
	final void testNullApptId() {
		
		//declare id as null
		String testId = null;
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//assert an exception is thrown when this value is passed to the Appointment constructor
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testId, testDate, "Test Apppointment");
		});
	}
	
	//testPastApptDate method to test handling of a date that is in the past
	@Test
	final void testPastApptDate() {
		
		//declare invalid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2019, Calendar.JUNE, 11);
		
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including a date that is in the past
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("22505", testDate, 
					"Regular Check Up");
		});
	}
	
	//testNullApptDate method to test handling of null date parameter
	@Test
	final void testNullApptDate() {
		
		//declare null date object and assert an exception is thrown when
		//this object is passed to the Appointment constructor
		GregorianCalendar testDate = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("22505", testDate, "Regular Check Up");
		});
	}
	
	//testApptDescriptionTooLong method to test handling of a description greater in length than
	//the specified requirement
	@Test
	final void testApptDescriptionTooLong() {
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including a description that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("22505", testDate, "Regular Check Upaowidnlkanslkdnlknewfknalkwendflknsdlfknawklenflk"
					+ "wkenfaknsdlkfnaliwbeofinlkasnclvknkandofivboiBOQWIBDONSAOFN");
		});
	}
	
	//testNullApptDescription method to test handling of null description parameter
	@Test
	final void testNullApptDescription() {
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//declare description as null and assert an exception is thrown when
		//this value is passed to the Appointment constructor
		String testDescription = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("22505", testDate, testDescription);
		});
	}

}
