package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public Author insert(String name) {

        Author author = Author.builder()
                .name(name)
                .build();

        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {

        return authorRepository.getById(id);
    }

    @Override
    public Author getByName(String name) {

        return authorRepository.findByName(name);
    }

    @Override
    public Author update(int id, String name) {

        Author author = Author.builder()
                .id(id)
                .name(name)
                .build();

        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {

        authorRepository.deleteById(id);

    }
}
