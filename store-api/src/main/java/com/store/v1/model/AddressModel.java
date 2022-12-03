package com.store.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "addresses")
@Getter
@Setter
public class AddressModel extends RepresentationModel<AddressModel> {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "65060-700")
    private String cep;

    @Schema(example = "Rua das Margaridas")
    private String street;

    @Schema(example = "Número 101")
    private String number;

    @Schema(example = "Condomínio Milano, bloco 5, apartamento 304")
    private String complement;

    @Schema(example = "Bairro Cohab")
    private String neighborhood;

    @Schema(example = "João Pessoa")
    private String city;

    @Schema(example = "Paraiba")
    private String state;

}
