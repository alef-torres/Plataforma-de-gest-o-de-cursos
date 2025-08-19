package com.desafio.maisPraTi.desafio.configH2;

import com.desafio.maisPraTi.desafio.entities.Aluno;
import com.desafio.maisPraTi.desafio.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void run(String... args) throws Exception {

        Aluno a1 = new Aluno(
                "SP", "São Paulo", "Apto 101", "123", "Centro", "Rua das Flores",
                "Brasil", "01001-000", "joao.silva@email.com", "Masculino",
                "123.456.789-00", "2000-05-15", "Silva", "João", null
        );

        Aluno a2 = new Aluno(
                "RJ", "Rio de Janeiro", "Casa 2", "456", "Copacabana", "Av. Atlântica",
                "Brasil", "22010-000", "maria.souza@email.com", "Feminino",
                "987.654.321-00", "1998-08-22", "Souza", "Maria", null
        );

        Aluno a3 = new Aluno(
                "MG", "Belo Horizonte", "Bloco B", "789", "Savassi", "Rua da Liberdade",
                "Brasil", "30140-000", "carlos.oliveira@email.com", "Masculino",
                "111.222.333-44", "1995-12-03", "Oliveira", "Carlos", null
        );

        Aluno a4 = new Aluno(
                "RS", "Porto Alegre", "Fundos", "321", "Cidade Baixa", "Rua dos Andradas",
                "Brasil", "90020-000", "ana.costa@email.com", "Feminino",
                "555.666.777-88", "2001-03-30", "Costa", "Ana", null
        );

        Aluno a5 = new Aluno(
                "BA", "Salvador", "Cobertura", "654", "Pelourinho", "Rua do Carmo",
                "Brasil", "40026-000", "lucas.pereira@email.com", "Masculino",
                "999.888.777-66", "1999-11-10", "Pereira", "Lucas", null
        );

        alunoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5));


    }
}
