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


import appointmentService.AppointmentService;

//AppointmentServiceTest class containing all necessary tests of the AppointmentService class
class AppointmentServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	//clear the array list after each test to prevent spill over into subsequent tests
	@AfterEach
	void tearDown() throws Exception {
		AppointmentService.apptList.removeAll(AppointmentService.apptList);
	}

	//testAddAppt method to test creation and storage of appointments in the array list
	@Test
	final void testAddAppt() {
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//create AppointmentService object and use to pass test params to addAppt method
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDate, "The First Appointment");
		
		//Assertions to successful creation of appointment object and successful addition to the array list
		assertTrue(!(AppointmentService.apptList.isEmpty()));
		assertEquals(AppointmentService.apptList.get(0).getApptId(), "22505");
		assertEquals(AppointmentService.apptList.get(0).getDate(), testDate);
		assertEquals(AppointmentService.apptList.get(0).getApptDescription(), "The First Appointment");
			
	}
	
	//testAddMultipleAppts method to test creation and storage of multiple appointments in the array list
	@Test
	final void testAddMultipleAppts() {
		
		//declare valid testDate objects
		GregorianCalendar testDateOne = new GregorianCalendar(2022, Calendar.JUNE, 11);
		GregorianCalendar testDateTwo = new GregorianCalendar(2022, Calendar.MAY, 23);
		GregorianCalendar testDateThree = new GregorianCalendar(2022, Calendar.JULY, 15);
		
		//create new AppointmentService object and use to pass test params to addAppt, creating
		//3 test appointment objects and adding them to the array list
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDateOne, "The First Appointment");
		test.addAppt("230356", testDateTwo, "The Second Appointment");
		test.addAppt("298877", testDateThree, "The Third Appointment");
		
		//assign list size to a variable for comparison test
		//assert list size is equal to amount of test objects created
		final int listSize = AppointmentService.apptList.size();
		assertEquals(3, listSize);
		
		//Assertions validating params passed were assigned correctly to
		//created test objects upon creation and storage
		assertEquals(AppointmentService.apptList.get(0).getApptId(), "22505");
		assertEquals(AppointmentService.apptList.get(1).getApptId(), "230356");
		assertEquals(AppointmentService.apptList.get(2).getApptId(), "298877");
		
		assertEquals(AppointmentService.apptList.get(0).getDate(), testDateOne);
		assertEquals(AppointmentService.apptList.get(1).getDate(), testDateTwo);
		assertEquals(AppointmentService.apptList.get(2).getDate(), testDateThree);
		
		assertEquals(AppointmentService.apptList.get(0).getApptDescription(), "The First Appointment");
		assertEquals(AppointmentService.apptList.get(1).getApptDescription(), "The Second Appointment");
		assertEquals(AppointmentService.apptList.get(2).getApptDescription(), "The Third Appointment");
	}
		
	//duplicateIdTest to ensure passing a duplicate ID throws an exception 
	@Test
	final void duplicateIdTest() {
		
		//declare valid testDate objects
		GregorianCalendar testDateOne = new GregorianCalendar(2022, Calendar.JUNE, 11);
		GregorianCalendar testDateTwo = new GregorianCalendar(2022, Calendar.MAY, 17);
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDateOne, "The First Appointment");
		
		//Assert exception thrown if same ID is passed again
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.addAppt("22505", testDateTwo, "The Second Appointment");
		});
		
	}
	
	//tastDeleteAppt method to test removal of appointment objects from the array list
	@Test
	final void testDeleteAppt() {
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		String testApptId = "22505";
		
		test.addAppt(testApptId, testDate, "The First Appointment");
		
		//assert the list is not empty 
		assertTrue(!(AppointmentService.apptList.isEmpty()));
		
		//if array list is not empty, pass the test ID to deleteAppt method
		if(!(AppointmentService.apptList.isEmpty())) {
			test.deleteAppt(testApptId);
			
		}
		
		//assert the list is now empty
		assertTrue(AppointmentService.apptList.isEmpty());
	}
	
	//testValidUpdateDate method to test updating of specific appointment objects date attribute
	//with a valid replacement date
	@Test
	final void testValidUpdateDate() {
		
		//declare valid testDate object
		GregorianCalendar testDateOne = new GregorianCalendar(2022, Calendar.JUNE, 11);
		GregorianCalendar testDateTwo = new GregorianCalendar(2022, Calendar.JUNE, 18);
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDateOne, "The First Appointment");
		
		//pass created test appointments id and new date to updateDate method
		test.updateApptDate("22505", testDateTwo);
		
		//assert appointment's date is now equal to the passed replacement date
		assertEquals(AppointmentService.apptList.get(0).getDate(), testDateTwo);
	}
	
	//testInvalidUpdateDate method to test updating of specific appointment objects date attribute
	//with an invalid replacement date
	@Test
	final void testInvalidUpdateDate() {
			
		//declare valid testDate object
		GregorianCalendar testDateOne = new GregorianCalendar(2022, Calendar.JUNE, 11);
		GregorianCalendar testDateTwo = new GregorianCalendar(2019, Calendar.JUNE, 18);
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDateOne, "The First Appointment");
		
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including a date that is in the past
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateApptDate("22505", testDateTwo);
		});
	
	}
	
	//testInvalidUpdateDate method to test updating of specific appointment objects date attribute
	//with a null replacement date
	@Test
	final void testNullUpdateDate() {
			
		//declare valid date object and null date objects
		GregorianCalendar testDateOne = new GregorianCalendar(2022, Calendar.JUNE, 11);
		GregorianCalendar testDateTwo = null;
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDateOne, "The First Appointment");
		
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including a date that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateApptDate("22505", testDateTwo);
		});
	}
		
	//testUpdateApptDescription method to test updating of appointment's description
	@Test
	final void testUpdateApptDescription() {
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDate, "The First Appointment");
		
		//pass created test appointment's ID and new description to updateApptDescription method
		test.updateApptDescription("22505", "A new description");
		
		//assert test appointment's description is now the passed updated description
		assertEquals(AppointmentService.apptList.get(0).getApptDescription(), "A new description");
	}
	
	//testInvalidUpdateApptDescription method to test updating of appointment's description
	@Test
	final void testInvalidUpdateApptDescription() {
		
		//declare valid testDate object
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDate, "The First Appointment");
		
		
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including a description that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateApptDescription("22505", "A new descripTIONAOSNDOIANSOINCOINASODBFBJAKBSKJDBKJVBKJABS"
					+ "SADKJNFKNAOSIDNCOVINABISBDBFkbkjvbknzknxoicxnfoinAONSDONVOINOZINFODInonofndon");
			
		});
	}
	
	//testNullUpdateApptDescription method to test updating of appointment's description
	@Test
	final void testNullUpdateApptDescription() {
		
		//declare valid testDate object and null string
		GregorianCalendar testDate = new GregorianCalendar(2022, Calendar.JUNE, 11);
		String testDescription = null;
		
		//create new AppointmentService object and use to pass params to addAppt
		AppointmentService test = new AppointmentService();
		test.addAppt("22505", testDate, "The First Appointment");
		
		//assert an exception is thrown when Appointment(params) is passed these test params
		//including a date that is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.updateApptDescription("22505", testDescription);
		});
	}




}