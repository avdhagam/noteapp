package com.example.demo.service;

import com.example.demo.data.req.NoteRequest;
import com.example.demo.data.resp.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {
    ResponseEntity<APIResponse> createNote(NoteRequest noteRequest);
}
