package com.project.LiterAlura.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Autor autor;

    private String idioma;

    private int numeroDeDescarga;

    public Libro(DatosLibro datosLibro, Autor datosAutor) {
       
            this.titulo = datosLibro.titulo();
            this.idioma = datosLibro.idioma().get(0);
            this.autor = datosAutor;
            this.numeroDeDescarga = datosLibro.numeroDeDescarga();
    }

  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDeDescarga() {
        return numeroDeDescarga;
    }

    public void setNumeroDeDescarga(int numeroDeDescarga) {
        this.numeroDeDescarga = numeroDeDescarga;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }



    @Override
    public String toString() {
        return "------ LIBRO ------\n"  +
               "  Titulo: " + titulo + "\n" +
               "  Autor: " + autor.getNombreAutor() + "\n" +
               "  Idioma: " +  idioma +  "\n" + 
               "  Numero de descargas: " + numeroDeDescarga + "\n" +
               "------------------";
    }

}
