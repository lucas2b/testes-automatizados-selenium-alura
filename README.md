# 🏷️ Sistema de Leilões — Spring Boot

Aplicação web desenvolvida em **Java** com **Spring Boot** para gerenciamento de leilões online.  
Permite cadastro, listagem e acompanhamento de leilões, com sistema de login, controle de lances e interface web responsiva.

---

## ✨ Funcionalidades

- 🔒 **Autenticação e autorização** com Spring Security  
- 📜 **Cadastro e listagem de leilões** com formulários validados  
- 💸 **Registro de lances** e atualização da lista de participantes  
- 🖥️ **Interface web responsiva** utilizando HTML + Bootstrap  
- 🗄️ **Banco de dados pré-configurado** com script `data.sql`  

---

## 📂 Estrutura do Projeto

```
src/main/java/br/com/alura/leilao
├── controller/       # Controllers da aplicação
├── dto/              # Objetos de transferência de dados
├── model/            # Entidades JPA
├── repositories/     # Repositórios Spring Data JPA
├── security/         # Configurações de autenticação e autorização
├── service/          # Serviços de negócio
src/main/resources
├── templates/        # Páginas HTML (Thymeleaf)
├── static/css/       # Arquivos de estilo (Bootstrap)
├── application.properties
└── data.sql
```

---

## 🛠 Tecnologias Utilizadas

- ☕ Java  
- 🚀 Spring Boot  
- 🔐 Spring Security  
- 🗃️ Spring Data JPA  
- 🎨 Thymeleaf + Bootstrap  
- 🧪 JUnit  

---

## ▶️ Como Executar

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seuusuario/seurepositorio.git
   ```

2. **Entre na pasta do projeto**
   ```bash
   cd seurepositorio
   ```

3. **Execute o projeto**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse no navegador**
   ```
   http://localhost:8080
   ```

---

## 🧪 Testes Automatizados

O projeto inclui testes de integração e de interface (UI) utilizando Selenium e JUnit para validar as principais funcionalidades do sistema.

---

## 📜 Licença

Este projeto é distribuído sob a licença MIT.  
Sinta-se livre para usar, modificar e compartilhar.

---
