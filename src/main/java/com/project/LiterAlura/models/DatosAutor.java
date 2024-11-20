package com.project.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
                @JsonAlias("name") String nombreAutor,
                @JsonAlias("birth_year") int fechaNacimiento,
                @JsonAlias("death_year") int fechaFallecimiento
) {

}
