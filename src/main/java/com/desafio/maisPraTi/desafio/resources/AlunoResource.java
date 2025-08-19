package com.desafio.maisPraTi.desafio.resources;

import com.desafio.maisPraTi.desafio.entities.Aluno;
import com.desafio.maisPraTi.desafio.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> lista = alunoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        Aluno obj = alunoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
