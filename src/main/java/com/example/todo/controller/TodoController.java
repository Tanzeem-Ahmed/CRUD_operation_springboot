package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos-app")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    @PostMapping("/add-todo")
    public void createTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    @GetMapping("find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id){
        return todoService.findById(id);
    }

    @GetMapping("find-all")
    public List<Todo> findAllTodo(){
        return todoService.findAll();
    }

    @PutMapping("update-todo/id/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id, todo);
    }

    @DeleteMapping("delete-todo/id/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }
}
