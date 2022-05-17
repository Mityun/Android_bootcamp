package com.samsung.service;

import com.samsung.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment insert(Comment comment);

    List<Comment> getAll();

    List <Comment> getByTaskId(int taskId);

    Comment update(int id, String content);

    void deleteById(int id);
}
