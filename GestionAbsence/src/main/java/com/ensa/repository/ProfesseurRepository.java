package com.ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entity.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
	
	
}
