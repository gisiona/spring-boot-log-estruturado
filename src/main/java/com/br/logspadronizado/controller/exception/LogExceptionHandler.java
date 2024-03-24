package com.br.logspadronizado.controller.exception;

import com.br.logspadronizado.util.UtilCommon;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class LogExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroException> handleException(Exception ex) {
        log.error("Erro interno no servidor: {}", ex.getMessage());
        ErroException exception = ErroException
                .builder()
                .menssagem("Ocorreu um erro interno no servidor. Por favor, tente novamente mais tarde.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        MDC.put("error_response", UtilCommon.convertObjectString(exception));

        log.error("Response Error: {}", exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception);
    }

    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<ErroException> handleException(MismatchedInputException ex) {
        log.error("Dados do payload invalido: {}", ex.getMessage());
        ErroException exception = ErroException
                .builder()
                .menssagem("O payload enviado está incorreto.")
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build();

        MDC.put("error_response", UtilCommon.convertObjectString(exception));

        log.error("Response Error: {}", exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception);
    }

}
