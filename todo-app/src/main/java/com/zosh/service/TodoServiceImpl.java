package com.zosh.service;

import com.zosh.modal.Todo;
import com.zosh.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements  TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) throws Exception {
        return todoRepository.findById(id)
                .orElseThrow(() -> new Exception("Todo not found with id " + id));
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) throws Exception {
        Todo existingTodo = getTodoById(id);
        existingTodo.setTitle(todo.getTitle());

        existingTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(existingTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo updateStatus(Long id) throws Exception {
        Todo existingTodo = getTodoById(id);
        existingTodo.setCompleted(!existingTodo.isCompleted());
        return todoRepository.save(existingTodo);
    }
}
