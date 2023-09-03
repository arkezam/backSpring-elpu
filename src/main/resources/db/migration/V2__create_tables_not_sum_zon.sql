

INSERT INTO usuarios (dni, password, nombres, apellido_paterno, apellido_materno, correo, cel, token)
VALUES
    ('00000000', '$2a$10$yHZaUbAgRuYBhbSxWwt9IO3IXIKA8jHenkT72pMXZgdtShPCzcRJy', 'admin', 'istrador', 'ELP', 'arkezam@mail.com', '92651819', ''),
    ('00000001', '$2a$10$yHZaUbAgRuYBhbSxWwt9IO3IXIKA8jHenkT72pMXZgdtShPCzcRJy', 'Maria', 'Lopez', 'Torres', 'mlopez@mail.com', '998123456', '');


INSERT INTO zonas (id,nombre_zona)
VALUES
    (301,'JULIACA'),
    (302,'JULIACA MAYORES'),
    (303,'LAMPA'),
    (305,'AYAVIRI'),
    (306,'AZANGARO'),
    (307,'SANDIA'),
    (308,'ANANEA'),
    (309,'PUTINA'),
    (310,'HUANCANE'),
    (311,'CRUCERO'),
    (312,'MOHO'),
    (315,'SAN GABAN'),
    (350,'AYAVIRI'),
    (351,'AYAVIRI'),
    (352,'AYAVIRI'),
    (354,'AYAVIRI'),
    (355,'AYAVIRI'),
    (356,'AYAVIRI'),
    (358,'AYAVIRI'),
    (360,'AZANGARO'),
    (361,'AZANGARO'),
    (362,'AZANGARO'),
    (363,'AZANGARO'),
    (364,'AZANGARO'),
    (365,'AZANGARO'),
    (366,'AZANGARO'),
    (367,'AZANGARO'),
    (368,'AZANGARO'),
    (369,'AZANGARO'),
    (370,'AZANGARO'),
    (395,'PUTINA'),
    (401,'PUNO'),
    (405,'YUNGUYO'),
    (411,'PUNO MAYORES'),
    (415,'ILAVE'),
    (420,'CHUCUITO'),
    (425,'POMATA'),
    (430,'JULI'),
    (435,'DESAGUADERO'),
    (440,'TINICACHI'),
    (450,'ANAPIA'),
    (460,'VILQUE'),
    (480,'PUNO'),
    (600,'AISLADO AMANTANI');


INSERT INTO notificaciones (mensaje, usuariofk, fecha_notificacion)
VALUES
    ('Estimado Usuario, su recibo esta caducado, pague a tiempo, evite cortes', 1, '2023-02-25 08:15:30'),
    ('Corte programado en Ananea, Todas Zonas ', 1, '2023-02-25 12:45:15'),
    ('Bienvenido a la APP de Electro Puno', 2, '2023-02-26 16:30:00');


INSERT INTO suministros (ruta, codigo_suministro, zonafk, usuariofk)
VALUES
    ('Ruta 1', 'AA123', 301, 1),
    ('Ruta 5', 'AB456', 301, 2),
    ('Ruta 2', 'CC789', 401, 1);