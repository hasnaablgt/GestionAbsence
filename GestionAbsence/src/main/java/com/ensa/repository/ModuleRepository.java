package com.ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}
