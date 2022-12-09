package com.store.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class AddressInput {

    @Schema(example = "65060-700")
    @NotBlank
    private String cep;

    @Schema(example = "Rua das Margaridas")
    @NotBlank
    private String street;

    @Schema(example = "Número 101")
    @NotBlank
    private String number;

    @Schema(example = "Condomínio Milano, bloco 5, apartamento 304")
    @NotBlank
    private String complement;

    @Schema(example = "Bairro Cohab")
    @NotBlank
    private String neighborhood;

    @Schema(example = "João Pessoa")
    @NotBlank
    private String city;

    @Schema(example = "Paraiba")
    @NotBlank
    private String state;

}
