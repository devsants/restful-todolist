package br.devsants.todo.controller;

import br.devsants.todo.entity.TodoEntity;
import br.devsants.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<TodoEntity> create(@RequestBody TodoEntity todoEntity) {
        todoService.create(todoEntity);
        return todoService.list();
    }

    @GetMapping
    public List<TodoEntity> list() {
        return todoService.list();
    }

    @PutMapping
    public List<TodoEntity> update(@RequestBody TodoEntity todoEntity) {
        return todoService.update(todoEntity);
    }

    @DeleteMapping("/delete/{id}")
    public List<TodoEntity> delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return todoService.list();
    }

}
