package com.br.logspadronizado.controller;

import com.br.logspadronizado.controller.dto.LogRequest;
import com.br.logspadronizado.controller.dto.LogResponse;
import com.br.logspadronizado.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogPadronizadoController {

    private final LogService logService;

    @GetMapping
    public String getLog(){
        MDC.put("correlationID", UUID.randomUUID().toString());

        log.info("Request Receive Controler");

        return logService.ok();
    }

    @PostMapping
    public LogResponse postLog(@RequestBody LogRequest request){
        log.info("Inicio Post Controler");
        MDC.put("request", request.toString());

        LogResponse response = logService.create(request);

        MDC.put("response", response.toString());

        log.info("Fim Post Controler");
        return ResponseEntity.ok(response).getBody();
    }
}
