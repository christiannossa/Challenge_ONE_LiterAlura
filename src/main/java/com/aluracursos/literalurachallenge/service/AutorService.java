package com.aluracursos.literalurachallenge.service;
import com.aluracursos.literalurachallenge.model.Autor;
import com.aluracursos.literalurachallenge.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class AutorService {

    @Autowired
    private AutorRepository repositoryAutor;


    @Transactional(readOnly = true)
    public List<Autor> listarTodosLosAutores() {

        return repositoryAutor.findAllByLibrosIsNotNull();

    }

    public List<Autor> listarAutoresVivosEnYear(int year) {

        return repositoryAutor.findAutoresVivosEnYear(year);

    }


}
