CREATE TABLE productos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(255) NOT NULL,
                           descripcion VARCHAR(500) NOT NULL,
                           precio DOUBLE NOT NULL,
                           stock INT NOT NULL
);