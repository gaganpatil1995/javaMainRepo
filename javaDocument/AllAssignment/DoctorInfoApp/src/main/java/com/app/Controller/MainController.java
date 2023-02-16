package com.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Doctor;
import com.app.Entity.Patient;
import com.app.exception.DoctorException;
import com.app.exception.PatientException;
import com.app.service.DoctorPatientService;

@RestController
public class MainController {

	@Autowired
	DoctorPatientService dpService ;
	
	@PostMapping("/saveDoc")
	public ResponseEntity<Doctor> addDoctorDetail(@Valid @RequestBody Doctor doc)throws DoctorException{
		
		Doctor doc1 = dpService.regesterDoctor(doc);
		
		return new ResponseEntity<>(doc1, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delDoc/{docId}")
	public ResponseEntity<String> removeDoctorById(@PathVariable("docId") Integer docId ) throws DoctorException{
		String doc1 = dpService.removeDoctor(docId);
		
		return new ResponseEntity<>(doc1 , HttpStatus.OK);
	}
	
	@PostMapping("/savePat")
	public ResponseEntity<Patient> addPatientDetail(@Valid @RequestBody Patient patient){
		Patient pat1 = dpService.registerPatient(patient);
		return new ResponseEntity<>(pat1,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delPat/{patId}")
	public ResponseEntity<String> removePatientById(@PathVariable("patId")Integer patId) throws PatientException{
		String res = dpService.removePatient(patId);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/sugges/{patId}")
	public ResponseEntity<List<Doctor>> getSuggestionOfDoctor(@PathVariable("patId") Integer patId) throws PatientException{
		List<Doctor> doctors = dpService.suggectionOfDoctor(patId);
		
		return new ResponseEntity<>(doctors ,HttpStatus.FOUND);
	}
	
}
