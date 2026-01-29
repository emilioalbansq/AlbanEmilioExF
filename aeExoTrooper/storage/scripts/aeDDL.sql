-- database: ../DataBase/aeEXOBOT.sqlite
/*
Autor: emilioalbansq
Fecha: 28.enero.2026
Script: Creación de la estructura de datos (ExoTrooper)
*/

-- Desactivar FK mientras se limpian tablas viejas
PRAGMA foreign_keys = OFF;


DROP TABLE IF EXISTS ExoBotArma;
DROP TABLE IF EXISTS ExoBot;
DROP TABLE IF EXISTS SoldadoExperto;
DROP TABLE IF EXISTS TipoEnergia;
DROP TABLE IF EXISTS TipoArma;
DROP TABLE IF EXISTS AccionArma;
DROP TABLE IF EXISTS TipoExoBot;
DROP TABLE IF EXISTS IABot;

DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;

PRAGMA foreign_keys = ON;


CREATE TABLE CatalogoTipo (
    IdCatalogoTipo INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(30)  NOT NULL UNIQUE,
    Descripcion    VARCHAR(90),
    Estado         VARCHAR(1)   NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME     DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE Catalogo (
    IdCatalogo     INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipo INTEGER      NOT NULL REFERENCES CatalogoTipo (IdCatalogoTipo),
    Nombre         VARCHAR(30)  NOT NULL,
    Descripcion    VARCHAR(90),
    Estado         VARCHAR(1)   NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME     DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME,
    UNIQUE (IdCatalogoTipo, Nombre)
);

CREATE TABLE Persona (
    IdPersona              INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdCatalogoTipoPersona  INTEGER     NOT NULL REFERENCES Catalogo(IdCatalogo),
    IdCatalogoSexo         INTEGER     NOT NULL REFERENCES Catalogo(IdCatalogo),
    IdCatalogoEstadoCivil  INTEGER     NOT NULL REFERENCES Catalogo(IdCatalogo),
    Cedula                 VARCHAR(10) NOT NULL UNIQUE,
    Nombre                 VARCHAR(50) NOT NULL,
    Apellido               VARCHAR(50) NOT NULL,
    Estado                 VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion          DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica          DATETIME
);

CREATE TABLE IABot (
    IdIABot        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(50) NOT NULL UNIQUE,
    Descripcion    VARCHAR(90),
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE TipoExoBot (
    IdTipoExoBot   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(30) NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE AccionArma (
    IdAccionArma   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(30) NOT NULL UNIQUE,
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE TipoArma (
    IdTipoArma     INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(30)  NOT NULL UNIQUE,
    TipoRecursos   VARCHAR(10)  NOT NULL, -- 'Munición' | 'Energía'
    Estado         VARCHAR(1)   NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME     DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE TipoEnergia (
    IdTipoEnergia  INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre         VARCHAR(40)  NOT NULL UNIQUE, -- 'Munición_Fusil', 'Energía_GPS'
    Estado         VARCHAR(1)   NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME     DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME
);

CREATE TABLE SoldadoExperto (
    IdSoldadoExperto INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Nombre           VARCHAR(50) NOT NULL,
    Estado           VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion    DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica    DATETIME
);

CREATE TABLE ExoBot (
    IdExoBot        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdIABot         INTEGER     NOT NULL REFERENCES IABot(IdIABot),
    IdTipoExoBot    INTEGER     NOT NULL REFERENCES TipoExoBot(IdTipoExoBot),
    Entreno         VARCHAR(2)  NOT NULL DEFAULT('NO'), -- 'SI' | 'NO'
    NoAccion        INTEGER     NOT NULL DEFAULT(0),
    Estado          VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion   DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica   DATETIME
);

CREATE TABLE ExoBotArma (
    IdExoBotArma   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdExoBot       INTEGER     NOT NULL REFERENCES ExoBot(IdExoBot),
    IdTipoArma     INTEGER     NOT NULL REFERENCES TipoArma(IdTipoArma),
    IdTipoEnergia  INTEGER     REFERENCES TipoEnergia(IdTipoEnergia),
    IdAccionArma   INTEGER     NOT NULL REFERENCES AccionArma(IdAccionArma),
    NoAccion       INTEGER     NOT NULL DEFAULT(0),
    Descripcion    VARCHAR(120),
    Estado         VARCHAR(1)  NOT NULL DEFAULT('A'),
    FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime')),
    FechaModifica  DATETIME,
    UNIQUE (IdExoBot, IdTipoArma)
);