package com.desafio.maisPraTi.desafio.resources;

import com.desafio.maisPraTi.desafio.entities.Curso;
import com.desafio.maisPraTi.desafio.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Long id){
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso obj){
        obj = cursoService.update(id,obj);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Curso> insert(@RequestBody Curso obj){
        obj = cursoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
