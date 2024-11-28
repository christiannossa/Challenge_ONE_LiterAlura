package com.aluracursos.literalurachallenge.principal;

import com.aluracursos.literalurachallenge.model.*;
import com.aluracursos.literalurachallenge.repository.AutorRepository;
import com.aluracursos.literalurachallenge.repository.LibroRepository;
import com.aluracursos.literalurachallenge.service.AutorService;
import com.aluracursos.literalurachallenge.service.ConsumoAPI;
import com.aluracursos.literalurachallenge.service.ConvierteDatos;
import com.aluracursos.literalurachallenge.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component

public class Principal {

    private final Scanner teclado = new Scanner(System.in);

    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final LibroRepository repositorioLibro;
    private final AutorRepository repositorioAutor;
    private List<Libro> libros;

    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;

    //Constructo del repositorioLibro
    @Autowired
    public Principal(LibroRepository repositorioLibro, AutorRepository repositorioAutor) {
        this.repositorioLibro = repositorioLibro;
        this.repositorioAutor = repositorioAutor;
    }


    public void muestraElMenu() {

        var opcion = -1;

        while (opcion != 0) {

            var menu = """
                    
                    *****************************************************
                    
                    Por favor elija una de las siguientes opciones:
                    
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    
                    0 - Salir
                    
                    *****************************************************
                    
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresResgistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("\nGracias por utilizar nuestro sistema\n\nCerrando la aplicación...\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpción inválida.");

            }

        }

    }


    private DatosLibro getDatosLibro() {

        System.out.println("\nPor favor a continuación ingrese el nombre del libro que desea buscar: \n");

        var tituloLibro = teclado.nextLine();

        if (tituloLibro == null || tituloLibro.trim().isEmpty()) {

            System.out.println("\n\nEl título del libro no puede estar vacío.\n");
            getDatosLibro();

        }

        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();


        if (libroBuscado.isPresent()) {

            DatosLibro libro = libroBuscado.get();

            //Se imprimen los datos del libro
            System.out.println("\n\nLibro encontrado: ");
            System.out.println("\nTítulo: " + libro.titulo() + ".");

            //Se extrae e imprimen los datos del autor
            if (libro.autor() != null) {
                System.out.println("\nAutor: " + libro.autor().get(0).nombre() + ".\n\n");
            } else {
                System.out.println("\n\nNo, se encontraron datos del autor.\n");
            }

            return libro;

        } else {

            System.out.println("\n\nEl libro no pudo ser encontrado.\n");

            muestraElMenu();

        }

        return null;
    }


    private void buscarLibro() {

        DatosLibro datosLibro = getDatosLibro();

        if (datosLibro != null) {

            Optional<Libro> libroExistente = repositorioLibro.findByTitulo(datosLibro.titulo());

            if (libroExistente.isEmpty()) {

                if (datosLibro.autor() != null && !datosLibro.autor().isEmpty()) {

                    Autor autor = repositorioAutor.findByNombre(datosLibro.autor().get(0).nombre())
                            .orElseGet(() -> {
                                Autor nuevoAutor = new Autor(datosLibro.autor().get(0));
                                return repositorioAutor.save(nuevoAutor);  //Se guarda si no existe
                            });

                    //Se crear el libro con el autor
                    Libro libro = new Libro(datosLibro);
                    libro.setAutor(autor);  // Vincular el autor al libro

                    //Se guarda el libro
                    repositorioLibro.save(libro);
                    System.out.println("\n\nLibro y autor guardados exitosamente.\n");
                    String idiomas = String.join(", ", datosLibro.idiomas());
                    System.out.println("""
                            
                            ----- LIBRO -----
                            Título: """ + " " + datosLibro.titulo() + """
                            \nAutor: """ + " " + autor.getNombre() + """
                            \nIdioma: """ + " " + idiomas + """
                            \nNúmero de descargas: """ + " " + datosLibro.numeroDeDescargas() + """
                            \n-----------------
                            """);

                } else {

                    //Si no hay autor, solo se guarda el libro sin autor
                    Libro libro = new Libro(datosLibro);
                    repositorioLibro.save(libro);
                    System.out.println("\n\nLibro '" + libro + "' guardado sin autor.\n");

                }

            } else {

                System.out.println("\n\nEl libro '" + datosLibro.titulo() + "' no se puede registrar porque ya se encuentra guardado y no es posible guardar el mismo libro más de una vez.\n");

                muestraElMenu();

            }

        } else {

            System.out.println("\n\nNo, se pudo guardar el libro porque no se encontró información válida.\n");

        }

    }


    private void listarLibrosRegistrados() {

        //Se obtiene la llamada al repositorioLibro desde el servicio
        List<Libro> libros = libroService.listarTodosLosLibros();

        if (libros.isEmpty()) {

            System.out.println("\n\nNo, se encontraron libros registrados en la base de datos.\n");

        } else {

            System.out.println("\n\n----- BÚSQUEDA DE LIBROS -----\n");

            for (Libro libro : libros) {

                System.out.println("""
                            
                            ----- LIBRO -----
                            Título: """ + " " + libro.getTitulo() + """
                            \nAutor: """ + " " + libro.getAutor().getNombre() + """
                            \nIdioma: """ + " " + String.join(", ", libro.getIdiomas()) + """
                            \nNúmero de descargas: """ + " " + libro.getNumeroDeDescargas() + """
                            \n-----------------
                            """);

            }

        }

    }


    private void listarAutoresResgistrados() {

        //Se obtiene la llamada al repositorioLibro desde el servicio
        List<Autor> autores = autorService.listarTodosLosAutores();

        if (autores.isEmpty()) {

            System.out.println("\n\nNo, se encontraron autores registrados en la base de datos.\n");

        } else {

            System.out.println("\n\n----- BÚSQUEDA DE AUTORES -----\n");

            for (Autor autor : autores) {

                //Se verifica si el autor tiene libros registrados
                String libros = autor.getLibros().isEmpty()
                        ? "El autor no tiene libros registrados"
                        : autor.getLibros().stream()
                                .map(Libro::getTitulo)//Se obtienen los títulos de los libros
                                        .reduce((a, b) -> a + ", " + b)//Se concatena con comas
                                                .orElse("");

                System.out.println("""
                            
                            ----- AUTOR -----
                            Autor: """ + " " + autor.getNombre() + """
                            \nFecha de Nacimiento: """ + " " + autor.getFechaDeNacimiento() + """
                            \nFecha de Fallecimiento: """ + " " +
                            (autor.getFechaDeFallecimiento() != null ? autor.getFechaDeFallecimiento() : "N/A") + """
                            \nLibros: """ + " " + libros + """
                            \n-----------------
                            """);

            }

        }

    }


    private void listarAutoresVivos() {

        //Se solicita el año al usuario
        System.out.println("\nPor favor ingrese el año en el que desea buscar el (los) autor (es) vivos: \n");
        int year = teclado.nextInt();

        //Llamar al servicio para consultar la lista de autores vivos en el año consultado
        List<Autor> autoresVivos = autorService.listarAutoresVivosEnYear(year);

        //Se verifica si la lista contiene elementos
        if (autoresVivos.isEmpty()) {

            System.out.println("\n\nNo, se encontraron en los registros autores vivos en el año " + year + ".\n");

        } else {

            System.out.println("\n\n----- AUTORES VIVOS EN EL AÑO " + year + " -----\n");

            //Se itera sobre la lista y se imprime la información de cada autor
            for (Autor autor : autoresVivos) {

                //Verifica si el autor tiene libros registrados
                String libros = autor.getLibros().isEmpty()
                        ? "\n\nEl autor no tiene libros registrados.\n"
                        : autor.getLibros().stream()
                        .map(Libro::getTitulo)//Se obtienen los títulos de los libros
                        .reduce((a, b) -> a + ", " + b)//Se concatena con comas
                        .orElse("");

                System.out.println("""
                            
                            ----- AUTOR -----
                            Autor: """ + " " + autor.getNombre() + """
                            \nFecha de Nacimiento: """ + " " + autor.getFechaDeNacimiento() + """
                            \nFecha de Fallecimiento: """ + " " +
                            (autor.getFechaDeFallecimiento() != null ? autor.getFechaDeFallecimiento() : "N/A") + """
                            \nLibros: """ + " " + libros + """
                            \n-----------------
                            """);

            }

        }

    }


    private void listarLibrosPorIdioma() {

        //Se solicota el idioma para realizar la consulta
        System.out.println("""
                \nPor favor ingrese el idioma para buscar los libros:
                
                es - Español
                en - Inglés
                fr - Francés
                pt - Portugués
                zh - Chino
                
                """);
        String idiomas = teclado.next();

        //Llamar al servicio para consultar la lista de libros por idioma
        List<Libro> librosPorIdioma = libroService.obtenerLibrosPorIdioma(idiomas);


        if (librosPorIdioma.isEmpty()) {

            System.out.println("\n\nNo, se encontraron en los registros libros con el idioma " + idiomas + ".\n");

        } else {

            System.out.println("\n\n----- BÚSQUEDA DE LIBROS CON EL IDIOMA " + idiomas.toUpperCase() + " -----\n");

            for (Libro libro : librosPorIdioma) {

                System.out.println("""
                            
                            ----- LIBRO -----
                            Título: """ + " " + libro.getTitulo() + """
                            \nAutor: """ + " " + libro.getAutor().getNombre() + """
                            \nIdioma: """ + " " + String.join(", ", libro.getIdiomas()) + """
                            \nNúmero de descargas: """ + " " + libro.getNumeroDeDescargas() + """
                            \n-----------------
                            """);

            }

        }


    }


}
