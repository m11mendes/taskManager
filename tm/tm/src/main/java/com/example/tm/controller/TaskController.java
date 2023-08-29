package com.example.tm.controller;

import com.example.tm.dto.TaskDto;
import com.example.tm.entity.Task;
import com.example.tm.enums.Status;
import com.example.tm.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto savedTask = taskService.createTask(taskDto);

        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {

        TaskDto task = taskService.getTaskById(id);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks () {

        List<TaskDto> taskDtos = taskService.getAllTasks();

        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask (@PathVariable("id") Long taskId, @RequestBody TaskDto taskDto) {

        TaskDto updatedTask = taskService.updateTask(taskId, taskDto);

        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask (@PathVariable("id") Long id) {
        taskService.deleteTask(id);

        return new ResponseEntity("Task deleted successfully!", HttpStatus.OK);
    }
}
