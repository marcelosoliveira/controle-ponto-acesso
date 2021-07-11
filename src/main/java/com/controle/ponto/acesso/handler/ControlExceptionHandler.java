package com.controle.ponto.acesso.handler;

import com.controle.ponto.acesso.exception.ControlNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class ControlExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ControlFormatException.Field> fields = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            fields.add(new ControlFormatException.Field(name, message));
        }

        ControlFormatException formatException = new ControlFormatException();
        formatException.setStatus(status.value());
        formatException.setDateTime(LocalDateTime.now());
        formatException.setTitle("Campos inválidos, por favor inserir campos válidos!");
        formatException.setFields(fields);

        return super.handleExceptionInternal(ex, formatException, headers, status, request);
    }

    @ExceptionHandler(ControlNotFoundException.class)
    public ResponseEntity<Object> handlerControlNotFoundException(ControlNotFoundException control,
                                                                  WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ControlFormatException formatException = new ControlFormatException();
        formatException.setTitle(control.getMessage());
        formatException.setStatus(status.value());
        formatException.setDateTime(LocalDateTime.now());

        return handleExceptionInternal(control, formatException, new HttpHeaders(), status, request);
    }
}
