package com.example.demo.data.dao.impl;

import com.example.demo.data.dao.NoteDao;
import com.example.demo.data.entities.NoteEntity;
import com.example.demo.data.repository.NoteRepository;
import com.example.demo.data.req.NoteRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImpl implements NoteDao {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public void createUser(NoteRequest noteRequest){
        ObjectMapper mapper =  new ObjectMapper();
        NoteEntity noteEntity = mapper.convertValue(noteRequest,NoteEntity.class);
        noteRepository.save(noteEntity);
    }
    @Override
    public boolean noteExists(NoteRequest noteRequest){
        return noteRepository.existsNoteEntityByTitle(noteRequest.getTitle());
    }
}
