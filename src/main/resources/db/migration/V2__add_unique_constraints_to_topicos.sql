ALTER TABLE topicos
ADD CONSTRAINT uk_mensaje UNIQUE (mensaje(255)),
ADD CONSTRAINT uk_titulo UNIQUE (titulo);