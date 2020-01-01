package com.ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

}
