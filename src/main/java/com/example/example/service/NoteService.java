package com.example.example.service;

import com.example.example.entities.NoteEntity;
import com.example.example.entities.UserEntity;
import com.example.example.repository.NoteRepository;
import com.example.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    public Iterable<NoteEntity> getAll(Long userId){
        return noteRepository.findAllByUserId(userId);
    }

    public NoteEntity createNote(NoteEntity note,Long userId){
        UserEntity user = userRepository.findById(userId).get();
        note.setUser(user);
        return noteRepository.save(note);
    }

    public NoteEntity updateNote(Long noteId, NoteEntity updatedNote) {
        NoteEntity note = noteRepository.findById(noteId).get();
        note.setTitle(updatedNote.getTitle());
        note.setDescription(updatedNote.getDescription());
        return noteRepository.save(note);
    }
}
