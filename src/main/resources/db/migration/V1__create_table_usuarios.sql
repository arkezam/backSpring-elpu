CREATE TABLE `usuarios` (
    `id` bigint PRIMARY KEY AUTO_INCREMENT,
    `dni` varchar(8) NOT NULL UNIQUE ,
    `password` varchar(255) NOT NULL,
    `nombres` varchar(100) NOT NULL,
    `apellido_paterno` varchar(100) NOT NULL,
    `apellido_materno` varchar(100) NOT NULL,
    `correo` varchar(100) NOT NULL UNIQUE,
    `cel` varchar(20) NOT NULL,
    `estado` tinyint DEFAULT 1,
    `nivel` tinyint DEFAULT 1,
    `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
    `token` varchar(255),
    `parentezco` varchar(255)
);


CREATE TABLE zonas (
                       id INT PRIMARY KEY,
                       nombre_zona VARCHAR(100)
);
CREATE TABLE notificaciones (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                mensaje TEXT,
                                usuariofk bigint,
                                fecha_notificacion DATETIME,
                                FOREIGN KEY (usuariofk) REFERENCES usuarios(id)
);
CREATE TABLE suministros (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             ruta VARCHAR(100),
                             codigo_suministro VARCHAR(50),
                             zonafk INT,
                             usuariofk bigint,
                             FOREIGN KEY (zonafk) REFERENCES zonas(id),
                             FOREIGN KEY (usuariofk) REFERENCES usuarios(id)
);

