package com.java.springbootproject2.error;

import com.java.springbootproject2.entity.Errormessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class Restresponseentityexceptionhandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Departmentnotfound.class)
    public ResponseEntity<Errormessage> departmentnotfound(Departmentnotfound exception, WebRequest request){
        Errormessage message=new Errormessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
