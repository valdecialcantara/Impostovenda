--
-- Criar tabela groupMaterial.
--
CREATE TABLE groupMaterial (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(80),
dutyFree boolean not null default 0
);
