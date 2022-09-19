//DoctorController.java
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

import com.mindtree.entity.Doctor;
import com.mindtree.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	IDoctorService docService;
	
	@GetMapping("/getAllDoctors")
	public ResponseEntity<?> getAllDoctors(){
		List<Doctor> docList = docService.fetchAllDoctors();
		return new ResponseEntity<List<Doctor>>(docList,HttpStatus.OK);
	}
	
	@GetMapping("/getDoctor/{id}")
	public ResponseEntity<?> getADoctor(@PathVariable("id") int docId){
		
		try {
		Doctor doc = docService.fetchADoctor(docId);
		return new ResponseEntity<Doctor>(doc,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addDoctor(@RequestBody Doctor doc){
		Doctor savedDoc = docService.addDoctor(doc);
		return new ResponseEntity<Doctor>(savedDoc,HttpStatus.CREATED);
	}
	
	@GetMapping("update/count/{name}/{count}")
	public void setDocPatientCount(@PathVariable("name") String name, @PathVariable("count") int count){
		docService.setDocPatientCount(name,count);
	}
	
	@GetMapping("GetDocName")
	public ResponseEntity<?> getDocName(){
		List<String> docName = docService.getDocName();
		return new ResponseEntity<List<String>>(docName,HttpStatus.OK);
	}
	
}
