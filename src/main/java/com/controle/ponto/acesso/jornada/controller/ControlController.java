package com.controle.ponto.acesso.jornada.controller;

import com.controle.ponto.acesso.dto.request.JornadaDTO;
import com.controle.ponto.acesso.dto.response.MessageResponseDTO;
import com.controle.ponto.acesso.jornada.service.impl.JornadaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ControlController {

    private JornadaService jornadaService;

    @PostMapping(value = "/jornada")
    public MessageResponseDTO createJornadaTrabalho(@Valid @RequestBody JornadaDTO jornadaDTO) {
        return this.jornadaService.createJornada(jornadaDTO);
    }

    @GetMapping(value = "/jornada")
    public List<JornadaDTO> listJornadaTrabalho() {
        return this.jornadaService.listJornada();
    }

    @GetMapping(value = "/jornada/{id}")
    public JornadaDTO getJornadaTrabalhoId(@PathVariable Long id) {
        return this.jornadaService.getJornadaById(id);
    }

    @PutMapping(value = "/jornada/{id}")
    public MessageResponseDTO updateJornadaTrabalhoId(@PathVariable Long id,
                                                      @Valid @RequestBody JornadaDTO jornadaDTO) {
        return this.jornadaService.updateJornadaById(id, jornadaDTO);
    }

    @DeleteMapping(value = "/jornada/{id}")
    public MessageResponseDTO deleteJornadaTrabalhoId(@PathVariable Long id) {
        return this.jornadaService.deleteJornadaById(id);
    }
}
