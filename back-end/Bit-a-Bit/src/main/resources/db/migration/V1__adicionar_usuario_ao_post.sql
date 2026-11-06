ALTER TABLE artigo
    ADD COLUMN usuario_id BIGINT NOT NULL;
    
ALTER TABLE artigo
    ADD CONSTRAINT fk_usuario_artigo
    FOREIGN KEY (usuario_id) REFERENCES usuario(id);