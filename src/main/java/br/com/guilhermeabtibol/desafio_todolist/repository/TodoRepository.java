package br.com.guilhermeabtibol.desafio_todolist.repository;

import br.com.guilhermeabtibol.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
