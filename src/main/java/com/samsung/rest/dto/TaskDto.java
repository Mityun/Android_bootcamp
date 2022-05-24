package com.samsung.rest.dto;

import com.samsung.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private int id;

    private String name;

    private AuthorDto authorDto;

    private ImportanceDto importanceDto;

    public static TaskDto toDto(Task task){

        return new TaskDto(
                task.getId(),
                task.getName(),
                AuthorDto.toDto(task.getAuthor()),
                ImportanceDto.toDto(task.getImportance())
                );
    }
}
