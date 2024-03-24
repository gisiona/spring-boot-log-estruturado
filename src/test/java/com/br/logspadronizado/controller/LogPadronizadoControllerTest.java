package com.br.logspadronizado.controller;

import com.br.logspadronizado.controller.dto.LogRequest;
import com.br.logspadronizado.controller.dto.LogResponse;
import com.br.logspadronizado.service.LogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogPadronizadoControllerTest {

    @Mock
    private LogService logService;

    @InjectMocks
    private LogPadronizadoController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetLog() {
        when(logService.ok()).thenReturn("OK");
        String result = controller.getLog();
        assertEquals("OK", result);
        verify(logService, times(1)).ok();
    }

    @Test
    void testPostLog() {
        LogRequest request = LogRequest.builder().nome("teste log").build();

        LogResponse expectedResponse = LogResponse.builder().codigo(UUID.randomUUID().toString()).build();

        when(logService.create(request)).thenReturn(expectedResponse);

        LogResponse response = controller.postLog(request);

        assertEquals(expectedResponse, response);
        verify(logService, times(1)).create(request);

    }

}
