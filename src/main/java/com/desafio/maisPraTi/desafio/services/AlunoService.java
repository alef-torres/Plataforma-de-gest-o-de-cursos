package com.desafio.maisPraTi.desafio.services;

import com.desafio.maisPraTi.desafio.model.entities.Aluno;
import com.desafio.maisPraTi.desafio.model.entities.Curso;
import com.desafio.maisPraTi.desafio.repositories.AlunoRepository;
import com.desafio.maisPraTi.desafio.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private  AlunoRepository alunoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        Optional<Aluno> obj;
        obj = alunoRepository.findById(id);
        return obj.get();
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno insert(Aluno obj) {
        return alunoRepository.save(obj);
    }

    public Aluno update(Long id, Aluno obj) {
        Aluno entidade = alunoRepository.getReferenceById(id);
        updateData(entidade, obj);
        return alunoRepository.save(entidade);
    }

    private void updateData(Aluno entidade, Aluno obj) {
        entidade.setGenero(obj.getGenero());
        entidade.setEmail(obj.getEmail());
        entidade.setCep(obj.getCep());
        entidade.setPais(obj.getPais());
        entidade.setRua(obj.getRua());
        entidade.setBairro(obj.getBairro());
        entidade.setNumero(obj.getNumero());
        entidade.setComplemento(obj.getComplemento());
        entidade.setCidade(obj.getCidade());
        entidade.setEstado(obj.getEstado());
    }

    @Transactional
    public Aluno adicionarCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        aluno.getCursos().add(curso);
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno removerCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        aluno.getCursos().remove(curso);
        return alunoRepository.save(aluno);
    }
}
