package com.niit.Content.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Content is not Present")
public class ContentNotFoundException extends Exception {
}
