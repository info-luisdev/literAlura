package com.project.LiterAlura.models;

import java.util.List;

public class Libro {

    private String titulo;

    private List<Autor> autor;

    private String idioma;

    private int numeroDeDescarga;

    public Libro(DatosLibro datosLibro) {
       
            this.titulo = datosLibro.titulo();
            this.idioma = datosLibro.idioma().get(0);
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

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        autor.forEach(a -> a.setLibro(this));
        this.autor = autor;
    }



    @Override
    public String toString() {
        return "------ LIBRO ------\n"  +
               "  Titulo: " + titulo + "\n" +
               "  Autor: " + autor + "\n" +
               "  Idioma: " +  idioma +  "\n" + 
               "  Numero de descargas: " + numeroDeDescarga + "\n" +
               "------------------";
    }

}
