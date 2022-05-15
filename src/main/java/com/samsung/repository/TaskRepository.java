package com.samsung.repository;

import com.samsung.domain.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Override // переопределяем метод чтобы не грузить бд запросами
    @EntityGraph(attributePaths = {"author", "importance", "commentList"}) // вместо кучи запросов делаем один запрос и создаем одну большую таблицу
    List<Task> findAll();

}
