package com.zosh.service;

import com.zosh.modal.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id) throws Exception;
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id, Todo todo) throws Exception;
    void deleteTodo(Long id);

    Todo updateStatus(Long id) throws Exception;
}
