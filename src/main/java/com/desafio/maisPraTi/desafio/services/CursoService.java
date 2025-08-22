package com.desafio.maisPraTi.desafio.services;

import com.desafio.maisPraTi.desafio.model.entities.Curso;
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

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso insert(Curso obj) {
        return cursoRepository.save(obj);
    }

    public Curso update(Long id, Curso obj){
        Curso entidade = cursoRepository.getReferenceById(id);
        updateDate(entidade, obj);
        return cursoRepository.save(entidade);
    }

    private void updateDate(Curso entidade, Curso obj){
        entidade.setId(obj.getId());
        entidade.setNome(obj.getNome());
        entidade.setDataDeConclusao(obj.getDataDeConclusao());
    }
}
