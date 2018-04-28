--
-- Criar tabela material.
--
CREATE TABLE material (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
input INT,
name VARCHAR(80),
price DECIMAL(6,4) NOT NULL,
stockQuantity INT,
idGroup INT,
imported boolean not null default 0
);
