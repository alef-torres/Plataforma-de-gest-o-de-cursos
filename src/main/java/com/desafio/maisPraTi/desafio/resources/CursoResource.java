package com.desafio.maisPraTi.desafio.resources;

import com.desafio.maisPraTi.desafio.entities.Curso;
import com.desafio.maisPraTi.desafio.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> lista = cursoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        Curso obj = cursoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
