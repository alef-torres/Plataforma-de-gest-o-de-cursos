package com.desafio.maisPraTi.desafio.services;

import com.desafio.maisPraTi.desafio.entities.Aluno;
import com.desafio.maisPraTi.desafio.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

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

    public Aluno update(Long id, Aluno obj) {
        Aluno entidade = alunoRepository.getReferenceById(id);
        updateData(entidade, obj);
        return alunoRepository.save(entidade);
    }

    private void updateData(Aluno entidade, Aluno obj) {
        entidade.setId(obj.getId());
        entidade.setPrimeiroNome(obj.getPrimeiroNome());
        entidade.setUltimoNome(obj.getUltimoNome());
        entidade.setDataNascimento(obj.getDataNascimento());
        entidade.setCpf(obj.getCpf());
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
}
