package com.optxt.notesapp.notesapp.repository;

import com.optxt.notesapp.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
