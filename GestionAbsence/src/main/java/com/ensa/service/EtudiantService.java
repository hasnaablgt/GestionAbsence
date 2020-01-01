package com.ensa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entity.Etudiant;
import com.ensa.repository.EtudiantRepository;

@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	public Etudiant getEtudiantById(Long id) {
		return etudiantRepository.getOne(id);
	}
	
	public Etudiant addOrEditEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}
	
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
	}

	

	
	
}
