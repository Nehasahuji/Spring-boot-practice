package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

	public Passport findByPerson_id(long id);
}
