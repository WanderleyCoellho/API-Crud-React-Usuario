# API de Produtos em Spring Boot

Uma API RESTful simples para cadastro de produtos (CRUD), desenvolvida com Spring Boot como parte de um estudo inicial.

> 🚧 **Status:** Em Desenvolvimento 🚧

---

## 💻 Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

* **Java 17**
* **Spring Boot** (v3.x.x)
* **Maven** (Gerenciador de dependências)
* **Spring Web**: Para criação de endpoints RESTful.
* **Spring Data JPA**: Para persistência de dados.
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
* **Lombok**: Para reduzir código boilerplate (getters, setters, construtores).

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para rodar a aplicação localmente.

### Pré-requisitos

* Java JDK 17 (ou superior) instalado.
* Maven instalado (ou utilize o Maven Wrapper `mvnw`).
* Uma IDE (como IntelliJ ou VS Code) ou um cliente de API (como Postman ou Insomnia) para testar.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO_AQUI]
    cd minha-api
    ```

2.  **Execute a aplicação (via Maven):**
    ```bash
    ./mvnw spring-boot:run
    ```

3.  **Alternativa (via IDE):**
    * Importe o projeto como um projeto Maven na sua IDE.
    * Encontre a classe principal `MinhaApiApplication.java`.
    * Clique com o botão direito e selecione "Run".

A aplicação estará disponível em `http://localhost:8080`.

---

## 📊 Acesso ao Banco (H2 Console)

Este projeto utiliza um banco de dados H2 em memória. Você pode acessá-lo e visualizar as tabelas e dados diretamente pelo navegador:

1.  Abra a URL: `http://localhost:8080/h2-console`
2.  No campo **JDBC URL**, certifique-se de que está: `jdbc:h2:mem:testdb`
3.  **Username:** `sa`
4.  **Password:** (deixe em branco)
5.  Clique em "Connect".

---

## Endpoints da API

A URL base para todos os endpoints é `http://localhost:8080/api/produtos`.

| Método | Endpoint | Descrição | Exemplo de Body (JSON) |
| :--- | :--- | :--- | :--- |
| `POST` | `/` | Cria um novo produto | `{ "nome": "Notebook", "preco": 4500.0 }` |
| `GET` | `/` | Lista todos os produtos cadastrados | N/A |
| `GET` | `/{id}` | Busca um produto específico pelo ID | N/A |

*(Endpoints de `PUT` e `DELETE` a serem implementados)*