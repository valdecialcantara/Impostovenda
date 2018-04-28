--
-- Criar tabela sellProduct.
--
CREATE TABLE sellProduct (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
input INT,
name VARCHAR(80),
price DECIMAL(6,4) NOT NULL,
duty DECIMAL(6,4) NOT NULL,
quantity INT,
idMaterial INT
);
