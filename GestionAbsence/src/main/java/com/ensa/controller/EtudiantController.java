package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entity.Etudiant;
import com.ensa.entity.User;
import com.ensa.service.EtudiantService;
import com.ensa.service.UserService;

@RestController
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEtudiants() {
		return etudiantService.getAllEtudiants();
	}
	
	@GetMapping("/etudiants/{id}")
	public Etudiant getEtudiantById(@PathVariable("id") Long id) {
		Etudiant e =  etudiantService.getEtudiantById(id);
		return e;
	}
	
	@PostMapping("/etudiants/add")
	public Etudiant addOrEditEtudiant(@Valid @RequestBody Etudiant e) {
		e.setPassword(passwordEncoder.encode(e.getPassword()));
		User u = e.toUser();
		userService.saveOrUpdateUser(u);
		return etudiantService.addOrEditEtudiant(e);
	}
	
	@DeleteMapping("/etudiants/delete/{id}")
	public void deleteEtudiantById(@PathVariable("id") Long id) {
		//userService.deleteUserById(etudiantService.g);
		etudiantService.deleteEtudiantById(id);
	}
	
}
