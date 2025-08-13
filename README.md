# 🧪 Testes Automatizados com Selenium – Projeto de Leilões

Este repositório contém testes automatizados desenvolvidos para validar o fluxo de um sistema de leilões.  
A implementação dos testes utiliza **Java**, **JUnit 5** e **Selenium WebDriver**, aplicando boas práticas de automação e padrões de projeto.

## 🚀 Tecnologias Utilizadas

- **Java 11+**
- **JUnit 5** – framework de testes
- **Selenium WebDriver** – automação de interface
- **ChromeDriver** – execução dos testes no navegador Google Chrome

## 📐 Padrões de Projeto Utilizados

### 1. **Page Object Pattern**
Organiza o código separando a lógica de interação com a interface em classes que representam páginas ou componentes do sistema.  
Benefícios:
- Reutilização de código
- Facilidade de manutenção
- Leitura mais clara dos testes

**Exemplo de classes Page Object no projeto:**
- `LoginPage` – responsável pela autenticação
- `ListaDeLeiloesPage` – página de listagem de leilões
- `CadastroLeilaoPage` – formulário de criação de leilão

### 2. **Encapsulamento de Ações**
As interações com elementos da página (cliques, preenchimento de campos, verificações) são encapsuladas nos métodos das páginas, evitando repetição nos testes.

### 3. **Organização por Pacotes**
- `br.com.alura.login` → testes e page objects relacionados à autenticação
- `br.com.alura.leiloes` → testes e page objects do módulo de leilões

## 🧪 Estrutura dos Testes

📂 `src/test/java`  
```
├── br.com.alura.login
│   ├── LoginPage.java       # Page Object para tela de login
│   └── LoginTest.java       # Testes de login
└── br.com.alura.leiloes
    ├── CadastroLeilaoPage.java   # Page Object para cadastro de leilões
    ├── ListaDeLeiloesPage.java   # Page Object para listagem
    └── LeiloesTest.java          # Testes de criação e visualização de leilões
```

## 🔍 Fluxos Testados

- Login com credenciais válidas e inválidas
- Cadastro de novos leilões
- Listagem e verificação de leilões cadastrados

## ▶️ Como Executar os Testes

1. **Clonar o repositório**
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

2. **Configurar o ChromeDriver**  
Baixar a versão compatível com seu Chrome e colocar no `PATH` do sistema.

3. **Executar os testes**
```bash
./mvnw test
```

Os testes serão executados em um navegador Chrome controlado pelo Selenium.

## 📄 Licença
Este projeto está licenciado sob a licença MIT.
