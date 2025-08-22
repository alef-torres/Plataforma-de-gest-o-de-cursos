package com.desafio.maisPraTi.desafio.resources;

import com.desafio.maisPraTi.desafio.entities.Aluno;
import com.desafio.maisPraTi.desafio.entities.Curso;
import com.desafio.maisPraTi.desafio.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno obj){
        obj = alunoService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
        obj = alunoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    // Adicionar curso ao aluno (recebendo Curso diretamente)
    @PostMapping("/{alunoId}/cursos")
    public ResponseEntity<Aluno> adicionarCurso(@PathVariable Long alunoId,
                                                @RequestBody Curso curso) {
        Aluno aluno = alunoService.adicionarCurso(alunoId, curso.getId());
        return ResponseEntity.ok(aluno);
    }

    // Remover curso do aluno
    @DeleteMapping("/{alunoId}/cursos")
    public ResponseEntity<Aluno> removerCurso(@PathVariable Long alunoId,
                                              @RequestBody Curso curso) {
        Aluno aluno = alunoService.removerCurso(alunoId, curso.getId());
        return ResponseEntity.ok(aluno);
    }
}
