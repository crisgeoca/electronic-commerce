package es.inditex.commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotRecordFoundException extends NoSuchElementException {

    public NotRecordFoundException(String message) { super(message); }

}
