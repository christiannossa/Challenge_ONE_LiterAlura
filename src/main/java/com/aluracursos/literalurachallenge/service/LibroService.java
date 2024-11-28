package com.aluracursos.literalurachallenge.service;

import com.aluracursos.literalurachallenge.model.Libro;
import com.aluracursos.literalurachallenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional

//Reglas de negocio
public class LibroService {

    @Autowired
    private LibroRepository repositoryLibro;


    @Transactional(readOnly = true)
    public List<Libro> listarTodosLosLibros() {
        return repositoryLibro.findAllWithAutor();
    }

    public List<Libro> obtenerLibrosPorIdioma(String idiomas) {

        return repositoryLibro.findByIdiomas(idiomas);

    }

}
