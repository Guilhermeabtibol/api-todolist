#### README.md

# API Todo List

Uma API RESTful para gerenciar uma lista de tarefas (todos). Esta API permite que os usuários criem, leiam, atualizem e excluam tarefas.

## Índice

- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints](#endpoints)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## Instalação

Para instalar e executar a API, siga os passos abaixo:

1. Clone o repositório:

   ```bash
   git clone https://github.com/Guilhermeabtibol/api-todolist.git
   cd api-todolist
   ```

2. Certifique-se de ter o Java e o Maven instalados em sua máquina.

3. Compile o projeto:

   ```bash
   mvn clean install
   ```

4. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

## Uso

A API está disponível em `http://localhost:8080`. Você pode usar ferramentas como Postman ou cURL para interagir com a API.

### Exemplo de Requisições

- **Criar uma nova tarefa**:

   ```http
   POST /todos
   Content-Type: application/json

   {
       "nome": "Minha nova tarefa",
       "descricao": "Descrição da tarefa",
       "prioridade": 1,
       "realizado": false
   }
   ```

- **Listar todas as tarefas**:

   ```http
   GET /todos
   ```

- **Atualizar uma tarefa**:

   ```http
   PUT /todos/{id}
   Content-Type: application/json

   {
       "nome": "Tarefa atualizada",
       "descricao": "Nova descrição",
       "prioridade": 2,
       "realizado": true
   }
   ```

- **Excluir uma tarefa**:

   ```http
   DELETE /todos/{id}
   ```

## Endpoints

| Método | Endpoint         | Descrição                          |
|--------|------------------|------------------------------------|
| POST   | /todos           | Cria uma nova tarefa               |
| GET    | /todos           | Lista todas as tarefas             |
| PUT    | /todos/{id}      | Atualiza uma tarefa existente      |
| DELETE | /todos/{id}      | Exclui uma tarefa                  |

## Contribuição

Contribuições são bem-vindas! Para contribuir, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`).
3. Faça suas alterações e commit (`git commit -m 'Adiciona nova funcionalidade'`).
4. Envie para o repositório remoto (`git push origin feature/nova-funcionalidade`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Guilherme Abtibol - [guiabtibol@gmail.com](mailto:guilhermeabtibol@gmail.com)

Link do projeto: [https://github.com/Guilhermeabtibol/api-todolist](https://github.com/Guilhermeabtibol/api-todolist)
```

### Considerações Finais

- **Personalização**: Sinta-se à vontade para personalizar a documentação com informações específicas sobre o seu projeto, como dependências, configurações adicionais, ou detalhes sobre a arquitetura.
- **Exemplos de Uso**: Adicione mais exemplos de uso, se necessário, para ajudar os usuários a entender como interagir com a API.
- **Testes**: Se houver testes automatizados, considere adicionar uma seção sobre como executá-los.

Se você precisar de mais informações ou ajustes específicos, sinta-se à vontade para perguntar!
