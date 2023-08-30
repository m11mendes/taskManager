package com.example.tm.service.impl;

import com.example.tm.dto.TaskDto;
import com.example.tm.entity.Task;
import com.example.tm.exception.ResourceNotFoundException;
import com.example.tm.mapper.TaskMapper;
import com.example.tm.repository.TaskRepository;
import com.example.tm.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto dto) {

        Task task = TaskMapper.mapToTask(dto);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task does not exist with this id: " + id));

        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        List<TaskDto> taskDtos = new ArrayList<>();

        for (int i = 0; i < taskList.size(); i++) {
            taskDtos.add(TaskMapper.mapToTaskDto(taskList.get(i)));
        }

        return taskDtos;
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto taskDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task does not exist with this id: " + taskId));

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setDeadline(taskDto.getDeadline());
        task.setOwner(taskDto.getOwner());

        Task updatedTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task does not exist with this id: " + id));

        taskRepository.delete(task);
    }
}
