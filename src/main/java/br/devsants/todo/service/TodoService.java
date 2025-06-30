package br.devsants.todo.service;

import br.devsants.todo.entity.TodoEntity;
import br.devsants.todo.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoEntity> create(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
        return this.list();
    }

    public List<TodoEntity> list() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("title").ascending());
        return todoRepository.findAll(sort);
    }

    public List<TodoEntity> update(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
        return this.list();
    }

    public List<TodoEntity> delete(Long id) {
        todoRepository.deleteById(id);
        return this.list();
    }
}
