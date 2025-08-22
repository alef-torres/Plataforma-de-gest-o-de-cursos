package com.desafio.maisPraTi.desafio.model.entities.valueobject;

import java.time.LocalDate;

public class DataNascimento {

    private LocalDate data;

    public DataNascimento(LocalDate data) {
        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento não pode ser maior que a data atual.");
        }
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

}
