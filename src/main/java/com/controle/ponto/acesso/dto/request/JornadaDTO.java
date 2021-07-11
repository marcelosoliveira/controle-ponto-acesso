package com.controle.ponto.acesso.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JornadaDTO {

    @ApiModelProperty(hidden = true)
    private Long id;

    @Size(min = 2, max = 20, message = "O mínimo de caracteres é 2 e o máximo é 20!")
    @NotBlank(message = "Descrção da jornada não pode ser nula e nem vazia!")
    private String descricao;

}
