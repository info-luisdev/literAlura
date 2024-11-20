package com.project.LiterAlura.models;


public class Autor {

    private String nombreAutor;

    private int fechaNacimiento;

    private int fechaFallecimiento;

    private Libro libro;

    public Autor(DatosAutor datosAutor) {

        this.nombreAutor = datosAutor.nombreAutor();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaFallecimiento = datosAutor.fechaFallecimiento();
        
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(int fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
     
        return "Autor: " + nombreAutor + "\n" +
               "Fecha de nacimiento: " + fechaNacimiento + "\n" +
               "Fecha de fallecimiento: " + fechaFallecimiento + "\n" + 
               "Libros: " + libro ;
    }

}
