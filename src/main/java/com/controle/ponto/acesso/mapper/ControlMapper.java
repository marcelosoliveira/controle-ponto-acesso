package com.controle.ponto.acesso.mapper;

import com.controle.ponto.acesso.dto.request.JornadaDTO;
import com.controle.ponto.acesso.jornada.model.Jornada;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ControlMapper {

    ControlMapper INSTANCE = Mappers.getMapper(ControlMapper.class);

    Jornada toJornadaModel(JornadaDTO jornadaDTO);

    JornadaDTO toJornadaDTO(Jornada jornada);
}
