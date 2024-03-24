package com.br.logspadronizado.service;

import com.br.logspadronizado.controller.dto.LogRequest;
import com.br.logspadronizado.controller.dto.LogResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @Slf4j @Component
public class LogService {
    public LogResponse create(LogRequest request){
        return LogResponse.builder().codigo(UUID.randomUUID().toString()).build();
    }

    public String ok() {
        log.info("Create Service");
        return "create log server";
    }
}
