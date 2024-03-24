package com.br.logspadronizado.controller.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class ErroException {
    public String menssagem;
    public String status;
}
