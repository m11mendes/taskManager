package com.example.tm.service;

import com.example.tm.dto.TaskDto;

import java.util.List;

public interface TaskService {

    public TaskDto createTask(TaskDto dto);

    public TaskDto getTaskById(Long id);

    public List<TaskDto> getAllTasks();

    public TaskDto updateTask(Long taskId, TaskDto taskDto);

    public void deleteTask(Long id);

}
