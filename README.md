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
  - Autor:
    - `Funcionalidad 1`: Se crea la tabla para almacenar los datos de los autores.
    - `Funcionalidad 2`: Se mapea la llave foranea con la entidad 'Libro'.
    - `Funcionalidad 3`: Se crean los constructores sin argumentos, predeterminado y personalizado.
    - `Funcionalidad 4`: Se implementan los getters y setters.
  - Datos:
    - `Funcionalidad 1`: Se inyecta a travez de un record la lista principal para poder acceder a los datos de la API de Gutendex.
  - DatosAutor:
    - `Funcionalidad 1`: Se inyecta a travez de un record los datos de los autores.
    - `Funcionalidad 2`: Se sobreescriben los datos.
  - DatosLibro:
    - `Funcionalidad 1`: Se 
    - `Funcionalidad 2`: 
    - `Funcionalidad 3`: 
    - `Funcionalidad 4`: 


- Clase Conversor.
  - `Funcinalidad 1`: Se encontrará el método de conversión a peso Argentino.
  - `Funcionalidad 2`: Se encontrará el método de conversión a dólar Americano.
  - `Funcionalidad 3`: Se encontrará el método de conversión a real Brasileño. 
  - `Funcinalidad 4`: Se encontrará el método de conversión a peso Colombiano.
- Clase ConsultaConversion.
  - `Funcionalidad 1`: Se encuentra al inicio un switch case para obtener la opción para seleccionar el tipo de moneda por el que se desea realizar la consulta.
  - `Funcionalidad 2`: Se encuentra el código de la URI para realizar la consulta a la API.
  - `Funcionalidad 3`: Se encuentra el cliente y la solicitud HttpRequest.
  - `Funcionalidad 4`: Al final se encuentra el try catch de comprobación.
