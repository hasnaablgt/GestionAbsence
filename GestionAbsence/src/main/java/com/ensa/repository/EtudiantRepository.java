package com.ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	Etudiant findByUsername(String username);
	
}
