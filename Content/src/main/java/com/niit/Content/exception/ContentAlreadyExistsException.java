package com.niit.Content.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Content is already Present")

public class ContentAlreadyExistsException extends Exception{
}
