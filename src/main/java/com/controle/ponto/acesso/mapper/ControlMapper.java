package com.controle.ponto.acesso.mapper;

import com.controle.ponto.acesso.dto.request.JornadaDTO;
import com.controle.ponto.acesso.jornadatrabalho.model.JornadaTrabalho;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ControlMapper {

    ControlMapper INSTANCE = Mappers.getMapper(ControlMapper.class);

    JornadaTrabalho toJornadaModel(JornadaDTO jornadaDTO);

    JornadaDTO toJornadaDTO(JornadaTrabalho jornadaTrabalho);
}
