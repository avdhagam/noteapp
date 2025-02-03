package com.example.demo.data.repository;

import com.example.demo.data.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
    boolean existsNoteEntityByTitle(String title);
}
