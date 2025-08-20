package com.desafio.maisPraTi.desafio.services;

import com.desafio.maisPraTi.desafio.entities.Curso;
import com.desafio.maisPraTi.desafio.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        Optional<Curso> obj;
        obj = cursoRepository.findById(id);
        return obj.get();
    }
}
