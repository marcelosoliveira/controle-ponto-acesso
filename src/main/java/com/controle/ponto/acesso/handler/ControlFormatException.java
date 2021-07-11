package com.controle.ponto.acesso.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControlFormatException {

    private String title;
    private Integer status;
    private LocalDateTime dateTime;
    private List<Field> fields;

    @AllArgsConstructor
    @Getter
    public static class Field {
        private String field;
        private String message;
    }

}
