package com.samsung.rest.controller;

import com.samsung.domain.Importance;
import com.samsung.rest.dto.ImportanceDto;
import com.samsung.service.ImportanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ImportanceController {

    private final ImportanceService importanceService;

    @GetMapping("/importance")
    public List<ImportanceDto> getAllImportance(){

        return importanceService
                .getAll()
                .stream()
                .map(ImportanceDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/importance")
    public ImportanceDto insertImportance(@RequestBody ImportanceDto importanceDto){

        Importance importance = importanceService.insert(ImportanceDto.toDomainObject(importanceDto));
        return ImportanceDto.toDto(importance);

    }

    @PutMapping("/importance/{id}")
    public ImportanceDto updateImportance(@PathVariable int id,
                               @RequestParam String name){

        Importance importance = importanceService.update(id, name);
        return ImportanceDto.toDto(importance);

    }

    @DeleteMapping("/importance/{id}")
    public void deleteImportance(@PathVariable int id){

        importanceService.deleteById(id);
    }

    @GetMapping("/importance/{id}")
    public ImportanceDto getImportanceById(@PathVariable int id){

        Importance importance = importanceService.getById(id);

        return ImportanceDto.toDto(importance);
    }
}
