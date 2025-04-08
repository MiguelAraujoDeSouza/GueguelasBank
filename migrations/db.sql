-- Tabela BANK
CREATE TABLE banks (
       id SERIAL PRIMARY KEY,
       name VARCHAR(255),
       address VARCHAR(255),
       city VARCHAR(255),
       cpnj VARCHAR(20)
);

-- Tabela USER
CREATE TABLE users (
       id SERIAL PRIMARY KEY,
       name VARCHAR(255),
       email VARCHAR(255) UNIQUE,
       cpf VARCHAR(14) UNIQUE,
       password VARCHAR(255),
       phone VARCHAR(20),
       address VARCHAR(255),
       city VARCHAR(255),
       contry VARCHAR(100),
       bank_id INTEGER,
       CONSTRAINT fk_user_bank FOREIGN KEY (bank_id) REFERENCES banks(id) ON DELETE CASCADE
);

-- Inserir dados na tabela BANKS
INSERT INTO banks (name, address, city, cpnj) VALUES
      ('Banco Gueguelas', 'Av. das Palmeiras, 123', 'São Paulo', '12.345.678/0001-90'),
      ('Banco Solar', 'Rua das Orquídeas, 456', 'Rio de Janeiro', '98.765.432/0001-10'),
      ('Banco Estelar', 'Praça do Sol, 789', 'Belo Horizonte', '11.222.333/0001-55');

-- Inserir dados na tabela USERS
INSERT INTO users (name, email, cpf, password, phone, address, city, contry, bank_id) VALUES
      ('Miguel Araujo', 'miguel.araujo@gueguelasbank.com', '123.456.789-00', 'senha123', '(11) 98765-4321', 'Rua A, 100', 'São Paulo', 'Brasil', 1),
      ('Laura Silva', 'laura.silva@solarbank.com', '987.654.321-00', 'senha456', '(21) 99876-5432', 'Rua B, 200', 'Rio de Janeiro', 'Brasil', 2),
      ('Carlos Souza', 'carlos.souza@estelarbank.com', '111.222.333-44', 'senha789', '(31) 91234-5678', 'Rua C, 300', 'Belo Horizonte', 'Brasil', 3),
      ('Fernanda Lima', 'fernanda.lima@gueguelasbank.com', '555.666.777-88', 'senha321', '(11) 97654-3210', 'Rua D, 400', 'São Paulo', 'Brasil', 1);
