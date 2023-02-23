package com.masai.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.UserLoginSession;

@Repository
public interface UserLoginSessionDao extends JpaRepository<UserLoginSession, Integer> {

	public Optional<UserLoginSession> findByUuid(String key) ;
}
