
# Sistema de Gerenciamento de Biblioteca

## Introdução

Este é um sistema de gerenciamento de uma Biblioteca, desenvolvido como parte do
curso [Floripa Mais Tec](https://floripamaistec.pmf.sc.gov.br), durante o módulo de Spring, ministrado
por [André Santana Nunes](https://github.com/andresnunes). O sistema visa facilitar o controle de livros, membros,
empréstimos e bibliotecários.

## Tecnologias Utilizadas

- [Java](https://www.java.com/pt-BR/download/help/whatis_java.html)
- [Spring](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)

## Ferramentas Utilizadas

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)
- [Insomnia](https://insomnia.rest/)
- [Trello](https://trello.com/pt-BR)

## Pré-Requisitos

- JDK 21 ou superior instalado
- Git instalado na sua máquina
- IntelliJ IDEA
- Docker
- Docker Compose

## Dependências

1. **Spring Boot Starter for Spring Data JPA**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-starter-data-jpa`

2. **Spring Boot Starter for Spring Web**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-starter-web`

3. **Spring Boot DevTools for hot reloading**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-devtools`

4. **PostgreSQL Driver for Spring Data JPA**:
    - GroupId: `org.postgresql`
    - ArtifactId: `postgresql`

5. **Spring Boot Starter for testing**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-starter-test`

6. **Springdoc OpenAPI Starter for generating API documentation**:
    - GroupId: `org.springdoc`
    - ArtifactId: `springdoc-openapi-starter-webmvc-ui`
    - Version: `2.4.0`

## Como Começar

### Instalação

**Clonando o Repositório**

```bash
git clone https://github.com/leandroCodeDev/pseudo-biblioteca-spring.git
```

**Inicializando o Banco de Dados**

```bash
docker-compose up -d
```

**Execução**

Abra o projeto no IntelliJ IDEA e execute-o usando o atalho de execução da IDE.

## Documentação da API

### Servidor

- **URL**: [http://localhost:8090](http://localhost:8090)
- **Descrição**: URL do servidor gerado.

### Endpoints

#### 1. Visitação de Visitante

- **GET /visitante/{id}**
    - **Descrição**: Obtém um visitante pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do visitante.
    - **Respostas**:
        - **200 OK**: Retorna o visitante.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "integer",
                    "format": "int64"
                  },
                  "nome": {
                    "type": "string"
                  },
                  "telefone": {
                    "type": "string"
                  }
                }
              }
              ```

- **PUT /visitante/{id}**
    - **Descrição**: Atualiza um visitante pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do visitante.
        - `nome` (query, string, optional): Novo nome do visitante.
    - **Respostas**:
        - **200 OK**: Visitante atualizado com sucesso.
          - Tipo de conteúdo: text/plain
          - Exemplo de resposta:
            ```
             Visitante atualizado com sucesso.
            ```

- **DELETE /visitante/{id}**
    - **Descrição**: Exclui um visitante pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do visitante.
    - **Respostas**:
        - **200 OK**: Visitante excluído com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
               Visitante excluído com sucesso.
              ```

#### 2. Gerenciamento de Membros

- **GET /membro/{id}**
    - **Descrição**: Obtém um membro pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do membro.
    - **Respostas**:
        - **200 OK**: Retorna o membro.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "integer",
                    "format": "int64"
                  },
                  "nome": {
                    "type": "string"
                  },
                  "telefone": {
                    "type": "string"
                  },
                  "endereco": {
                    "type": "string"
                  }
                }
              }
              ```

- **PUT /membro/{id}**
    - **Descrição**: Atualiza um membro pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do membro.
        - `telefone` (query, string, optional): Novo telefone do membro.
      - **Respostas**:
        - **200 OK**: Membro atualizado com sucesso.
          - Tipo de conteúdo: text/plain
          - Exemplo de resposta:
            ```
             Membro atualizado com sucesso.
            ```

- **DELETE /membro/{id}**
    - **Descrição**: Exclui um membro pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do membro.
    - **Respostas**:
        - **200 OK**: Membro excluído com sucesso.
          - Tipo de conteúdo: text/plain
          - Exemplo de resposta:
            ```
             Membro excluído com sucesso.
            ```

#### 3. Gerenciamento de Livros

- **GET /livro/{id}**
    - **Descrição**: Obtém um livro pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do livro.
    - **Respostas**:
        - **200 OK**: Retorna o livro.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "integer",
                    "format": "int64"
                  },
                  "nome": {
                    "type": "string"
                  },
                  "autor": {
                    "type": "string"
                  },
                  "anoPublicacao": {
                    "type": "integer",
                    "format": "int32"
                  }
                }
              }
              ```

- **PUT /livro/{id}**
    - **Descrição**: Atualiza um livro pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do livro.
        - `nome` (query, string, optional): Novo nome do livro.

- **Respostas**:
    - **200 OK**: Livro atualizado com sucesso.
        - Tipo de conteúdo: text/plain
        - Exemplo de resposta:
          ```
           Livro atualizado com sucesso.
          ```

- **DELETE /livro/{id}**
    - **Descrição**: Exclui um livro pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do livro.
    - **Respostas**:
        - **200 OK**: Livro excluído com sucesso.
          - Tipo de conteúdo: text/plain
          - Exemplo de resposta:
            ```
             Livro excluído com sucesso.
            ```

#### 4. Gerenciamento de Empréstimos

- **GET /emprestimo/{id}**
    - **Descrição**: Obtém um empréstimo pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do empréstimo.
    - **Respostas**:
        - **200 OK**: Retorna o empréstimo.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "integer",
                    "format": "int64"
                  },
                  "dataEmprestimo": {
                    "type": "string",
                    "format": "date-time"
                  },
                  "dataDevolucao": {
                    "type": "string",
                    "format": "date-time"
                  },
                  "idLivro": {
                    "type": "integer",
                    "format": "int64"
                  },
                  "idMembro": {
                    "type": "integer",
                    "format": "int64"
                  }
                }
              }
              ```

- **PUT /emprestimo/{id}**
    - **Descrição**: Realiza a devolução de um empréstimo pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do empréstimo.
        - `devolucao` (query, boolean, optional): Indica se o livro foi devolvido.
    - **Respostas**:
        - **200 OK**: Empréstimo atualizado com sucesso.
          - Tipo de conteúdo: text/plain
          - Exemplo de resposta:
            ```
            Empréstimo atualizado com sucesso.
            ```

- **DELETE /emprestimo/{id}**
    - **Descrição**: Exclui um empréstimo pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do empréstimo.
    - **Respostas**:
        - **200 OK**: Empréstimo excluído com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Empréstimo excluído com sucesso.
              ```

#### 5. Gerenciamento de Bibliotecários

- **GET /bibliotecario/{id}**
    - **Descrição**: Obtém um bibliotecário pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do bibliotecário.
    - **Respostas**:
        - **200 OK**: Retorna o bibliotecário.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "integer",
                    "format": "int64"
                  },
                  "nome": {
                    "type": "string"
                  },
                  "email": {
                    "type": "string"
                  },
                  "senha": {
                    "type": "string"
                  }
                }
              }
              ```

- **PUT /bibliotecario/{id}**
    - **Descrição**: Atualiza um bibliotecário pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do bibliotecário.
        - `nome` (query, string, optional): Novo nome do bibliotecário.
        - `senha` (query, string, optional): Nova senha do bibliotecário.
    - **Respostas**:
        - **200 OK**: Bibliotecário atualizado com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Bibliotecário atualizado com sucesso.
              ```

- **DELETE /bibliotecario/{id}**
    - **Descrição**: Exclui um bibliotecário pelo ID.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do bibliotecário.
    - **Respostas**:
        - **200 OK**: Bibliotecário excluído com sucesso.
          - Tipo de conteúdo: text/plain
          - Exemplo de resposta:
            ```
            Bibliotecário excluído com sucesso.
            ```

#### 6. Realizar Empréstimo por Bibliotecário

- **POST /bibliotecario/{id}/emprestimo**
    - **Descrição**: Realiza um empréstimo de um livro por um bibliotecário.
    - **Parâmetros**:
        - `id` (path, integer, int64, required): ID do bibliotecário.
    - **Corpo da Requisição**:
        - Tipo de conteúdo: application/json
        - Schema:
          ```json
          {
            "type": "object",
            "properties": {
              "livroId": {
                "type": "integer",
                "format": "int64"
              },
              "membroId": {
                "type": "integer",
                "format": "int64"
              },
              "dataInicio": {
                "type": "string",
                "format": "date-time"
              },
              "dataFim": {
                "type": "string",
                "format": "date-time"
              }
            },
            "required": ["livroId", "membroId", "dataInicio", "dataFim"]
          }
          ```

    - **Respostas**:
        - **200 OK**: Empréstimo realizado com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Empréstimo realizado com sucesso.
              ```
