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
    - `Funcionalidad 2`: Se mapea la llave foránea con la entidad 'Libro'.
    - `Funcionalidad 3`: Se crean los constructores sin argumentos, predeterminado y personalizado.
    - `Funcionalidad 4`: Se implementan los getters y setters.
  - Record Datos:
    - `Funcionalidad 1`: Se inyecta a través de un record la lista principal para poder acceder a los datos de la API de Gutendex.
  - Record DatosAutor:
    - `Funcionalidad 1`: Se inyecta a través de un record los datos de los autores.
    - `Funcionalidad 2`: Se sobreescriben los elementos.
  - Record DatosLibro:
    - `Funcionalidad 1`: Se inyecta a través de un record los datos de los libros.
    - `Funcionalidad 2`: Se sobreescriben los elementos.
  - Clase Libro:
    - `Funcionalidad 1`: Se crea la tabla para almacenar los datos de los libros.
    - `Funcionalidad 2`: Se mapea la llave foránea con la entidad 'Autor'.
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
    - `Funcionalidad 1`: Se inyecta el repositorio para la clase Autor.
    - `Funcionalidad 2`: Se crean los métodos para acceder a las consultas del repositorio AutorRepository.
  - Clase ConsumoAPI:
    - `Funcionalidad 1`: Se crea el método para consumir la API.
  - Clase ConvierteDatos:
    - `Funcionalidad 1`: Se conecta a la interface IConvierteDatos.
    - `Funcionalidad 2`: Se sobreescribe el método obtenerDatos de la interface IConvierteDatos para realizar el mapeo de los datos en la API.
  - Interface IConvierteDatos:
    - `Funcionalidad 1`: Se crea el método obtenerDatos para realizar el mapeo de los datos en la API.
  - Clase LibroService:
    - `Funcionalidad 1`: Se inyecta el repositorio para la clase Libro.
    - `Funcionalidad 2`: Se crean los métodos para acceder a las consultas del repositorio LibroRepository.
  - Clase LiteraluraChallengeApplication:
    - `Funcionalidad 1`: Clase principal de la aplicación para ejecutar el proyecto.
    - `Funcionalidad 2`: Se conecta a CommandLineRunner.
    - `Funcionalidad 3`: Se crea el método main.
    - `Funcionalidad 4`: Se inyecta la clase Principal para acceder al proyecto y ejecutar el método 'muestraElMenu'.
- Capturas Proyecto.
  - ![1](https://github.com/user-attachments/assets/f1206655-dbd4-4a01-82b5-488697fa4721)
  - ![2](https://github.com/user-attachments/assets/edf43afe-36b5-433c-9de9-67e369e03cc3)
  - ![3](https://github.com/user-attachments/assets/aedc54d4-3a8d-49b1-ac84-d9fe7132bacc)
  - ![4](https://github.com/user-attachments/assets/dadeb051-9d12-4553-aa96-fba90b20c6d5)
  - ![5](https://github.com/user-attachments/assets/da0e79ab-2082-4fd9-a1bf-3f88f841c3c3)
  - ![6](https://github.com/user-attachments/assets/fed58525-fe7c-477e-a7c0-3492aae207f0)
  - ![7](https://github.com/user-attachments/assets/39415fa0-71ca-44dd-bdc7-03d1f008e446)
  - ![8](https://github.com/user-attachments/assets/e45968b9-20f0-4480-ace1-923062544e7c)
  - ![9](https://github.com/user-attachments/assets/7e13e111-5ff6-44c3-bd2c-e3d8c0464ea7)
  - ![10](https://github.com/user-attachments/assets/d15617c1-5f43-4c50-85b4-51127dbe8b3d)
  - ![11](https://github.com/user-attachments/assets/e1bf1bd7-ab97-473a-937a-a12ba8b3acc2)
  - ![12](https://github.com/user-attachments/assets/eede4af0-f043-4542-bef6-2e00130b48b8)
  - ![13](https://github.com/user-attachments/assets/22f1b534-0c21-47ef-bd72-792d34009427)
  - ![14](https://github.com/user-attachments/assets/05dc3f37-9e67-44e4-958e-073149c73ab3)
  - ![15](https://github.com/user-attachments/assets/73186cc0-e910-4313-831e-10e163f4f4d1)
  - ![16](https://github.com/user-attachments/assets/bbc66c00-6dd7-40dc-a8d0-53673f9a4166)
  - ![17](https://github.com/user-attachments/assets/1330f1ec-bc3f-4b57-a337-cc411d8665c6)
  - ![18](https://github.com/user-attachments/assets/d92c6066-60e9-44c8-9052-2cfc7cef47b1)
  - ![19](https://github.com/user-attachments/assets/09896413-2783-4b88-8ad7-5199b3b9932f)
  - ![20](https://github.com/user-attachments/assets/ca44e98e-768f-4ed1-af9b-9cebe9ebeb93)
  - ![21](https://github.com/user-attachments/assets/ae5f2a71-20f3-4b0b-bab6-ac0f3af1a8bf)
  - ![22](https://github.com/user-attachments/assets/9d9cd097-fa24-46a2-ba0a-823cba49149a)
  - ![23](https://github.com/user-attachments/assets/3d8a71d2-606e-43a3-b11e-9f375c0df6e7)
- Ejecución del proyecto:
  - https://github.com/user-attachments/assets/187aeedd-90e1-4838-881b-364aee47e5fd


