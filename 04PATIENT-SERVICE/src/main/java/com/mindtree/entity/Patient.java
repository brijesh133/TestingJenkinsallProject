package com.mindtree.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {
	@Id
	@SequenceGenerator(name="Patient_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "Patient_SEQ",strategy = GenerationType.AUTO)
	@Column(name = "Pat_ID")
	private int id;

	@Column(name="PNAME",length = 25,nullable = false)
	private String name;
	
	@Column(name="visDoc",length = 25,nullable = false)
	private String visitedDoc;
	
	@Column(name="Dvisit")
	private Date dtOfVisit;
	
	@Column(name="Pres",length = 150,nullable = false)
	private String Prescription;
	
	
}
