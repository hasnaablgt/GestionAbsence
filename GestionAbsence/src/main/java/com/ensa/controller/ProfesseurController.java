package com.ensa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.ensa.entity.Professeur;
import com.ensa.entity.User;
import com.ensa.service.ProfesseurService;
import com.ensa.service.UserService;

@RestController
public class ProfesseurController {

	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/professeurs")
	public List<Professeur> getAllProfesseurs() {
		return professeurService.getAllprofesseurs();
	}
	
	@PostMapping("/professeurs/add")
	public Professeur addOrEditProfesseur(@Valid @RequestBody Professeur prof) {
		prof.setPassword(passwordEncoder.encode(prof.getPassword()));
		User u = prof.toUser();
		userService.saveOrUpdateUser(u);
		return professeurService.addOrEditProfesseur(prof);
	}
	
	@GetMapping("/professeurs/{Id}")
	public Professeur getProfesseurById(@PathVariable("Id") Long id) {
		return professeurService.getProfesseurById(id);
	}
	
	@DeleteMapping("/professeurs/delete/{Id}")
	public void deleteProfesseur(@PathVariable("Id") Long id) {
		Professeur p = professeurService.getProfesseurById(id);
		User u = userService.getUserByUsername(p.getUsername());
		userService.deleteUser(u.getId());
		professeurService.deleteProfesseurById(id);
	}	
}
