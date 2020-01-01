package com.ensa.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.entity.Module;
import com.ensa.repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	
	public List<Module> getAllModules() {
		return moduleRepository.findAll();
	}

	public Module getModuleById(Long id) {
		return moduleRepository.getOne(id);
	}

	public Module addOrEditModule(@Valid Module e) {
		return moduleRepository.save(e);
	}

	public void deleteModuleById(Long id) {
		moduleRepository.deleteById(id);
	}

}
