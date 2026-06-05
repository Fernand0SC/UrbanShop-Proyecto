CREATE TABLE tickets_postventa (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   id_cliente BIGINT NOT NULL,
                                   id_pedido BIGINT NOT NULL,
                                   tipo_solicitud VARCHAR(50) NOT NULL,
                                   descripcion VARCHAR(500) NOT NULL,
                                   estado VARCHAR(50) NOT NULL
);