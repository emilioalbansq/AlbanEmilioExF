-- database: ../DataBase/aeEXOBOT.sqlite
/*
Autor: emilioalbansq
Fecha: 3.enero.2026
Script: Datos iniciales (ExoTrooper)
*/

PRAGMA foreign_keys = ON;

/* =========================
   Catálogos (existentes)
   ========================= */
INSERT INTO CatalogoTipo (Nombre, Descripcion) VALUES
('Tipo Persona',  'Tipos Sold, meca, ...'),
('Sexo',          'Mas, Feme,...'),
('EstadoCivil',   'Sol, Viu, Cas,...'),
('Raza',          'Negro, Blanco,...');

INSERT INTO Catalogo (IdCatalogoTipo, Nombre, Descripcion) VALUES
(1, 'Soldado',      'Tipos de Personas del Ejercito'),
(1, 'Mecanico',     'Tipos de Personas del Ejercito'),
(1, 'Experto Ing.', 'Tipos de Personas del Ejercito'),
(1, 'Experto Esp.', 'Tipos de Personas del Ejercito'),

(2, 'Masculino',     'Tipos de Sexualidad'),
(2, 'Femenino',      'Tipos de Sexualidad'),
(2, 'Hibrido',       'Tipos de Sexualidad'),
(2, 'Asexual',       'Tipos de Sexualidad'),

(3, 'Soltero',       'Tipos de Estado Civil'),
(3, 'Casado',        'Tipos de Estado Civil'),
(3, 'Divorciado',    'Tipos de Estado Civil'),
(3, 'Viudo',         'Tipos de Estado Civil'),

(4, 'Negro',         'Tipos de Raza'),
(4, 'Blanco',        'Tipos de Raza'),
(4, 'Mestizo',       'Tipos de Raza'),
(4, 'Indígena',      'Tipos de Raza');

INSERT INTO Persona
(IdCatalogoTipoPersona, IdCatalogoSexo, IdCatalogoEstadoCivil, Cedula,  Nombre,  Apellido) VALUES
(1, 5,  9,  '11111', 'Pepe',  'Putin'),
(2, 5,  10, '22222', 'Juan',  'Putin'),
(3, 5,  11, '33333', 'Pedro', 'Putin'),
(4, 5,  12, '44444', 'Pablo', 'Putin'),
(1, 6,  9,  '01010', 'Ana',   'Putin'),
(2, 6,  10, '02020', 'Pepa',  'Putin'),
(3, 6,  11, '03030', 'Gelen', 'Putin'),
(4, 6,  12, '04040', 'Cami',  'Putin');

/* =========================
   ExoTrooper (MER)
   ========================= */
INSERT INTO IABot (Nombre, Descripcion) VALUES
('IA-RUSO', 'Inteligencia artificial (IABOT)');

INSERT INTO TipoExoBot (Nombre) VALUES
('ExoAsalto'),
('ExoExplorador'),
('ExoInfanteria'),
('ExoMedico'),
('ExoComando');

-- Solo una acción para tu ExoMedico: asistir
INSERT INTO AccionArma (Nombre) VALUES
('asistir');

INSERT INTO TipoArma (Nombre, TipoRecursos) VALUES
('Fusil',      'Munición'),
('Revolver',   'Munición'),
('GPS',        'Energía'),
('Giroscopio', 'Energía'),
('Misil',      'Munición'),
('Mortero',    'Munición'),
('BioSensor',  'Energía'),
('BioEscaner', 'Energía'),
('Laser',      'Munición'),
('Bayoneta',   'Munición');

INSERT INTO TipoEnergia (Nombre) VALUES
('Munición_Fusil'),
('Munición_Revolver'),
('Munición_Misil'),
('Munición_Mortero'),
('Munición_Laser'),
('Munición_Bayoneta'),
('Energía_GPS'),
('Energía_Giroscopio'),
('Energía_BioSensor'),
('Energía_BioEscaner');

INSERT INTO SoldadoExperto (Nombre) VALUES
('Soldado Experto-1'),
('Soldado Experto-2'),
('Soldado Experto-3'),
('Soldado Experto-4'),
('Soldado Experto-5');

INSERT INTO ExoBot (IdIABot, IdTipoExoBot) VALUES
((SELECT IdIABot FROM IABot WHERE Nombre='IA-RUSO'), (SELECT IdTipoExoBot FROM TipoExoBot WHERE Nombre='ExoAsalto')),
((SELECT IdIABot FROM IABot WHERE Nombre='IA-RUSO'), (SELECT IdTipoExoBot FROM TipoExoBot WHERE Nombre='ExoExplorador')),
((SELECT IdIABot FROM IABot WHERE Nombre='IA-RUSO'), (SELECT IdTipoExoBot FROM TipoExoBot WHERE Nombre='ExoInfanteria')),
((SELECT IdIABot FROM IABot WHERE Nombre='IA-RUSO'), (SELECT IdTipoExoBot FROM TipoExoBot WHERE Nombre='ExoMedico')),
((SELECT IdIABot FROM IABot WHERE Nombre='IA-RUSO'), (SELECT IdTipoExoBot FROM TipoExoBot WHERE Nombre='ExoComando'));

INSERT INTO ExoBotArma (IdExoBot, IdTipoArma, IdTipoEnergia, IdAccionArma, Descripcion) VALUES
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoAsalto'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Fusil'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Munición_Fusil'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Fusil'),
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoAsalto'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Revolver'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Munición_Revolver'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Revolver');

INSERT INTO ExoBotArma (IdExoBot, IdTipoArma, IdTipoEnergia, IdAccionArma, Descripcion) VALUES
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoExplorador'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='GPS'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Energía_GPS'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial GPS'),
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoExplorador'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Giroscopio'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Energía_Giroscopio'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Giroscopio');

INSERT INTO ExoBotArma (IdExoBot, IdTipoArma, IdTipoEnergia, IdAccionArma, Descripcion) VALUES
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoInfanteria'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Misil'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Munición_Misil'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Misil'),
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoInfanteria'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Mortero'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Munición_Mortero'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Mortero');

INSERT INTO ExoBotArma (IdExoBot, IdTipoArma, IdTipoEnergia, IdAccionArma, Descripcion) VALUES
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoMedico'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='BioSensor'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Energía_BioSensor'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial BioSensor'),
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoMedico'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='BioEscaner'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Energía_BioEscaner'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial BioEscaner');

INSERT INTO ExoBotArma (IdExoBot, IdTipoArma, IdTipoEnergia, IdAccionArma, Descripcion) VALUES
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoComando'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Laser'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Munición_Laser'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Laser'),
((SELECT b.IdExoBot FROM ExoBot b JOIN TipoExoBot t ON t.IdTipoExoBot=b.IdTipoExoBot WHERE t.Nombre='ExoComando'),
 (SELECT IdTipoArma FROM TipoArma WHERE Nombre='Bayoneta'),
 (SELECT IdTipoEnergia FROM TipoEnergia WHERE Nombre='Munición_Bayoneta'),
 (SELECT IdAccionArma FROM AccionArma WHERE Nombre='asistir'),
 'Asociación inicial Bayoneta');
