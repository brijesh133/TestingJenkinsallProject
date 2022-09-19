package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Patient;

public interface IPatientService {

	public Patient fetchAPatient(int patId);

	public List<Patient> fetchAllPatients();

	public Patient addPatient(Patient pat);

}
