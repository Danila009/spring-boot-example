package com.example.example.repository;

import com.example.example.entities.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<NoteEntity, Long> {

    Iterable<NoteEntity> findAllByUserId(Long userId);
}
