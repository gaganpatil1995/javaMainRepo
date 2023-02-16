package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Entity.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {
    
	
	public List<Doctor> findByCityAndSpeciality(String city , String speciality);
	
//	@Query("from Doctor d where d.city =: city And d.speciality =:speciality")
//	public List<Doctor> getDoctorByCityAndSpeciality(@Param("city") String city ,@Param("speciality") String speciality);
//	
//	@Query("from Doctor d where d.city =? 1 And d.speciality =?2")
//	public List<Doctor> get2DoctorByCityAndSpeciality(String city ,String speciality);
}
