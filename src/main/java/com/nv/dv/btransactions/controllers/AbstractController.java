package com.nv.dv.btransactions.controllers;

import com.nv.dv.btransactions.domain.dto.ErrorResponseDTO;
import com.nv.dv.btransactions.exceptions.PriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public abstract class AbstractController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PriceNotFoundException.class})
    protected ResponseEntity<Object> handleCustomException(RuntimeException ex, WebRequest request) throws Exception {
        HttpStatus status = getStatus(ex);
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(status.value(), ex.getMessage());
        return handleExceptionInternal(ex, errorResponseDTO, new HttpHeaders(), status, request);
    }

    private HttpStatus getStatus(RuntimeException ex) {
        if (ex instanceof PriceNotFoundException) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) throws Exception {
        if (HttpStatus.NOT_FOUND.equals(status)) {
            log.error("Not found exception", ex);
        } else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            log.error(String.format("Internal server error, body: %s, request: %s", body, request), ex);
            return super.handleException(ex, request);
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
