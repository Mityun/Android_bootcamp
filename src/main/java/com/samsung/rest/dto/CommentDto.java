package com.samsung.rest.dto;


import com.samsung.domain.Comment;
import com.samsung.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private int id;

    private String content;

    public static CommentDto tODto(Comment comment){

        return new CommentDto(
                comment.getId(),
                comment.getContent()
                );
    }

    public static Comment toDomainObject(CommentDto commentDto, Task task){

        return new Comment(
                commentDto.getId(),
                commentDto.getContent(),
                task
        );
    }


}
