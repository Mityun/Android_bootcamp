package com.samsung.rest.controller;

import com.samsung.domain.Importance;
import com.samsung.rest.dto.ImportanceDto;
import com.samsung.service.ImportanceService;
import com.samsung.view.ImportanceView;
import com.samsung.view.TaskView;
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
    public ImportanceDto insertImportance(@RequestBody ImportanceView importanceView){

        Importance importance = importanceService.insert(
                importanceView.getName()
        );

        return ImportanceDto.toDto(importance);
    }

    @PutMapping("/importance/{id}")
    public ImportanceDto updateImportance(@PathVariable int id,
                                          @RequestBody ImportanceView importanceView){

        Importance importance = importanceService.update(
                id,
                importanceView.getName()
        );

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
