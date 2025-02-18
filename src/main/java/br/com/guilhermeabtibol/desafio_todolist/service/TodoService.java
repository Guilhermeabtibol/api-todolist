package br.com.guilhermeabtibol.desafio_todolist.service; // aqui estamos definindo o pacote do serviço.

import br.com.guilhermeabtibol.desafio_todolist.entity.Todo; // importando a classe todo que vamos usar.
import br.com.guilhermeabtibol.desafio_todolist.repository.TodoRepository; // importando o repositório que vai lidar com o banco de dados.
import org.springframework.data.domain.Sort; // importando a classe para ordenar os resultados.
import org.springframework.stereotype.Service; // importando a anotação que diz que essa classe é um serviço.

import java.util.List; // importando a lista para trabalhar com coleções.

@Service // diz que essa classe é um serviço do spring.
public class TodoService { // comecando a definição da classe TodoService.

    private TodoRepository todoRepository; // criando uma variavel para o repositório de tarefas.

    // construtor que recebe o TodoRepository e inicializa a variavel.
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository; // atribuindo o repositório recebido à variavel.
    }

    // método para criar uma nova tarefa.
    public List<Todo> create(Todo todo){ // recebe um objeto todo.
        todoRepository.save(todo); // salva o todo no banco de dados.
        return list(); // retorna a lista atualizada de tarefas.
    }

    // método para listar todas as tarefas.
    public List<Todo> list(){ // método que retorna a lista de tarefas.
        Sort sort = Sort.by("prioridade").descending().and( // define a ordenação por prioridade decrescente e nome crescente.
                Sort.by("nome").ascending());
        return todoRepository.findAll(sort); // chama o repositório para buscar todas as tarefas ordenadas.
    }

    // método para atualizar uma tarefa existente.
    public List<Todo> update(Todo todo){ // recebe o objeto todo.
        todoRepository.save(todo); // salva o todo atualizado no banco de dados.
        return list(); // retorna a lista atualizada de tarefas.
    }

    // método para remover uma tarefa.
    public List<Todo> delete(Long id){ // recebe o id da tarefa a ser removida.
        todoRepository.deleteById(id); // chama o repositório para deletar a tarefa pelo id.
        return list(); // retorna a lista atualizada de tarefas.
    }
}