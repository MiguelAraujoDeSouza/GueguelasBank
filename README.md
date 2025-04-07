# GueguelasBank

## Descrição
Esse projeto é um banco de dados para o sistema de gerenciamento de contas do banco GueguelasBank. O banco de dados foi projetado para armazenar informações sobre os usuários, contas e transações.

## Estrutura do Banco de Dados

```sql
-- Tabela BANK
CREATE TABLE bank (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    cpnj VARCHAR(20)
);

-- Tabela USER
CREATE TABLE "user" ( 
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
    CONSTRAINT fk_user_bank FOREIGN KEY (bank_id) REFERENCES bank(id) ON DELETE CASCADE
);
```
## Endpoints

### Todos os tipos disponiveis para o banco e usuário

## Usuario
### Criar um novo usuário
- **URL**: `/users`
- **Método**: `POST`
- **Corpo da Requisição**:
```json
{
    "name": "string",
    "email": "string",
    "cpf": "string",
    "password": "string",
    "phone": "string",
    "address": "string",
    "city": "string",
    "contry": "string"
}
```
- **Resposta**:
```json
{
    "id": 1,
    "name": "string",
    "email": "string",
    "cpf": "string",
    "password": "string",
    "phone": "string",
    "address": "string",
    "city": "string",
    "contry": "string"
}
```

### Listar todos os usuários
- **URL**: `/users`
- **Método**: `GET`
- **Resposta**:
```json
[
    {
        "id": 1,
        "name": "string",
        "email": "string",
        "cpf": "string",
        "password": "string",
        "phone": "string",
        "address": "string",
        "city": "string",
        "contry": "string"
    },
    {
        "id": 2,
        "name": "string",
        "email": "string",
        "cpf": "string",
        "password": "string",
        "phone": "string",
        "address": "string",
        "city": "string",
        "contry": "string"
    }
]
```

### Listar um usuário específico
- **URL**: `/users/{id}`
- **Método**: `GET`
- **Resposta**:
```json
{
    "id": 1,
    "name": "string",
    "email": "string",
    "cpf": "string",
    "password": "string",
    "phone": "string",
    "address": "string",
    "city": "string",
    "contry": "string"
}
```
### Atualizar um usuário
- **URL**: `/users/{id}`
- **Método**: `PUT`
- **Corpo da Requisição**:
```json
{
    "name": "string",
    "email": "string",
    "cpf": "string",
    "password": "string",
    "phone": "string",
    "address": "string",
    "city": "string",
    "contry": "string"
}
```

- **Resposta**:
```json
{
    "id": 1,
    "name": "string",
    "email": "string",
    "cpf": "string",
    "password": "string",
    "phone": "string",
    "address": "string",
    "city": "string",
    "contry": "string"
}
```

### Deletar um usuário
- **URL**: `/users/{id}`
- **Método**: `DELETE`
- **Resposta**:
```json
{
    "message": "Usuário deletado com sucesso"
}
```

## Banco

### Criar um novo banco
- **URL**: `/bank`
- **Método**: `POST`
- **Corpo da Requisição**:
```json
{
    "name": "string",
    "address": "string",
    "city": "string",
    "cpnj": "string"
}
```
- **Resposta**:
```json
{
    "id": 1,
    "name": "string",
    "address": "string",
    "city": "string",
    "cpnj": "string"
}
```
### Listar todos os bancos
- **URL**: `/bank`
- **Método**: `GET`
- **Resposta**:
```json
[
    {
        "id": 1,
        "name": "string",
        "address": "string",
        "city": "string",
        "cpnj": "string"
    },
    {
        "id": 2,
        "name": "string",
        "address": "string",
        "city": "string",
        "cpnj": "string"
    }
]
```
### Listar um banco específico
- **URL**: `/bank/{id}`
- **Método**: `GET`
- **Resposta**:
```json
{
    "id": 1,
    "name": "string",
    "address": "string",
    "city": "string",
    "cpnj": "string"
}
```
### Atualizar um banco
- **URL**: `/bank/{id}`
- **Método**: `PUT`
- **Corpo da Requisição**:
```json
{
    "name": "string",
    "address": "string",
    "city": "string",
    "cpnj": "string"
}
```
- **Resposta**:
```json
{
    "id": 1,
    "name": "string",
    "address": "string",
    "city": "string",
    "cpnj": "string"
}
```
### Deletar um banco
- **URL**: `/bank/{id}`
- **Método**: `DELETE`
```json
{
"message": "Banco deletado com sucesso"
}
```
