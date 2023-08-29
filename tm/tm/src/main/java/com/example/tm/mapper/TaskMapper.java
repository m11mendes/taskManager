package com.example.tm.mapper;

import com.example.tm.dto.TaskDto;
import com.example.tm.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getStatus(),
                task.getDeadline(),
                task.getOwner()
        );
    }

    public static Task mapToTask(TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getStatus(),
                taskDto.getDeadline(),
                taskDto.getOwner()
        );
    }
}
