# Challenge_ONE_LiterAlura
Challenge LiterAlura, realizado para el programa ONE de Oracle y AluraLATAM.

- Estado del proyecto: Finalizado con opción de actualización.
  # Se desarrolló una aplicación en el framework Spring Boot para buscar datos de diferentes libros realizando la solicitud a la API de Gutendex y almacenarlos en una base de datos PostgreSQL, con la cual se pueden realizar diferentes consultas sobre los libros registrados.
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

- Clase Principal.
  - `Funcionalidad 1`: Se encuentra el método de captura de información.
  - `Funcionalidad 2`: En el main se podrá encontrar el objeto teclado para recibir la información.
  - `Funcionalidad 3`: Se podrá encontrar el menú del conversor con los diferentes casos de las opciones de conversión.
  - `Funcionalidad 4`: Al final se encontrará el try catch de comprobación.
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
