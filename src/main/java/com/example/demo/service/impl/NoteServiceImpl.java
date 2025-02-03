package com.example.demo.service.impl;

import com.example.demo.data.dao.NoteDao;
import com.example.demo.data.req.NoteRequest;
import com.example.demo.data.resp.APIResponse;
import com.example.demo.exceptions.NoteServiceException;
import com.example.demo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteDao noteDao;

    @Override
    public ResponseEntity<APIResponse> createNote(NoteRequest noteRequest){
        APIResponse apiResponse = new APIResponse();
       if(noteDao.noteExists(noteRequest)){
           throw new NoteServiceException("Note already exists!");
       }
       else{
           apiResponse.setService("NOTAPP"+ HttpStatus.OK.value());
           apiResponse.setData(noteRequest.getNote() + " " + noteRequest.getTitle());
           apiResponse.setMessage("Note created successfully");
           apiResponse.setStatus(HttpStatus.OK.value());
           apiResponse.setSuccess(true);

           noteDao.createUser(noteRequest);

           return ResponseEntity.ok().body(apiResponse);
       }
    }
}
