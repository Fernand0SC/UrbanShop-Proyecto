CREATE TABLE wishlist_items (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                usuario_id BIGINT NOT NULL,
                                producto_id BIGINT NOT NULL,
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);