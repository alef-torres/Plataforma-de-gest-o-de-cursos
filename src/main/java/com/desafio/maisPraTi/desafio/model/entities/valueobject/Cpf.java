package com.desafio.maisPraTi.desafio.model.entities.valueobject;

public class Cpf {
    private String numero;

    public Cpf(String numero) {
        numero.replaceAll("[^0-9]", "");
        if (isValido(numero)){
            this.numero = numero;
        }
    }

    public String getNumero() {
        return numero;
    }

    private boolean isValido(String numero) {
        if (numero.length() != 11) return false;

        if (numero.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0;
            int resto;

            for (int i = 1; i <= 9; i++) {
                soma += Integer.parseInt(numero.substring(i - 1, i)) * (11 - i);
            }
            resto = (soma * 10) % 11;
            if ((resto == 10) || (resto == 11)) resto = 0;
            if (resto != Integer.parseInt(numero.substring(9, 10))) return false;

            soma = 0;
            for (int i = 1; i <= 10; i++) {
                soma += Integer.parseInt(numero.substring(i - 1, i)) * (12 - i);
            }
            resto = (soma * 10) % 11;
            if ((resto == 10) || (resto == 11)) resto = 0;
            if (resto != Integer.parseInt(numero.substring(10, 11))) return false;

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}