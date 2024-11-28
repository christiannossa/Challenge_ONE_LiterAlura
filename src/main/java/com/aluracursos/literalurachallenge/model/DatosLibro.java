package com.aluracursos.literalurachallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(

        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double numeroDeDescargas

        ) {

        @Override
        public String titulo() {
                return titulo;
        }

        @Override
        public List<DatosAutor> autor() {
                return autor;
        }

        @Override
        public List<String> idiomas() {
                return idiomas;
        }

        @Override
        public Double numeroDeDescargas() {
                return numeroDeDescargas;
        }
}
