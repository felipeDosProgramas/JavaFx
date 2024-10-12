package com.ale.alessandro;

public record Cliente(
    String nome,
    int idade,
    boolean sexo_masculino
) {
    @Override
    public String toString() {
        return "nome: " + nome +
               " idade: " + idade +
               " sexo:" + (sexo_masculino ? "masculino" : "feminino");
    }
}
