CREATE TABLE IF NOT EXISTS notificaciones (
                                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                              usuario_id BIGINT NOT NULL,
                                              tipo_mensaje VARCHAR(50) NOT NULL, -- EJ: BIENVENIDA, PAGO, DESPACHO
    contenido TEXT NOT NULL,
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );