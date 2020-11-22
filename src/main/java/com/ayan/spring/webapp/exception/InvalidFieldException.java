package com.ayan.spring.webapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidFieldException extends RuntimeException {

    private String message;
}
