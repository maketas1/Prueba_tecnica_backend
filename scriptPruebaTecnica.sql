Create or REPLACE DATABASE PruebaTecnicaBackendAngelGallardo;
use PruebaTecnicaBackendAngelGallardo;

CREATE TABLE libros (
	id int PRIMARY KEY,
	title VARCHAR(40),
	author VARCHAR(40),
	readed ENUM('Leido', 'NoLeido') DEFAULT 'NoLeido',
	created VARCHAR(40)
	);
	
Insert into libros(id, title, author, readed, created) values (1, 'Don Quijote', 'Miguel de Cervantes', 'NoLeido' , '2025-01-22');
Insert into libros(id, title, author, readed, created) values (2, 'Viaje al centro de la tierra', 'Julio Verne', 'NoLeido' , '2025-01-22');