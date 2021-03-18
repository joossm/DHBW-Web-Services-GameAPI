package com.project.cocktailcloud;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GameNoContentAdvice {

    @ResponseBody
    @ExceptionHandler(GameNoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String gameNotFoundHandler(GameNoContentException e) {
        return e.getMessage();
    }
}