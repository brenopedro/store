package com.store.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    INVALID_DATA("Invalid data"),
    ACESSO_NEGADO("Acesso negado"),
    ERRO_DE_SISTEMA("Erro de sistema"),
    PARAMETRO_INVALIDO("Parâmetro inválido"),
    INCOMPREHENSIBLE_MESSAGE("Incomprehensible message"),
    RECURSO_NAO_ENCONTRADO("Recurso não encontrado"),
    ENTIDADE_EM_USO("Entidade em uso"),
    ERRO_NEGOCIO("Violação de regra de negócio");

    private String title;
    ProblemType(String title) {
        this.title = title;
    }
}
