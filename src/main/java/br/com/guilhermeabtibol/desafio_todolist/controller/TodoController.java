package br.com.guilhermeabtibol.desafio_todolist.controller; // aqui estamos definindo o pacote do controlador.

import br.com.guilhermeabtibol.desafio_todolist.entity.Todo; // importando a classe todo que vamos usar.
import br.com.guilhermeabtibol.desafio_todolist.service.TodoService; // importando o serviço que vai lidar com a logica das tarefas.
import jakarta.validation.Valid; // importando a anotacao para validar os dados.
import org.springframework.web.bind.annotation.*; // importando as anotações do spring para criar a api.

import java.util.List; // importando a lista para trabalhar com coleções.

@RestController // diz que essa classe é um controlador que vai responder a requisições http.
@RequestMapping("/todos") // define que todos os endpoints desse controlador vão começar com /todos.
public class TodoController { // comecando a definição da classe TodoController.
    private TodoService todoService; // criando uma variavel para o serviço de tarefas.

    // construtor que recebe o TodoService e inicializa a variavel.
    public TodoController(TodoService todoService) {
        this.todoService = todoService; // atribuindo o serviço recebido à variavel.
    }

    // endpoint para criar uma nova tarefa.
    @PostMapping() // diz que esse método vai responder a requisições POST.
    List<Todo> create (@RequestBody @Valid Todo todo) { // recebe um objeto todo do corpo da requisição e valida.
        return todoService.create(todo); // chama o serviço para criar a tarefa e retorna a lista de tarefas.
    }

    // endpoint para listar todas as tarefas.
    @GetMapping // diz que esse método vai responder a requisições GET.
    List<Todo> list() { // método que retorna a lista de tarefas.
        return todoService.list(); // chama o serviço para listar as tarefas.
    }

    // endpoint para atualizar uma tarefa existente.
    @PutMapping("{id}") // diz que esse método vai responder a requisições PUT e espera um id na URL.
    List<Todo> update(@RequestBody Todo todo) { // recebe o objeto todo do corpo da requisição.
        return todoService.update(todo); // chama o serviço para atualizar a tarefa e retorna a lista de tarefas.
    }

    // endpoint para remover uma tarefa.
    @DeleteMapping("{id}") // diz que esse método vai responder a requisições DELETE e espera um id na URL.
    List<Todo> delete(@PathVariable("id") Long id) { // pega o id da tarefa a ser removida da URL.
        return todoService.delete(id); // chama o serviço para deletar a tarefa e retorna a lista de tarefas.
    }
}