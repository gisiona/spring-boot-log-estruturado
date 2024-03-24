# spring-boot-log-estruturado
Projeto para exemplificar o uso de log estruturado e uso do O MDC (Mapped Diagnostic Context)

# Exemplo de como ficou o log estruturado
```json
{
  "timestamp": "2024-03-24T18:56:08.523-0300",
  "level": "INFO",
  "thread": "http-nio-8080-exec-2",
  "logger": "com.br.logspadronizado.config.MdcHttpServletInterceptor",
  "correlationID": "6fdd22e8-4ed4-46c2-a343-7122cba1e5f9",
  "exception": "",
  "request": "LogRequest(nome=gisiona, idade=0)",
  "response": "LogResponse(codigo=d7064a26-e6c4-462e-97f1-eaaf3fd99a1c)",
  "status_code": "200",
  "status_request": "true",
  "timestamp_start": "2024-03-24T21:56:08.350031800Z",
  "timestamp_end": "2024-03-24T18:56:08.468393900",
  "time_process": "173 ms",
  "headers": "{content-length=27, postman-token=17e4f762-7bde-47e1-9188-136b713743bb, host=localhost:8080, content-type=application/json, connection=keep-alive, cache-control=no-cache, accept-encoding=gzip, deflate, br, user-agent=PostmanRuntime/7.37.0, accept=*/*}",
  "message": "Finalizado o processamento"
}
```

# Endpoints disponíveis nessa api:

### POST: - postLog
Endpoint: http://localhost:8080/api

##### Dados de entrada
```json
{
  "nome": "Teste Log",
  "idade": 20
}
```

A aplicação deve responder com o seguinte retorno no modelo de informações:

##### Dados de saída
```json
{
  "codigo": "dd11c68c-c6d4-4825-9b1d-d15803f237b5"
}
```