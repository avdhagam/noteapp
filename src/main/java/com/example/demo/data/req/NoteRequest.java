package com.example.demo.data.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoteRequest {
    @Valid
    @NotBlank(message = "title cannot be blank")
    private String title;
    @NotBlank(message = "note cannot be blank")
    private String note;

}
