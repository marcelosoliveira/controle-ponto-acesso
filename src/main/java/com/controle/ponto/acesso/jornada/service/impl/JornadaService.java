package com.controle.ponto.acesso.jornada.service.impl;

import com.controle.ponto.acesso.dto.request.JornadaDTO;
import com.controle.ponto.acesso.dto.response.MessageResponseDTO;
import com.controle.ponto.acesso.exception.ControlNotFoundException;
import com.controle.ponto.acesso.jornada.model.Jornada;
import com.controle.ponto.acesso.jornada.repository.JornadaRepository;
import com.controle.ponto.acesso.jornada.service.interfaces.JornadaInterface;
import com.controle.ponto.acesso.mapper.ControlMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JornadaService implements JornadaInterface {

    private JornadaRepository jornadaRepository;

    private final ControlMapper controlMapper = ControlMapper.INSTANCE;

    public MessageResponseDTO createJornada(JornadaDTO jornadaDTO) {
        Jornada jornada = controlMapper.toJornadaModel(jornadaDTO);
        this.jornadaRepository.save(jornada);
        return createMessageResponse("Descrção da jornada de trabalho criada com sucesso!");
    }

    public List<JornadaDTO> listJornada() {
        return this.jornadaRepository.findAll()
                .stream()
                .map(controlMapper::toJornadaDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO createMessageResponse(String message){
        return MessageResponseDTO
                .builder()
                .message(message)
                .build();
    }

    public JornadaDTO getJornadaById(Long id) {
        validExistId(id);
        Jornada jornada = this.jornadaRepository.getById(id);
        return controlMapper.toJornadaDTO(jornada);
    }

    public MessageResponseDTO updateJornadaById(Long id, JornadaDTO jornadaDTO) {
        validExistId(id);
        Jornada jornada = controlMapper.toJornadaModel(jornadaDTO);
        jornada.setId(id);
        this.jornadaRepository.save(jornada);
        return createMessageResponse("Descrção da jornada de trabalho atualizada com sucesso! ID: " + id);
    }

    public MessageResponseDTO deleteJornadaById(Long id) {
        validExistId(id);
        this.jornadaRepository.deleteById(id);
        return createMessageResponse("Descrção da jornada de trabalho deletada com sucesso! ID: " + id);
    }

    @Override
    public void validExistId(Long id) {
        this.jornadaRepository.findById(id).orElseThrow(
                () -> new ControlNotFoundException("Jornada não encontrada!"));
    }
}
