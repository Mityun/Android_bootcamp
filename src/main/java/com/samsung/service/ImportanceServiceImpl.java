package com.samsung.service;

import com.samsung.domain.Importance;
import com.samsung.repository.ImportanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImportanceServiceImpl implements ImportanceService{

    private final ImportanceRepository importanceRepository;

    @Override
    public Importance insert(Importance importance) {
        //проверка на корректность данных

        return importanceRepository.save(importance);
    }

    @Override
    public List<Importance> getAll() {

        return importanceRepository.findAll();
    }

    @Override
    public Importance getById(int id) {
        return importanceRepository.getById(id);
    }

    @Override
    public Importance getByName(String name) {
        return importanceRepository.findByName(name);
    }

    @Override
    public Importance update(int id, String nameImportance) {

        Importance importance = Importance.builder()
                .id(id)
                .name(nameImportance)
                .build();

        return importanceRepository.save(importance);
    }

    @Override
    public void deleteById(int id) {

        importanceRepository.deleteById(id);

    }
}
