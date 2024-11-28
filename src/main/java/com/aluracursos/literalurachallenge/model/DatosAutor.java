package com.aluracursos.literalurachallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonFormat(pattern = "yyyy")

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutor(

        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer fechaDeNacimiento,
        @JsonAlias("death_year") Integer fechaDeFallecimiento

) {

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Integer fechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    @Override
    public Integer fechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }
}
