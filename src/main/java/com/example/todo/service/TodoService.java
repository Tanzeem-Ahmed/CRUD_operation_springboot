package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int count = 0;

    static {
        todos.add(new Todo(++count, "Learn SpringBoot", false));
        todos.add(new Todo(++count, "Learn HTML", false));
        todos.add(new Todo(++count, "Learn CSS", false));
        todos.add(new Todo(++count, "Learn JS", false));
        todos.add(new Todo(++count, "Learn React", false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo findById(int id){
        for(Todo todo: todos){
            if(todo.getId() == id) return todo;
        }
        return null;
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public Todo deleteTodo(int id){
        for(Todo todo: todos){
            if(todo.getId() == id){
                todos.remove(id);
            }
        }
        return null;
    }

    public void updateTodo(int id, Todo newTodo){
        Todo todo = findById(id);

        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.isStatus());
    }
}
