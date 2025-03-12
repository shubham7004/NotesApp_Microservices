package com.optxt.notesapp.notesapp.api;


import com.optxt.notesapp.notesapp.model.Note;
import com.optxt.notesapp.notesapp.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.findAllNotes();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note) {
        return noteService.save(note);
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable long id) {
        return noteService.findNoteById(id);
    }
}

