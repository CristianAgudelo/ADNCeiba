create table asesoria (
    id int not null auto_increment,
    asesor int not null,
    hora_inicio int not null,
    hora_fin int not null,
    fecha_asesoria date not null,
    duracion int not null,

     primary key (id),
     FOREIGN key (asesor) REFERENCES usuario(id)
);