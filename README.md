# 📚 Projeto CRUD de Alunos e Cursos - Spring Boot

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais do **Spring Boot**, **Spring Data JPA** e **Hibernate**, implementando uma API REST simples para gerenciar **alunos** e **cursos**.  

O banco de dados utilizado é o **H2 Database**, que roda em memória, sendo ideal para testes e prototipagem.  
O consumo e teste dos endpoints foi realizado através do **Postman**, acessando a aplicação em `http://localhost:8080`.

---

## 🚀 Tecnologias Utilizadas
- **Java 17+**  
- **Spring Boot**  
- **Spring Data JPA**  
- **Hibernate**  
- **H2 Database (em memória)**  
- **Postman (para testes dos endpoints)**  

---

## 📌 Funcionalidades
A aplicação permite realizar operações **CRUD** (Create, Read, Update, Delete) tanto para **Alunos** quanto para **Cursos**, além de gerenciar o relacionamento entre eles.

### 🔹 Endpoints de Aluno
- `GET /alunos/{id}` → Busca um aluno por ID.  
- `POST /alunos` → Cria um novo aluno.  
- `PUT /alunos/{id}` → Atualiza os dados de um aluno existente.  
- `DELETE /alunos/{id}` → Remove um aluno pelo ID.  
- `POST /alunos/{alunoId}/cursos` → Adiciona um curso a um aluno.  
- `DELETE /alunos/{alunoId}/cursos` → Remove um curso de um aluno.  

#### 🧾 Exemplo de JSON para criar aluno
```json
{
  "primeiroNome": "João",
  "ultimoNome": "Silva",
  "dataNascimento": "2000-05-10",
  "cpf": "123.456.789-00",
  "genero": "Masculino",
  "email": "joao.silva@email.com",
  "cep": "12345-678",
  "pais": "Brasil",
  "rua": "Rua Exemplo",
  "bairro": "Centro",
  "numero": "100",
  "complemento": "Apto 202",
  "cidade": "Porto Alegre",
  "estado": "RS"
}
```

---

### 🔹 Endpoints de Curso
- `GET /cursos/{id}` → Busca um curso por ID.  
- `POST /cursos` → Cria um novo curso.  
- `PUT /cursos/{id}` → Atualiza os dados de um curso.  
- `DELETE /cursos/{id}` → Remove um curso pelo ID.  

#### 🧾 Exemplo de JSON para criar curso
```json
{
  "nome": "Programação Orientada a Objetos",
  "dataDeConclusao": "2025-12-15"
}
```

---

## 🗂️ Estrutura das Entidades

### 👤 Entidade `Aluno`
```java
private Long id;
private String primeiroNome;
private String ultimoNome;
private DataNascimento dataNascimento;
private Cpf cpf;
private String genero;
private Email email;
private String cep;
private String pais;
private String rua;
private String bairro;
private String numero;
private String complemento;
private String cidade;
private String estado;
```

### 📘 Entidade `Curso`
```java
private Long id;
private String nome;
private String dataDeConclusao;
```

---

## ⚙️ Como Executar o Projeto
1. Clone este repositório:  
   ```bash
   git clone <url-do-repositorio>
   ```
2. Abra o projeto em sua IDE (IntelliJ, Eclipse, VS Code).  
3. Execute a aplicação Spring Boot.  
4. Acesse os endpoints via Postman em:  
   ```
   http://localhost:8080/alunos
   http://localhost:8080/cursos
   ```

---

## 📝 Observações
- O projeto **não possui front-end** implementado, sendo focado exclusivamente no **back-end**.  
- Foi desenvolvido como exercício de prática em **Spring Boot**, servindo de base para futuros projetos mais complexos.  
- O **H2 Console** pode ser acessado em:
  ```
  http://localhost:8080/h2-console
  ```
  (Usuário e senha definidos no `application.properties`).

---

## ✅ Conclusão
Este projeto demonstra de forma prática a criação de uma API REST com **Spring Boot**, incluindo operações CRUD, mapeamento de entidades, e relacionamento entre **Alunos** e **Cursos**, utilizando o **H2 Database** para facilitar os testes.  

Ele serve como um ponto de partida para aplicações maiores e mais completas no ecossistema **Spring**.
