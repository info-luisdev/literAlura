package com.project.LiterAlura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LiterAlura.models.Autor;
import com.project.LiterAlura.repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor guardarAutor(Autor autor){

        Optional<Autor> autorExistente = repository.findByNombreAutor(autor.getNombreAutor());

        if (autorExistente.isPresent()) {
            return autorExistente.get();
        }
        else {
            return repository.save(autor);
        }
    }

    public void mostrarAutores(){
        
        List<Autor> autoresRegistrados = repository.findAll();

        autoresRegistrados.forEach(System.out::println);
    }

    public void autoresVivosPorPeriodos(Integer añoLimite){

        List<Autor> autoresVivos = repository.autoresVivosPorPeriodo(añoLimite);

        if (autoresVivos.isEmpty()) {
            System.out.println("No se encontraron autores vivos en esa fecha");
        }
        else {
            autoresVivos.forEach(System.out::println);
        }
    }

}
