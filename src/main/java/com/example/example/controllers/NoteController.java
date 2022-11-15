package com.example.example.controllers;

import com.example.example.entities.NoteEntity;
import com.example.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity getNotes(@RequestParam Long userId) {
        try {
            Iterable<NoteEntity> notes = noteService.getAll(userId);
            return ResponseEntity.ok(notes);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createNote(
            @RequestParam Long userId,
            @RequestBody NoteEntity note
    ){
        try {
            NoteEntity newNote = noteService.createNote(note,userId);
            return ResponseEntity.ok(newNote);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity updateNote(@PathVariable Long noteId, @RequestBody NoteEntity note){
        try {
            NoteEntity newNote = noteService.updateNote(noteId,note);
            return ResponseEntity.ok(newNote);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
