package com.samsung.rest.controller;

import com.samsung.domain.Comment;
import com.samsung.rest.dto.CommentDto;
import com.samsung.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public CommentDto createNewComment(
            @RequestParam String content,
            @RequestParam int taskId
    ) {

        Comment comment = commentService.insert(content, taskId);

        return CommentDto.tODto(comment);
    }

    @GetMapping("/comment")
    public List<CommentDto> getAllComments() {

        return commentService
                .getAll()
                .stream()
                .map(CommentDto::tODto)
                .collect(Collectors.toList());
    }

    @PostMapping("/comment/{id}/content")
    public void updateCommentById(
            @PathVariable int id,
            @RequestParam String content
    ) {

        commentService.update(id, content);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteCommentById(@PathVariable int id) {

        commentService.deleteById(id);
    }

    @GetMapping("/task/{id}/comment")
    public List<CommentDto> getCommentsByTaskId(@PathVariable int id) {

        return commentService
                .getByTaskId(id)
                .stream()
                .map(CommentDto::tODto)
                .collect(Collectors.toList());
    }
}
