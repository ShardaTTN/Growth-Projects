package com.sharda.UserService.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserHandledException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private HttpStatus httpStatus;


    public UserHandledException(String errorMessage, HttpStatus httpStatus) {
        super();
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public UserHandledException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }
}
