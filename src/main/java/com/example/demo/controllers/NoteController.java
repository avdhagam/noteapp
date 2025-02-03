package com.example.demo.controllers;

import com.example.demo.data.req.NoteRequest;
import com.example.demo.data.resp.APIResponse;
import com.example.demo.data.resp.NoteResponse;
import com.example.demo.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/note")
@RestController
@RequiredArgsConstructor //auto generates constructors for classes
@Validated
@Slf4j
public class NoteController {
    @Autowired
    NoteService noteService;
    /* methods we can have for a note app -  create note, update note, delete
    , get one note by id, get all notes by id
     */

    @PostMapping
    public ResponseEntity<APIResponse> createNote(@Valid @RequestBody NoteRequest noteRequest){
        log.info("[createNote] NoteRequest {}", noteRequest);
        return noteService.createNote(noteRequest);
    }


}
