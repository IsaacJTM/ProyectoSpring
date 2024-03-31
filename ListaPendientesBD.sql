CREATE TABLE Rol(
	id_rol SERIAL PRIMARY KEY,
	nombre_Rol VARCHAR(255) NOT NULL,
	user_create VARCHAR (255),
	user_date_create TIMESTAMP,
	user_update VARCHAR(255),
	user_date_update TIMESTAMP,
	user_delete VARCHAR(255)
);

CREATE TABLE Usuario (
	id_usuario SERIAL PRIMARY KEY,
	nombre_usuario VARCHAR (255) NOT NULL,
	apellidos_usuario VARCHAR (255),
	email_usuario VARCHAR (255) UNIQUE NOT NULL,
	numero_documento VARCHAR(255) NOT NULL,
	password VARCHAR (255) NOT NULL,
	telefono VARCHAR (9),
	edad INT, 
	estado_Usuario INT NOT NULL,
	id_rol_fk INT, 
	user_create VARCHAR (255),
	user_date_create TIMESTAMP,
	user_update VARCHAR(255),
	user_date_update TIMESTAMP,
	user_delete VARCHAR(255),
	FOREIGN KEY (id_rol_fk) REFERENCES Rol (id_rol) ON DELETE NO ACTION ON UPDATE NO ACTION
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
	id_usuario_fk INT NOT NULL,
	FOREIGN KEY (id_comentario_fk) REFERENCES Comentario (id_comentario) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_categoria_fk) REFERENCES Categoria (id_categoria) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (id_usuario_fk) REFERENCES Usuario (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO rol VALUES (1,'ADMIN',current_user,CURRENT_TIMESTAMP);
INSERT INTO rol VALUES (2,'RESPONSABLE',current_user,CURRENT_TIMESTAMP);
INSERT INTO rol VALUES (3,'DELEGANTE',current_user,CURRENT_TIMESTAMP);