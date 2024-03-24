package com.br.logspadronizado.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder @Data
public class LogRequest {
    public String nome;
    private int idade;
}
