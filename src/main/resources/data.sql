-- Criação da tabela Autor
CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255)
);

-- Criação da tabela Musica
CREATE TABLE musica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    url_musica VARCHAR(255),
    data_lancamento TIMESTAMP,
    autor_id INT,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);

-- Inserção de autores
INSERT INTO autor (id, nome) VALUES (1,'Autor 1');
INSERT INTO autor (id, nome) VALUES (2,'Autor 2');

-- Inserção de músicas
INSERT INTO musica (nome, url_musica, data_lancamento, autor_id) VALUES ('Música 1', 'http://example.com/musica1', '2023-09-24 10:00:00', 1);
INSERT INTO musica (nome, url_musica, data_lancamento, autor_id) VALUES ('Música 2', 'http://example.com/musica2', '2023-09-24 11:00:00', 1);
INSERT INTO musica (nome, url_musica, data_lancamento, autor_id) VALUES ('Música 3', 'http://example.com/musica3', '2023-09-24 12:00:00', 2);
