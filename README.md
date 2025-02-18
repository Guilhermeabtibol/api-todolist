# TODO List API

**@guiabtibol@gmail.com** 

**@guilhermeabtibol_**

Esta é uma API para gerenciar tarefas (CRUD) que faz parte do desafio para desenvolvedores backend júnior que se candidatam à Simplify. O projeto foi desenvolvido para fornecer uma solução simples e eficaz para o gerenciamento de tarefas.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring MVC**: Para a construção de APIs RESTful.
- **Spring Data JPA**: Para interação com o banco de dados.
- **SpringDoc OpenAPI 3**: Para documentação automática da API.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.

## Práticas Adotadas
- **SOLID**: Princípios de design para manter o código limpo e escalável.
- **DRY**: Não se repita, evitando duplicação de código.
- **YAGNI**: Você não vai precisar disso, evitando funcionalidades desnecessárias.
- **KISS**: Mantenha simples, evitando complexidade excessiva.
- **API REST**: Estrutura de comunicação baseada em recursos.
- **Consultas com Spring Data JPA**: Para facilitar a manipulação de dados.
- **Injeção de Dependências**: Para promover um código mais modular e testável.
- **Tratamento de Respostas de Erro**: Para fornecer feedback claro em caso de falhas.
- **Geração Automática do Swagger**: Com a OpenAPI 3 para documentação interativa.

## Como Executar
1. **Clonar o repositório Git**:
   ```bash
   git clone https://github.com/Guilhermeabtibol/api-todolist.git
   cd todolist
   ```

2. **Construir o projeto**:
   ```bash
   ./mvnw clean package
   ```

3. **Executar a aplicação**:
   ```bash
   java -jar target/todolist-0.0.1-SNAPSHOT.jar
   ```

A API poderá ser acessada em `localhost:8080`. O Swagger poderá ser visualizado em `localhost:8080/swagger-ui.html`, onde você pode interagir com a API de forma visual e testar os endpoints diretamente.

## API Endpoints
Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta **httpie**:

### Criar Tarefa
```bash
http POST :8080/todos nome="Todo 1" descricao="Desc Todo 1" prioridade=1
```
**Resposta**:
```json
[
  {
    "id": 1,
    "nome": "Todo 1",
    "descricao": "Desc Todo 1",
    "prioridade": 1,
    "realizado": false
  }
]
```

### Listar Tarefas
```bash
http GET :8080/todos
```
**Resposta**:
```json
[
  {
    "id": 1,
    "nome": "Todo 1",
    "descricao": "Desc Todo 1",
    "prioridade": 1,
    "realizado": false
  }
]
```

### Atualizar Tarefa
```bash
http PUT :8080/todos/1 nome="Todo 1 Atualizado" descricao="Desc Todo 1 Atualizada" prioridade=2
```
**Resposta**:
```json
[
  {
    "id": 1,
    "nome": "Todo 1 Atualizado",
    "descricao": "Desc Todo 1 Atualizada",
    "prioridade": 2,
    "realizado": false
  }
]
```

### Remover Tarefa
```bash
http DELETE :8080/todos/1
```
**Resposta**:
```json
{
  "message": "Tarefa removida com sucesso."
}
```

## Considerações Finais
Esta API foi projetada para ser simples e direta, permitindo que desenvolvedores iniciantes compreendam os conceitos básicos de construção de APIs RESTful com Spring Boot. Sinta-se à vontade para contribuir e melhorar o projeto!
