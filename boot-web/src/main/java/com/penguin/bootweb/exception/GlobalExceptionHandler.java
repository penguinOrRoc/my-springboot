package com.penguin.bootweb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public String handlerArithException(){
        return  "myerror";

    }
}


