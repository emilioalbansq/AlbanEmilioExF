-- database: ../DataBase/aeEXOBOT.sqlite
/*
Autor: emilioalbansq
Fecha: 3.enero.2026
Script: Insertando Catalogo
*/


INSERT INTO CatalogoTipo
( Nombre,          Descripcion) VALUES
( 'Tipo Persona',  'Tipos Sold, meca, ...'),
( 'Sexo',          'Mas, Feme,...'),
( 'EstadoCivil',   'Sol, Viu, Cas,...'),
( 'Raza',          'Negro, Blanco,...');

INSERT INTO Catalogo
 (IdCatalogoTipo, Nombre,        Descripcion) VALUES
 (1,             'Soldado',      'Tipos de Personas del Ejercito'),
 (1,             'Mecanico',     'Tipos de Personas del Ejercito'),
 (1,             'Experto Ing.', 'Tipos de Personas del Ejercito'),
 (1,             'Experto Esp.', 'Tipos de Personas del Ejercito'),

 (2,             'Masculino',     'Tipos de Sexualidad'),
 (2,             'Femenino',      'Tipos de Sexualidad'),
 (2,             'Hibrido',       'Tipos de Sexualidad'),
 (2,             'Asexual',       'Tipos de Sexualidad'),

 (3,             'Soltero',       'Tipos de Estado Civil'),
 (3,             'Casado',        'Tipos de Estado Civil'),
 (3,             'Divorciado',    'Tipos de Estado Civil'),
 (3,             'Viudo',         'Tipos de Estado Civil'),

 (4,             'Negro',         'Tipos de Raza'),
 (4,             'Blanco',         'Tipos de Raza'),
 (4,             'Mestizo',       'Tipos de Raza'),
 (4,             'Indígena',      'Tipos de Raza');

insert INTO IABot (Nombre, Observacion)
            VALUES("IA-RUSO", "Inteligencia artificial");

INSERT INTO ExaBot
    (IdIABot,   Nombre,     Serie) VALUES
    (1,         "exabot1",  "Serie E1"),
    (1,         "exabot2",  "Serie E2");

INSERT INTO Persona
(   IdCatalogoTipoPersona, IdCatalogoSexo, IdCatalogoEstadoCivil, Cedula,  Nombre,  Apellido) VALUES
(   1,                      5,              9,                    "11111", "Pepe",  "Putin"),
(   2,                      5,              10,                   "22222", "Juan",  "Putin"),
(   3,                      5,              11,                   "33333", "Pedro", "Putin"),
(   4,                      5,              12,                   "44444", "Pablo", "Putin"),
(   1,                      6,              9,                    "01010", "Ana",   "Putin"),
(   2,                      6,              10,                   "02020", "Pepa",  "Putin"),
(   3,                      6,              11,                   "03030", "Gelen", "Putin"),
(   4,                      6,              12,                   "04040", "Cami",  "Putin");


