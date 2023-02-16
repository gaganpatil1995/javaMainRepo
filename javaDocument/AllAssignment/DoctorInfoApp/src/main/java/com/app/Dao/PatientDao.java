package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Patient;

public interface PatientDao extends JpaRepository<Patient, Integer> {

}
