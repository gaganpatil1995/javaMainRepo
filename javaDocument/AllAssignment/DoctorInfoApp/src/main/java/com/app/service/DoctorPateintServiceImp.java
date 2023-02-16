package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Dao.DoctorDao;
import com.app.Dao.PatientDao;
import com.app.Entity.Doctor;
import com.app.Entity.Patient;
import com.app.exception.DoctorException;
import com.app.exception.PatientException;

@Repository
public class DoctorPateintServiceImp implements DoctorPatientService {

	@Autowired
	DoctorDao doctorDao ;
	@Autowired
	PatientDao patientDao ;
	
	@Override
	public Doctor regesterDoctor(Doctor doc)throws DoctorException {
		if(doc.getCity().equalsIgnoreCase("Delhi")||doc.getCity().equalsIgnoreCase("Noida")
				||doc.getCity().equalsIgnoreCase("Faridabad")) {
			return doctorDao.save(doc);
		}
		else {
		throw new DoctorException("Please Enter Valid City");
		}
		
		
	}
	@Override
	public String removeDoctor(Integer doctorId) throws DoctorException {
		Optional<Doctor> opt = doctorDao.findById(doctorId);
		if(opt.isEmpty()) {
			throw new DoctorException("Doctor is not present with given Id");
		}
		doctorDao.delete(opt.get());
		return " Doctor Data is succecfully delected " +" " +opt.get().toString();
	}

	

	@Override
	public List<Doctor> suggectionOfDoctor(Integer patientId) throws PatientException {
		
		Optional<Patient> opt = patientDao.findById(patientId);
		Patient patient = opt.get();
		String city = patient.getCity();
		List<Doctor> doctors ;
		
		
		if(city.equalsIgnoreCase("Delhi") ||city.equalsIgnoreCase("Noida")||city.equalsIgnoreCase("Faridabad")  ) {
			
			String sympton = patient.getSympton() ;
			if(sympton.equalsIgnoreCase("Arthritis")||sympton.equalsIgnoreCase("Backpain")||sympton.equalsIgnoreCase("Tissue injuries")) {
				 doctors = doctorDao.findByCityAndSpeciality(city,"Orthopedic" );
				return doctors ;
				
			}else if(sympton.equalsIgnoreCase("Dysmenorrhea")) {
				 doctors = doctorDao.findByCityAndSpeciality(city,"Gynecology" );
				
			}else if(sympton.equalsIgnoreCase("Skin infection")||sympton.equalsIgnoreCase("skin burn")) {
				doctors = doctorDao.findByCityAndSpeciality(city, "Dermatology");
			}
			else if(sympton.equalsIgnoreCase("Ear pain")){
				doctors = doctorDao.findByCityAndSpeciality(city, "ENT specialist");
			}
			else {
				throw new PatientException("Please Enter valid Symptom");
			}
			
			
		}else {
			throw new PatientException("We are still waiting to expand to your location");
		}
		return doctors;
	}



	@Override
	public Patient registerPatient(Patient patient) {
	return patientDao.save(patient);
		
	}



	



	@Override
	public String removePatient(Integer patientId) throws PatientException {
		Optional<Patient> opt = patientDao.findById(patientId);
		
		if(opt.isEmpty()) {
			throw new PatientException("Patient is not present");
		}
		patientDao.delete(opt.get());
		return "Patient Data is Succefully Deleted "+" " +opt.get().toString() ;
	}

}
