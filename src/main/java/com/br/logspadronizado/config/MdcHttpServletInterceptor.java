package com.br.logspadronizado.config;
import com.br.logspadronizado.util.UtilCommon;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;

@Component @Slf4j
public class MdcHttpServletInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            log.info("Iniciando o processamento");
            MDC.put("correlationID", UtilCommon.getCorrelationId(request));
            MDC.put("timestamp_start", UtilCommon.getInstantTime());
            MDC.put("headers", UtilCommon.getHeaders(request).toString());

        } catch (Exception ex) {
            log.error("Erro na execução do metodo preHandle");
        }

        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            MDC.put("timestamp_end", UtilCommon.getLocalDateTime());
            MDC.put("status_code", UtilCommon.getStatusCode(response));
            MDC.put("status_request", UtilCommon.getStatusRequest(response));
            MDC.put("time_process", UtilCommon.calculateTimeProcess(Instant.parse(MDC.get("timestamp_start"))));
        } catch (Exception ex){
            log.error("Erro na execução do metodo postHandle");
        }

        log.info("Finalizado o processamento");
        MDC.clear();
    }
}