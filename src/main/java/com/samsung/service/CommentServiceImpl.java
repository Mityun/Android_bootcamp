package com.samsung.service;

import com.samsung.domain.Comment;
import com.samsung.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Override
    public Comment insert(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByTaskId(int taskId) {
        return commentRepository.findByTaskId(taskId);
    }

    @Override
    public Comment update(int id, String content) {

        return commentRepository.save(Comment.builder()
                .content(content)
                .id(id)
                .build());

    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }
}
