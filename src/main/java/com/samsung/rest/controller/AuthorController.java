package com.samsung.rest.controller;

import com.samsung.domain.Author;
import com.samsung.rest.dto.AuthorDto;
import com.samsung.service.AuthorService;
import com.samsung.view.AuthorView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author")
    public List<AuthorDto> getAllAuthor(){

        return authorService
                .getAll()
                .stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/author")
    public AuthorDto insertAuthor(@RequestBody AuthorView authorView){

        Author author = authorService.insert(
                authorView.getName()
        );
        
        return AuthorDto.toDto(author);

    }

    @PutMapping("/author/{id}")
    public AuthorDto updateAuthor(
            @PathVariable int id,
            @RequestBody AuthorView authorView
    ){

        Author author = authorService.update(
                id,
                authorView.getName()
        );

        return AuthorDto.toDto(author);

    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable int id){

        authorService.deleteById(id);
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable int id){

        Author author = authorService.getById(id);

        return AuthorDto.toDto(author);
    }

    @PostMapping("/author/{id}/name")
    public AuthorDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return AuthorDto.toDto(
                authorService.update(id, name)
        );
    }

    @GetMapping("/author/name")
    public AuthorDto getAuthorByName(@RequestParam String name) {

        return AuthorDto.toDto(authorService.getByName(name));
    }

}

