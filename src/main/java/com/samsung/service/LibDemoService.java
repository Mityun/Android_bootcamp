package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.Comment;
import com.samsung.domain.Task;
import com.samsung.repository.AuthorRepository;
import com.samsung.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorRepository authorRepository;

    private final TaskRepository taskRepository;

    public void authorDemo(){

        List<Author> authorList = authorRepository.findAll();

        System.out.println("==========");
        for (Author author : authorList) {

            System.out.println(author);
        }
        System.out.println("==========");

        Author author = Author.builder()
                .name("Borys")
                .build();

        authorRepository.save(author);
        authorList = authorRepository.findAll();

        System.out.println("==========");
        for (Author author1 : authorList) {

            System.out.println(author1);
        }
        System.out.println("==========");
    }

    @Transactional
    public void taskDemo(){

        List<Task> taskList = taskRepository.findAll();

        for(Task task : taskList){

            System.out.println(task.getName()+":");
            System.out.println(task.getAuthor().getName()+ "," + task.getImportance().getCoef());

            List<Comment> commentList = task.getCommentList();

            for (Comment comment : commentList){
                System.out.println(comment.getContent());
            }

        }
    }

}
