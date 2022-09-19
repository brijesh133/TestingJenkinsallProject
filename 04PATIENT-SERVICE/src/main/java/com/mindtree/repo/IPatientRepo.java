package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Integer> {

}
