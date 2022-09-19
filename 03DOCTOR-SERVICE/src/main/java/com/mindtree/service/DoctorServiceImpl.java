//DoctorServiceImpl.java
package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Exception.DoctorNotFoundException;
import com.mindtree.entity.Doctor;

import com.mindtree.repo.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorRepo IDoctorRepo;
	
	@Override
	public List<Doctor> fetchAllDoctors() {
		return IDoctorRepo.findAll();
	}

	@Override
	public Doctor fetchADoctor(int docId) {
		
		List<Doctor> doxtorList=IDoctorRepo.findAll();
		
		Doctor doc=null;
		
		for(Doctor doclst:doxtorList)
		{
			if(doclst.getId()==docId)
			{
				doc=doclst;
				return doc;
			}
			
		}
		
		throw new DoctorNotFoundException("No Doctor found with id : "+docId);
		
		
		
//    Optional<Doctor> d=IDoctorRepo.findById(docId);
//		
//		if(d.isPresent())
//		{
//			Doctor dr=d.get();
//			
//			return dr;
//		}
//		
//		throw new DoctorNotFoundException("No Doctor found with id : "+docId);
		
	}

	@Override
	public Doctor addDoctor(Doctor doc) {
		return IDoctorRepo.save(doc);
	}

	@Override
	public void setDocPatientCount(String name, int count) {
		// TODO Auto-generated method stub
		
		Doctor doc =  IDoctorRepo.findByName(name);
		
		if(doc!=null) {
			int pcount = doc.getPCount();  //ec = 2
			
			if(count>0) {
				pcount+=count; //ec=3
				doc.setPCount(pcount);
				IDoctorRepo.save(doc);
			}
		}
		
	}

	@Override
	public List<String> getDocName() {
		// TODO Auto-generated method stub
		List<Doctor> drList=IDoctorRepo.findAll();
		
		List<String> name=new ArrayList();
		
		for(Doctor dr:drList)
		{
			name.add(dr.getName());
		}
		
		return name;
		
		 
	}

}
