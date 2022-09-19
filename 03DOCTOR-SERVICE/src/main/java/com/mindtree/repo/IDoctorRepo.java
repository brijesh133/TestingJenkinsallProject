//IDoctorRepo.java
package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	public Doctor findByName(String name);

}
