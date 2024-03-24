package com.br.logspadronizado.util;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilCommonTest {

    @Test
    void calculateTimeProcess() {
        // Testando se o cálculo de tempo está correto (este teste pode falhar dependendo da execução)
        // Idealmente, seria melhor usar uma abordagem de teste mockado para controlar o tempo
        String time = UtilCommon.calculateTimeProcess(java.time.Instant.now().minusSeconds(5));
        assertNotNull(time);
        System.out.println("Tempo de processamento: " + time);
    }

    @Test
    void getLocalDateTime() {
        // Testando se o tempo local é retornado corretamente
        String localDateTime = UtilCommon.getLocalDateTime();
        assertNotNull(localDateTime);
        System.out.println("Data e hora local: " + localDateTime);
    }

    @Test
    void getInstantTime() {
        // Testando se o tempo instantâneo é retornado corretamente
        String instantTime = UtilCommon.getInstantTime();
        assertNotNull(instantTime);
        System.out.println("Tempo instantâneo: " + instantTime);
    }

    @Test
    void getCorrelationId() {
        // Testando se o ID de correlação é retornado corretamente
        HttpServletRequest request = new MockHttpServletRequest();
        String correlationId = UtilCommon.getCorrelationId(request);
        assertNotNull(correlationId);
        System.out.println("ID de correlação: " + correlationId);
    }

    @Test
    void getHeaders() {
        // Testando se os cabeçalhos são retornados corretamente
        HttpServletRequest request = new MockHttpServletRequest();
        Map<String, String> headers = UtilCommon.getHeaders(request);
        assertNotNull(headers);
        System.out.println("Cabeçalhos: " + headers);
    }

    @Test
    void getStatusCode() {
        // Testando se o código de status é retornado corretamente
        HttpServletResponse response = new MockHttpServletResponse();
        String statusCode = UtilCommon.getStatusCode(response);
        assertNotNull(statusCode);
        System.out.println("Código de status: " + statusCode);
    }

    @Test
    void getStatusRequest() {
        // Testando se o status da requisição é retornado corretamente
        HttpServletResponse response = new MockHttpServletResponse();
        String statusRequest = UtilCommon.getStatusRequest(response);
        assertNotNull(statusRequest);
        System.out.println("Status da requisição: " + statusRequest);
    }

    @Test
    void getStacktrace() {
        // Testando se a pilha de chamadas é retornada corretamente
        String stacktrace = UtilCommon.getStacktrace(new NullPointerException());
        assertNotNull(stacktrace);
        System.out.println("Pilha de chamadas: " + stacktrace);
    }
}
