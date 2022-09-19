package com.mindtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mindtree.controller.PatientController;
import com.mindtree.entity.Patient;
import com.mindtree.service.IPatientService;
import com.mindtree.repo.*;
import com.mindtree.service.*;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes={ApplicationTests.class})
class ApplicationTests {
	
	@Mock
	IPatientRepo IPatientRepo;
	
	@InjectMocks
	PatientServiceImpl PatientServiceImpl;
	
	List<Patient> patList;
	
	Patient pat;
	
	
	@Test
	@Order(1)
	public void testGetAllPatients() {
		
		patList = new ArrayList<>();
		patList.add(new Patient(1,"ajay","Gagan", new Date(),"Lt"));
		patList.add(new Patient(2,"bhagya","Kumar", new Date(),"Lt"));
		
       when(IPatientRepo.findAll()).thenReturn(patList);
		
		assertEquals(2,PatientServiceImpl.fetchAllPatients().size() );	
	}
	
	@Test
	@Order(2)
	public void test_addPatient(){
		
		pat = new Patient(4,"Brijesh","Rithesh",new Date(),"Lt");
		
		when( IPatientRepo.save(pat)).thenReturn(pat);
		
		assertEquals(pat,PatientServiceImpl.addPatient(pat));	
		
		
	}
	
	@Test
	@Order(3)
	public void test_getallPatientbyId() {
		
		patList = new ArrayList<>();
		patList.add(new Patient(1,"ajay","Gagan", new Date(),"Lt"));
		patList.add(new Patient(2,"bhagya","Kumar", new Date(),"Lt"));
		
		int id = 2;
		
		 when(IPatientRepo.findAll()).thenReturn(patList);
		
		assertEquals(2,PatientServiceImpl.fetchAPatient(id).getId());
		 
	}

}
