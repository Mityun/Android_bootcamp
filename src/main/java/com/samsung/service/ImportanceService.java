package com.samsung.service;

import com.samsung.domain.Importance;

import java.util.List;

public interface ImportanceService {

    Importance insert(Importance importance);

    List<Importance> getAll();

    Importance getById(int id);

    Importance getByName(String name);

    Importance update(int id, String nameImportance);

    void deleteById(int id);
}
