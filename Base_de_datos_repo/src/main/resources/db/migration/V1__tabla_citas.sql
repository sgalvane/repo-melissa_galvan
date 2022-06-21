use ejemplo;
create table citas
(
    id_cita INT NOT NULL auto_increment,
    id_paciente INT NOT NULL,
    medico VARCHAR (30) NOT NULL,
    eps VARCHAR(30) NOT NULL,
    fecha_cita DATE,
    fecha_creacion DATE,
    fecha_eliminacion DATE,
    primary key (id_cita)
);