package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Patient;
import com.mindtree.service.IPatientService;

@RestController()
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	IPatientService patService;
	
	@GetMapping("/getAllPatients")
	public ResponseEntity<?> getAllPatients(){
		List<Patient> patList = patService.fetchAllPatients();
		return new ResponseEntity<List<Patient>>(patList,HttpStatus.OK);
	}
	
	@GetMapping("/getPatient/{id}")
	public ResponseEntity<?> getAPatient(@PathVariable("id") int patId){
		
		try {
		Patient pat = patService.fetchAPatient(patId);
		return new ResponseEntity<Patient>(pat,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	@PostMapping("/add")
	public ResponseEntity<?> addPatient(@RequestBody Patient pat){
		Patient savedPat = patService.addPatient(pat);
		return new ResponseEntity<Patient>(savedPat,HttpStatus.CREATED);
	}
	
}
