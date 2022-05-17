package com.samsung.rest.controller;


import com.samsung.rest.dto.TaskDto;
import com.samsung.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping("/task")
    public List <TaskDto> getAllTasks(){

        return taskService.getAll().stream().map(TaskDto::toDto).collect(Collectors.toList());
    }


}
