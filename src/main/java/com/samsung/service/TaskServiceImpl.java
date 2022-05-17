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
    public Task insert(String nameTask, String nameAuthor, String nameImportance) {

        Author author = authorRepository.findByName(nameAuthor);

        if (author == null){
            author = Author.builder()
                    .name(nameAuthor)
                    .build();
        }

        Importance importance = importanceRepository.findByName(nameImportance);

        if (importance == null){

            importance = Importance.builder()
                    .name(nameImportance)
                    .build();
        }

        Task task = Task.builder()
                .name(nameTask)
                .author(author)
                .importance(importance)

                .build();
        return taskRepository.save(task);
    }

    @Override
    public Task update(int id, String nameTask, String nameAuthor, String nameImportance) {
        return null;
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
