package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.Importance;
import com.samsung.domain.Task;
import com.samsung.repository.AuthorRepository;
import com.samsung.repository.ImportanceRepository;
import com.samsung.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final AuthorRepository authorRepository;

    private final ImportanceRepository importanceRepository;

    private final TaskRepository taskRepository;

    @Override
    public Task insert(String nameTask, int authorId, int importanceId, String description) {

        try {
            Author author = authorRepository.findById(authorId).orElseThrow(() -> new Exception());


            if (author == null) {
                author = Author.builder()
                        .name(author.getName())
                        .build();
            }

            Importance importance = importanceRepository.findById(importanceId).orElseThrow(() -> new Exception());

            if (importance == null) {

                importance = Importance.builder()
                        .name(importance.getName())
                        .build();
            }

            Task task = Task.builder()
                    .name(nameTask)
                    .author(author)
                    .importance(importance)
                    .description(description)
                    .build();
            return taskRepository.save(task);
        }
        catch (Exception e){

            return null;
        }
    }

    @Override
    public Task update(int id, String nameTask, int authorId, int importanceId, String description) {
        try {
            Author author = authorRepository.findById(authorId).orElseThrow(IllegalArgumentException::new);

            Importance importance = importanceRepository.findById(importanceId).orElseThrow(IllegalArgumentException::new);

            taskRepository.findById(id).orElseThrow(IllegalArgumentException::new);

            Task task = Task.builder()
                    .id(id)
                    .name(nameTask)
                    .author(author)
                    .importance(importance)
                    .description(description)
                    .build();
            return taskRepository.save(task);
        }
        catch (IllegalArgumentException iae){

            System.out.println(iae.getMessage() + " Несуществующий id.");
            throw iae;

        }
        catch (Exception e){

            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(int id) {
        return taskRepository.getById(id);
    }

    @Override
    public List <Task> getByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public void deleteById(int id) {

        taskRepository.deleteById(id);

    }
}
