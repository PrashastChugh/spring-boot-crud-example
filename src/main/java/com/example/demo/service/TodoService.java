package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }

    public Todo update(Long id, Todo todo) {
        if (todoRepository.existsById(id)) {
            todo.setId(id);
            return todoRepository.save(todo);
        }
        return null;
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }


}
