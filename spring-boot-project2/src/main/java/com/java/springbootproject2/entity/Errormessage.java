package com.java.springbootproject2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Errormessage {
    private HttpStatus status;
    private String message;
}
