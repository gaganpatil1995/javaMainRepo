package com.app.service;

import java.util.List;

import com.app.Entity.Doctor;
import com.app.Entity.Patient;
import com.app.exception.DoctorException;
import com.app.exception.PatientException;

public interface DoctorPatientService {

	public Doctor regesterDoctor(Doctor doc) throws DoctorException ;
	public String removeDoctor(Integer doctorId)throws DoctorException ;
	public Patient registerPatient(Patient patient);
	public String removePatient(Integer patientId)throws PatientException ;
	public List<Doctor> suggectionOfDoctor(Integer patientId)throws PatientException ;
}
