# Biblioteca com MongoDB

Este é um projeto Spring Boot que utiliza MongoDB para gerenciar informações sobre livros em uma biblioteca.

## Como Executar

Execute a classe principal `BibliotecaMongoApplication` para iniciar a aplicação Spring Boot. Acesse `http://localhost:8080` para interagir com a API.

## Endpoints da API

- **GET /livros**: Obter todos os livros.
- **GET /livros/autor/{autor}**: Obter livros por autor.
- **GET /livros/genero/{genero}**: Obter livros por gênero.
- **POST /livros**: Adicionar um novo livro.
  - Exemplo de corpo da requisição:
    ```json
    {
      "titulo": "O Código da Vinci",
      "autor": "Dan Brown",
      "anoPublicacao": 2003,
      "genero": "Mistério"
    }
    ```
- **DELETE /livros/{id}**: Remover um livro por ID.
