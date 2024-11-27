# Challenge_ONE_LiterAlura
Challenge LiterAlura, realizado para el programa ONE de Oracle y AluraLATAM.

- Estado del proyecto: Finalizado con opción de actualización.
  # Se desarrolló una aplicación en el Framework Spring Boot para buscar datos de diferentes libros realizando la solicitud a la API de Gutendex y almacenarlos en una base de datos PostgreSQL, con la cual se pueden realizar diferentes consultas sobre los libros registrados.
  - En total, la aplicación está compuesta por los siguientes paquetes con las siguientes entidades:

    - model.
      - Autor.java.
      - Datos.java.
      - DatosAutor.java.
      - DatosLibro.java.
      - Libro.java.
    - principal.
      - Princiapl.java.
    - repository.
      - AutorRepository.java.
      - LibroRepository.java.
    - service.
      - AutorService.java.
      - ConsumoAPI.java.
      - ConvierteDatos.java.
      - IConvierteDatos.java.
      - LibroService.java.
      - LiteraluraChallengeApplication.java.

  ## Funcionalidades del proyecto.

- Paquete model.
  - Clase Autor:
    - `Funcionalidad 1`: Se crea la tabla para almacenar los datos de los autores.
    - `Funcionalidad 2`: Se mapea la llave foranea con la entidad 'Libro'.
    - `Funcionalidad 3`: Se crean los constructores sin argumentos, predeterminado y personalizado.
    - `Funcionalidad 4`: Se implementan los getters y setters.
  - Record Datos:
    - `Funcionalidad 1`: Se inyecta a travez de un record la lista principal para poder acceder a los datos de la API de Gutendex.
  - Record DatosAutor:
    - `Funcionalidad 1`: Se inyecta a travez de un record los datos de los autores.
    - `Funcionalidad 2`: Se sobreescriben los elementos.
  - Record DatosLibro:
    - `Funcionalidad 1`: Se inyecta a travez de un record los datos de los libros.
    - `Funcionalidad 2`: Se sobreescriben los elememntos.
  - Clase Libro:
    - `Funcionalidad 1`: Se crea la tabla para almacenar los datos de los libros.
    - `Funcionalidad 2`: Se mapea la llave foranea con la entidad 'Autor'.
    - `Funcionalidad 3`: Se crean el constructor predeterminado y personalizado.
    - `Funcionalidad 4`: Se implementan los getters y setters.
- Paquete principal.
  - Clase Principal:
    - `Funcionalidad 1`: Se inicializan las variables.
    - `Funcionalidad 2`: Se crea el constructor del repositorio.
    - `Funcionalidad 3`: Se crea el menú del proyecto.
    - `Funcionalidad 4`: Se crean los métodos para cada una de las opciones del menú.
- Paquete repository.
  - Interface AutorRepository:
    - `Funcionalidad 1`: Se conecta a JpaRepository.
    - `Funcionalidad 2`: Se realizan las consultas JPA y JPQL en la base de datos para Autor.
  - Interface LibroRepository:
    - `Funcionalidad 1`: Se conecta a JpaRepository.
    - `Funcionalidad 2`: Se realizan las consultas JPA y JPQL en la base de datos para Libro.
- Paquete service.
  - Clase AutorService:
    - `Funcionalidad 1`: Se inyecta el repsositorio para la clase Autor.
    - `Funcionalidad 2`: Se crean los métodos para acceder a las consultas del repositorio AutorRepository.
  - Clase ConsumoAPI:
    - `Funcionalidad 1`: Se crea el método para consumir la API.
  - Clase ConvierteDatos:
    - `Funcionalidad 1`: Se conecta a la interface IConvierteDatos.
    - `Funcionalidad 2`: Se sobreescribe el metodo obtenerDatos de la interface IConvierteDatos para realizar el mapeo de los datos en la API.
  - Interface IConvierteDatos:
    - `Funcionalidad 1`: Se crea el metodo obtenerDatos para realizar el mapeo de los datos en la API.
  - Clase LibroService:
    - `Funcionalidad 1`: Se inyecta el repsositorio para la clase Libro.
    - `Funcionalidad 2`: Se crean los métodos para acceder a las consultas del repositorio LibroRepository.
  - Clase LiteraluraChallengeApplication:
    - `Funcionalidad 1`: Clase principal de la aplicación para ejecutar el proyecto.
    - `Funcionalidad 2`: Se conecta a CommandLineRunner.
    - `Funcionalidad 3`: Se crea el método main.
    - `Funcionalidad 4`: Se inyecta la clase Principal para acceder al proyecto y ejecutar el método 'muestraElMenu'.
