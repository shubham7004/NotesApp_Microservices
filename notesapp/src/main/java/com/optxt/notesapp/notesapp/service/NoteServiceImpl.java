package com.optxt.notesapp.notesapp.service;

import com.optxt.notesapp.notesapp.client.UserClient;
import com.optxt.notesapp.notesapp.model.Note;
import com.optxt.notesapp.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    //    private final RestTemplate restTemplate;
    private final UserClient userClient;

    public NoteServiceImpl(NoteRepository noteRepository, UserClient userClient) {
        this.noteRepository = noteRepository;
        this.userClient = userClient;
    }


    public Note save(Note note) {

//  Fetch the user from user-service
        //    var user = restTemplate.getForObject("http://localhost:8200/api/users/"+note.getUserId(), UserDTO.class);
        var user = userClient.getUserById(note.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }
        note.setCreatedAt(LocalDate.now());
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note findNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
