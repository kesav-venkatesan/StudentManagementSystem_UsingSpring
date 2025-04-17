package com.studentDB.demo.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.ACCEPTED)
public class StudentNotFound extends Exception {

    public StudentNotFound(String str){
        super(str);
    }
}
