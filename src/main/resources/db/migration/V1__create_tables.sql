CREATE TABLE IF NOT EXISTS Livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    anoPublicacao INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Membro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco TEXT NOT NULL,
    telefone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Emprestimo (
    id SERIAL PRIMARY KEY,
    id_livro INTEGER NOT NULL,
    id_membro INTEGER NOT NULL,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,
    FOREIGN KEY (id_livro) REFERENCES Livro (id),
    FOREIGN KEY (id_membro) REFERENCES Membro (id)
);

CREATE TABLE IF NOT EXISTS Bibliotecario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Visitante (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20)
);