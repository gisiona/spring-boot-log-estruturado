package com.br.logspadronizado.controller;

import com.br.logspadronizado.controller.dto.LogRequest;
import com.br.logspadronizado.controller.dto.LogResponse;
import com.br.logspadronizado.service.LogService;
import com.br.logspadronizado.util.UtilCommon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LogPadronizadoController {

    private final LogService logService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String getLog(){
        log.info("Inicio Get Controler");

        return logService.ok();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LogResponse postLog(@RequestBody LogRequest request){
        log.info("Inicio Post Controler");
        MDC.put("request", UtilCommon.convertObjectString(request));

        LogResponse response = logService.create(request);

        MDC.put("response", UtilCommon.convertObjectString(response));

        log.info("Fim Post Controler");
        return ResponseEntity.ok(response).getBody();
    }
}
