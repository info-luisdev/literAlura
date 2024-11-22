package com.project.LiterAlura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LiterAlura.models.Libro;
import com.project.LiterAlura.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public void guardarLibro(Libro libro){
        
        Optional<Libro> libroExistente = libroRepository.findById(libro.getId());

        if (libroExistente.isPresent()) {
            System.out.println("El libro " + libro.getTitulo() + " ya esta registrado");
        }
        else {
            libroRepository.save(libro);
        }
    }

    public void mostrarLibros(){
        
       List<Libro> libro = libroRepository.findAll();

        libro.forEach(System.out::println);
        
    }

    public Libro mostrarLibrosPorIdioma(String idioma){
        
        Optional<Libro> librosPorIdioma = libroRepository.mostrarLibrosPorIdioma(idioma);

        if (librosPorIdioma.isPresent()) {
            return librosPorIdioma.get();
        }
        else {
            return null;
        }
    }

}
