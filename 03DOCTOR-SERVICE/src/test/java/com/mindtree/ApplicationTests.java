package com.mindtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.mindtree.entity.Doctor;
import com.mindtree.service.DoctorServiceImpl;
import com.mindtree.repo.IDoctorRepo;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {ApplicationTests.class})
class ApplicationTests {

	@Mock
	IDoctorRepo IDoctorRepo;
	
	@InjectMocks
	DoctorServiceImpl doctorServiceImpl;
	
	List<Doctor> docList;
	
	@Test
	@Order(1)
	public void testGetAllDoctors() {
		
		docList = new ArrayList<>();
		docList.add(new Doctor(1,"Ram",28,"male","Heart",0));
		docList.add(new Doctor(2,"Priya",26,"female","Brain",0));
		
		when(IDoctorRepo.findAll()).thenReturn(docList);
		
		assertEquals(2,doctorServiceImpl.fetchAllDoctors().size() );	
	}
	
	
	
	@Test
	@Order(2)
	public void testAddDoctor() {
		

		Doctor sgleDoc=new Doctor(1,"Ram",28,"male","Heart",0);
		
        when(IDoctorRepo.save(sgleDoc)).thenReturn(sgleDoc);
		
		assertEquals(sgleDoc,doctorServiceImpl.addDoctor(sgleDoc));
	}
	
	@Test
	@Order(3)
	public void testGetDoctorById() {
		
		docList = new ArrayList<>();
		docList.add(new Doctor(1,"Ram",28,"male","Heart",0));
		docList.add(new Doctor(2,"Priya",26,"female","Brain",0));
		
		int doctorid=2; 
		
		when(IDoctorRepo.findAll()).thenReturn(docList);
		
		assertEquals(2,doctorServiceImpl.fetchADoctor(doctorid).getId() );	
	}
	
	@Test
	@Order(4)
	public void testGetDoctorsNames() {
		
		docList = new ArrayList<>();
		docList.add(new Doctor(1,"Ram",28,"male","Heart",0));
		docList.add(new Doctor(2,"Priya",26,"female","Brain",0));
		
       when(IDoctorRepo.findAll()).thenReturn(docList);
		
		assertEquals("Ram",doctorServiceImpl.getDocName().get(0));
	}

}
