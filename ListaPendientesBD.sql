CREATE TABLE Usuarios(
	id_usuario SERIAL PRIMARY KEY,
	correo VARCHAR(255) NOT NULL,
	password0 VARCHAR (255) NOT NULL,
	rol INT NOT NULL
);

CREATE TABLE Responsable (
	id_responsable SERIAL PRIMARY KEY,
	nombres_responsable VARCHAR (255) NOT NULL, 
	apellidos_responsable VARCHAR (255) NOT NULL,
	telefono VARCHAR (9),
	edad INT, 
	estado_responsable INT NOT NULL,
	user_create VARCHAR (255),
	user_date_create TIMESTAMP,
	user_update VARCHAR(255),
	user_date_update TIMESTAMP,
	user_delete VARCHAR(255),
	id_usuario_fk INT NOT NULL,
	FOREIGN KEY (id_usuario_fk) REFERENCES Usuarios (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE Apoderado (
	id_apoderado SERIAL PRIMARY KEY,
	nombre_apoderado VARCHAR(255) NOT NULL,
	apellido_apoderado VARCHAR (255) NOT NULL,
	telefono VARCHAR (9),
	parentesto VARCHAR (255),
	estado_parentesco INT NOT NULL,
	user_create VARCHAR (255),
	user_date_create TIMESTAMP,
	user_update VARCHAR(255),
	user_date_update TIMESTAMP,
	user_delete VARCHAR(255),
	id_usuario_fk INT NOT NULL,
	FOREIGN KEY (id_usuario_fk) REFERENCES Usuarios (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE Comentario (
	id_comentario SERIAL PRIMARY KEY,
	fecha_creacion TIMESTAMP NOT NULL,
	fecha_actualizacion TIMESTAMP NOT NULL, 
	descripcion_comentario VARCHAR(255)	
);

CREATE TABLE Categoria(
	id_categoria SERIAL PRIMARY KEY,
	nombre_categoria VARCHAR(255),
	descripcion_categoria VARCHAR (255),
	estado_parentesco INT NOT NULL,
	user_create VARCHAR (255),
	user_date_create TIMESTAMP,
	user_update VARCHAR(255),
	user_date_update TIMESTAMP,
	user_delete VARCHAR(255)
);


CREATE TABLE Tarea(
	id_tarea SERIAL PRIMARY KEY,
	titulo VARCHAR (255) NOT NULL,
	descripcion VARCHAR (255),
	fecha_creacion TIMESTAMP NOT NULL,
	fecha_vencimiento TIMESTAMP NOT NULL,
	estado_tarea INT NOT NULL,
	user_create VARCHAR (255),
	user_date_create TIMESTAMP,
	user_update VARCHAR(255),
	user_date_update TIMESTAMP,
	user_delete VARCHAR(255),
	id_comentario_fk INT NOT NULL,
	id_categoria_fk INT NOT NULL,
	id_apoderado_fk INT NOT NULL,
	id_responsable_fk INT NOT NULL,
	FOREIGN KEY (id_comentario_fk) REFERENCES Comentario (id_comentario) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_categoria_fk) REFERENCES Categoria (id_categoria) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_apoderado_fk) REFERENCES Apoderado (id_apoderado) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_responsable_fk) REFERENCES Responsable (id_responsable) ON DELETE NO ACTION ON UPDATE NO ACTION
);
