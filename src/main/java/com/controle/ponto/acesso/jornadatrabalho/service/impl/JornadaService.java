package com.controle.ponto.acesso.jornadatrabalho.service.impl;

import com.controle.ponto.acesso.dto.request.JornadaDTO;
import com.controle.ponto.acesso.dto.response.MessageResponseDTO;
import com.controle.ponto.acesso.exception.ControlNotFoundException;
import com.controle.ponto.acesso.jornadatrabalho.model.JornadaTrabalho;
import com.controle.ponto.acesso.jornadatrabalho.repository.JornadaRepository;
import com.controle.ponto.acesso.jornadatrabalho.service.interfaces.JornadaInterface;
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
        JornadaTrabalho jornadaTrabalho = controlMapper.toJornadaModel(jornadaDTO);
        this.jornadaRepository.save(jornadaTrabalho);
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
        JornadaTrabalho jornadaTrabalho = this.jornadaRepository.getById(id);
        return controlMapper.toJornadaDTO(jornadaTrabalho);
    }

    public MessageResponseDTO updateJornadaById(Long id, JornadaDTO jornadaDTO) {
        validExistId(id);
        JornadaTrabalho jornadaTrabalho = controlMapper.toJornadaModel(jornadaDTO);
        jornadaTrabalho.setId(id);
        this.jornadaRepository.save(jornadaTrabalho);
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
