# Getting Started

### Implementación

* Crear la base de datos en MySQL usando el script sql adjunto (scriptPruebaTecnica.sql)
* Cambiar en el fichero application.properties usuario de la base de datos y contraseña por unas que este en su base de datos

### Ejecución

* Código principal desde el Main ubicado en la clase PruebaTecnicaBackendApplication
* Código testing desde la clase PruebaTecnicaBackendApplicationTests

### Peticiones en Postman

* Raíz peticiones: http://localhost:8080/api/books
* Get
  * Sin añadir nada: Mostraría todos los libros
  * /{id}: Mostraría el libro con un id en específico
  * /author/{author}: Mostraría el libro/s con un author en específico
  * /author/containing/{author}: Mostraría el libro/s con un author que contenga una palabra en específico (por ejemplo Julio)
  * /title/{title}: Mostraría el libro/s con un title en específico
  * /title/containing/{title}: Mostraría el libro/s con un title que contenga una palabra en específico (por ejemplo Viaje)
  * /readed/{readed}: Mostraría el libro con un readed en específico
  * /readed/containing/{readed}: Mostraría el libro con un readed que contenga una palabra en específico (por ejemplo No)
  * /created/{created}: Mostraría el libro con un created en específico
  * /created/containing/{created}: Mostraría el libro con un created que contenga una palabra en específico (por ejemplo 2025)
* Post
  * Sin añadir nada: El objeto en formato JSON en el body
* Put
    * Sin añadir nada: El objeto en formato JSON en el body
* Patch
  * /{id}: Pone el libro a Leido o NoLeido dependiendo de cómo estuviese en al hacer la petición
* Delete
  * /{id}: Elimina el libro con el id especificado

### Decisiones tomadas

* Sustituir el isReaded por String debido a que internamente en mi ordenador lo cogía como entero
* Sustituir el createdAt por String debido a que internamente en mi ordenador lo cogía como null

### Estructura del proyecto

* Controlador
  * ControladorLibro
* Dto
  * LibroDto (sirve para mostrar o insertar unos datos en especifico)
* Excepciones (Con excepciones personalicadas para errores 400, 404, 405 y 500)
  * ControladorExcepciones
  * ExcepcionesPersonalizadasNoEncontrado
  * ExcepcionRespuesta
* Modelo
  * Libro (Clase generada por hibernate)
* Repositorio
  * IGenericoRepositorio
  * ILibroRepo
* Servicio
  * CRUD
  * ICRUD
  * ILibroServicio
  * LibroServicio
* PruebaTecnicaBackendApplication

### Merjoras
* Añadiria una tabla de ejemplares para gestionar cuantos ejemplares hay de cada libro
* Añadiria una tabla de usuarios para para asignar rol de de usuario normal y administrador usando JWTAuthentication
* Añadiria una tabla de prestamos para que los usuarios puedan ver los ejemplares prestados