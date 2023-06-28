package com.threeschool.javacourse.springdatajpa.repository;

import com.threeschool.javacourse.springdatajpa.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Long> {
}
