package com.cedrodoce.maqfacil.entities;

import javax.validation.constraints.NotNull;

public record MaquinarioDTO(
        @NotNull
        String marca,
        @NotNull
        String modelo
) {
}
