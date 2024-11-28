package com.aluracursos.literalurachallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name = "libros")

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;
    private String idiomas;
    private Double numeroDeDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    //Constructor predeterminado
    public Libro(){}

    //Constructor personalizado
    public Libro(DatosLibro datosLibros) {

        this.titulo = datosLibros.titulo();
        //this.autor = datosLibros.autor().toString();
        this.idiomas = String.join(", ", datosLibros.idiomas());
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();

        if (datosLibros.autor() != null && !datosLibros.autor().isEmpty()) {

            this.autor = new Autor(datosLibros.autor().get(0));

        }

    }

    @Override
    public String toString() {

        return
                "titulo = '" + titulo + '\'' +
                ", autor = '" + (autor != null ? autor.getNombre() : "Desconocido") + '\'' +
                ", idiomas = '" + idiomas + '\'' +
                ", numeroDeDescargas = '" + numeroDeDescargas + '\'';

    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
