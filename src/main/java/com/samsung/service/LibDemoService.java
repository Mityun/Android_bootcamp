package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.Comment;
import com.samsung.domain.Task;
import com.samsung.repository.AuthorRepository;
import com.samsung.repository.CommentRepository;
import com.samsung.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorService authorService;

    private final ImportanceService importanceService;

    private final TaskService taskService;


    private final CommentRepository commentRepository;

    public void authorDemo() {

        List<Author> authorList = authorService.getAll();

        System.out.println("==========");
        for (Author author : authorList) {

            System.out.println(author);
        }
        System.out.println("==========");



        authorService.update(1, "Ivan");
        authorList = authorService.getAll();

        System.out.println("==========");
        for (Author author1 : authorList) {

            System.out.println(author1);
        }
        System.out.println("==========");

    }

    @Transactional
    public void taskDemo() {

        List<Task> taskList = taskService.getAll();

        for (Task task : taskList) {

            System.out.println(task.getName() + ":");
            System.out.println(task.getAuthor().getName() + "," + task.getImportance().getName());

            List<Comment> commentList = task.getCommentList();

            for (Comment comment : commentList) {
                System.out.println(comment.getContent());
            }
        }

        taskService.insert(
                "Org name 4",
                "Author 4",
                "Importance high"
                );

        System.out.println("=====================");
        taskList = taskService.getAll();
        for (Task task : taskList) {

            System.out.println(task.getName() + ":");
            System.out.println(task.getAuthor().getName() + "," + task.getImportance().getName());

            List<Comment> commentList = task.getCommentList();

            if (commentList != null) {
                for (Comment comment : commentList) {
                    System.out.println(comment.getContent());
                }
            }
        }
    }
    @Transactional
    public void commentDemo() {

//        commentRepository.updateCommentById(1, "ничего не понятно, но очень интересно");
//
//        List<Comment> commentList = commentRepository.findAll();
//
//        for (Comment comment : commentList) {
//
//            System.out.println(comment.getId() + " - " + comment.getContent());
//        }
//
//        commentList = commentRepository.findByTaskId(2);
//
//        for (Comment comment : commentList) {
//
//            System.out.println(comment.getId() + " - " + comment.getContent());
//
//        }
    }

}
