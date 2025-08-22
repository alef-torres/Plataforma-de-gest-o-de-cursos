package com.desafio.maisPraTi.desafio.repositories;

import com.desafio.maisPraTi.desafio.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
