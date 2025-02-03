package com.example.demo.data.dao;

import com.example.demo.data.req.NoteRequest;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface NoteDao {
    void createUser(NoteRequest noteRequest);
    boolean noteExists(NoteRequest noteRequest);
}
