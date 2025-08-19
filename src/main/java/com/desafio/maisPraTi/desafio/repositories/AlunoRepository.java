package com.desafio.maisPraTi.desafio.repositories;

import com.desafio.maisPraTi.desafio.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
