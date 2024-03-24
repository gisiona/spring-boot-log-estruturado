package com.br.logspadronizado.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class UtilCommon {

    public static String calculateTimeProcess(Instant start) {
        return Duration.between(start, Instant.now()).toMillis() + " ms";
    }

    public static String getLocalDateTime() {
        return LocalDateTime.now().toString();
    }

    public static String getInstantTime() {
        return Instant.now().toString();
    }

    public static String getCorrelationId(HttpServletRequest request) {
        try {
            return Optional.ofNullable(request.getHeader("correlationID"))
                    .map(Object::toString)
                    .orElse(UUID.randomUUID().toString());
        } catch (Exception ex) {
            return UUID.randomUUID().toString();
        }
    }

    public static Map<String, String> getHeaders(HttpServletRequest request) {
        try {
            return Collections.list(request.getHeaderNames())
                    .stream()
                    .collect(Collectors.toMap(
                            headerName -> headerName,
                            request::getHeader
                    ));
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getStatusCode(HttpServletResponse response) {
        return String.valueOf(response.getStatus());
    }

    public static String getStatusRequest(HttpServletResponse response) {
        return  String.valueOf((((response.getStatus() == 200)
                || (response.getStatus() == 201))
                ? Boolean.TRUE
                : Boolean.FALSE));
    }

    public static String getStacktrace(Object response) {
        try {
            return response instanceof Throwable ? Arrays.toString(((Throwable) response).getStackTrace()) : null;
        } catch (Exception ex){
            return null;
        }
    }

    protected static Object getMessageStackTrace(Object response) {
        try {
            return response instanceof Throwable ? ((Throwable) response).getMessage() : response;
        } catch (Exception ex){
            return null;
        }
    }
}
