package com.zosh.controllers;

import com.zosh.modal.ApiResponse;
import com.zosh.modal.Todo;
import com.zosh.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) throws Exception {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) throws Exception {
        return todoService.updateTodo(id, todo);
    }

//    @PutMapping("/{id}")
//    public Todo updateTodoStatus(@PathVariable Long id) throws Exception {
//        return todoService.updateStatus(id);
//    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        ApiResponse res=new ApiResponse();
        res.setMessage("todo deleted successfully");
        res.setStatus(true);
        return res;
    }
}
