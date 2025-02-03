package com.example.demo.advice;

import com.example.demo.data.resp.APIResponse;
import com.example.demo.exceptions.NoteServiceException;
import com.example.demo.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(NoteServiceException.class)
    public ResponseEntity<APIResponse> handleUserServiceExceptions(NoteServiceException exception)
    {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        apiResponse.setSuccess(false);
        apiResponse.setMessage(exception.getMessage());
        apiResponse.setService("NOTEAPP-"+HttpStatus.OK.value());
        apiResponse.setData(null);
        return ResponseEntity.badRequest().body(apiResponse);
//        return errorMap;
    }

}
