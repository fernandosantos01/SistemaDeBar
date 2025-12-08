# 🍻 Sistema Bar - Backend

Este é o **backend** do Sistema de Gestão para Bares, responsável por gerenciar produtos, pedidos e demais operações do sistema. Ele funciona como API REST e foi desenvolvido para integrar-se ao frontend disponível em repositório separado.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web** (API REST)
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (ou outro banco relacional configurado)
- **Maven** como gerenciador de dependências

---

## 📦 Funcionalidades

### 🔧 Produtos

- Criar, editar, listar e excluir produtos (CRUD completo)
- Associação com preços e categorias (se houver)

### 🧾 Pedidos

- Criação de pedidos
- Atualização de status
- Listagem e consulta

### 🧩 Outras Funcionalidades

- Comunicação via JSON
- Respostas padronizadas
- Tratamento básico de exceções

---

## 📁 Estrutura do Projeto

```
sistema-bar-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.sistemabar/
│   │   │       ├── controllers/    # Controladores REST
│   │   │       ├── services/       # Regra de negócio
│   │   │       ├── repositories/   # Acesso ao banco
│   │   │       └── models/         # Entidades JPA
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql (opcional)
└── pom.xml
```

---

## 🔗 Repositório do Frontend

O frontend deste sistema está disponível em: [**https://github.com/fernandosantos01/sistema-bar-front**](https://github.com/fernandosantos01/sistema-bar-front)

É recomendado iniciar o backend antes do frontend para que as funcionalidades dependentes da API funcionem corretamente.

---

## 🛠️ Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/fernandosantos01/sistema-bar-backend.git
```

### 2. Acesse a pasta

```bash
cd sistema-bar-backend
```

### 3. Configure o banco de dados

Edite o arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistemabar
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Execute o projeto

Via Maven:

```bash
mvn spring-boot:run
```

Ou via sua IDE (IntelliJ, Eclipse).

### 5. A API estará disponível em:

```
http://localhost:8080
```

---

## 📌 Principais Endpoints

### Produtos

- `GET /produtos` — Lista todos os produtos
- `POST /produtos` — Cria novo produto
- `PUT /produtos/{id}` — Atualiza
- `DELETE /produtos/{id}` — Exclui

### Pedidos

- `GET /pedidos`
- `POST /pedidos`
- `PUT /pedidos/{id}`

> Os endpoints podem variar dependendo da versão atual do projeto.

---

## 🔧 Melhorias Futuras

- Relatórios PDF
- WebSocket para pedidos em tempo real
- Testes unitários e de integração

---

## 🤝 Contribuição

1. Faça um fork
2. Crie uma branch (`feature/nova-feature`)
3. Commit (`git commit -m "feat: descrição"`)
4. Push (`git push origin feature/nova-feature`)
5. Abra um PR

---

## 📄 Licença

Projeto licenciado sob **MIT License**.

---

## 👨‍💻 Autor

**José Fernando** — Desenvolvedor do projeto.

