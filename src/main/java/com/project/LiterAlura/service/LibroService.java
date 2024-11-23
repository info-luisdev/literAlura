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
            System.out.println("El libro " + libro.getTitulo() + " ya esta registrado. \nNo se puede registrar el mismo libro mas de una vez.");
        }
        else {
            libroRepository.save(libro);
            System.out.println(libro);
        }
    }

    public void mostrarLibros(){
        
       List<Libro> libro = libroRepository.findAll();

        libro.forEach(System.out::println);
        
    }

    public void mostrarLibrosPorIdioma(String idioma){
        
        List<Libro> librosPorIdioma = libroRepository.mostrarLibrosPorIdioma(idioma);

        if (librosPorIdioma.isEmpty()) {
            System.out.println("No se encontraron libros con ese idioma");
        }
        else {
            librosPorIdioma.forEach(System.out::println);
        }
    }

}
