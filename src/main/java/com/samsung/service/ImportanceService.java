package com.samsung.service;

import com.samsung.domain.Importance;

import java.util.List;

public interface ImportanceService {

    Importance insert(String name);

    List<Importance> getAll();

    Importance getById(int id);

    Importance getByName(String name);

    Importance update(int id, String name);

    void deleteById(int id);
}
