package com.samsung.rest.controller;


import com.samsung.domain.Author;
import com.samsung.domain.Importance;
import com.samsung.domain.Task;
import com.samsung.rest.dto.TaskDto;
import com.samsung.service.AuthorService;
import com.samsung.service.ImportanceService;
import com.samsung.service.TaskService;
import com.samsung.view.TaskView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    private final AuthorService authorService;

    private final ImportanceService importanceService;

    @PostMapping("/task")
    public TaskDto createNewTask(
            @RequestParam String nameTask,
            @RequestParam String nameImportance,
            @RequestParam String nameAuthor
    ) {

        Task task = taskService.insert(nameTask, nameImportance, nameAuthor);
        return TaskDto.toDto(task);
    }

    @GetMapping("/task")
    public List<TaskDto> getAllTasks() {

        return taskService
                .getAll()
                .stream()
                .map(TaskDto::toDto)
                .collect(Collectors.toList());
    }


    @PutMapping("/task/{id}")
    public TaskDto updateTaskById(
            @PathVariable int id,
            @RequestBody TaskView taskView
            ) {
        Task task = taskService.update(
                id,
                taskView.getName(),
                taskView.getImportanceId(),
                taskView.getAuthorId()
        );

        return TaskDto.toDto(task);
    }

    @GetMapping("/task/{id}")
    public TaskDto getTaskById(@PathVariable int id) {

        return TaskDto.toDto(taskService.getById(id));
    }

//    @GetMapping("/task/name")
//    public TaskDto getTaskByName(@RequestParam String name) {
//
//        return TaskDto.toDto(taskService.getByName(name));
//    }

    @DeleteMapping("/task/{id}")
    public void deleteTaskById(@PathVariable int id) {

        taskService.deleteById(id);
    }

}

