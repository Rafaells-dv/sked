package com.gnbarbersop.scheduler.controller;

import com.gnbarbersop.scheduler.dto.ServicoDto;
import com.gnbarbersop.scheduler.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/create")
    public ResponseEntity<?> createService(@RequestBody ServicoDto dto) {
        servicoService.create(dto);
        return ResponseEntity.ok().build();
    }

}
