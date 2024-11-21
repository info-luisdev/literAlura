package com.project.LiterAlura.start;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.LiterAlura.models.Autor;
import com.project.LiterAlura.models.Datos;
import com.project.LiterAlura.models.DatosLibro;
import com.project.LiterAlura.models.Libro;
import com.project.LiterAlura.repository.LibroRepository;
import com.project.LiterAlura.service.API;
import com.project.LiterAlura.service.AutorService;
import com.project.LiterAlura.service.LibroService;
import com.project.LiterAlura.service.ObtenerDatosAPI;

public class Principal {

    private API consumoAPI = new API();
    private Scanner entrada = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ObtenerDatosAPI conversor = new ObtenerDatosAPI();
    private AutorService autorService;
    private LibroService libroService;

    public Principal(AutorService autorService, LibroService libroService){
        this.autorService = autorService;
        this.libroService = libroService;
    }


    public void mostrarMenu(){

        int opcion = 1;
        while (opcion !=0) {
            String menu =    """
                            1 - Buscar Libro Por Titulo
                            2 - Listar Libros Registrados
                            3 - Listar Autores Registrados
                            4 - Listar Autores Vivos en un determinado año
                            5 - Listar Libros por Idioma
                            
                            0 - Salir
                            """;
            System.out.println(menu);
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;

                case 3:
                    listarAutoresRegistrados(); 
                    break;
                case 4: 
                    listarAutoresVivosPorPerido();
                    break;
                case 5: 
                    listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Has salido de la aplicacion");
                    break;
                default:
                    System.out.println("Opcion Invalida. Vuelve a intentar");
                    break;
            }

        }
    }
    public Datos getDatosLibro(){
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var nombrelibro = entrada.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombrelibro.replace(" ", "%20"));
        var dato = conversor.obtenerDatos(json, Datos.class);
        return dato;
    }

    private void buscarLibro(){
        var datos = getDatosLibro();
        
        DatosLibro primerLibro = datos.resultado().get(0);

        Autor autor = new Autor(primerLibro.autor().get(0));
        
        Autor autorExistente = autorService.guardarAutor(autor);

        Libro libro = new Libro(primerLibro, autorExistente);
        libroService.guardarLibro(libro);
        System.out.println(libro);

    }

    private void listarLibrosRegistrados(){

    }

    private void listarAutoresRegistrados(){

    }

    private void listarAutoresVivosPorPerido(){
        
    }

    private void  listarLibrosPorIdioma(){

    }

}
