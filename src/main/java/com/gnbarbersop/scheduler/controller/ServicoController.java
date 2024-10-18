package com.gnbarbersop.scheduler.controller;

import com.gnbarbersop.scheduler.dto.ServicoDto;
import com.gnbarbersop.scheduler.entity.ServicoEntity;
import com.gnbarbersop.scheduler.service.ServicoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/admin/create")
    public ResponseEntity<?> createService(@RequestBody ServicoDto dto) {
        servicoService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllServices() {
        Collection<ServicoEntity> servicos = servicoService.getAll();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("")
    public ResponseEntity<?> getServiceById(@RequestParam String servicoId) {
        return ResponseEntity.ok(servicoService.getById(servicoId));
    }

    @PostMapping("/admin/update")
    public ResponseEntity<?> updateService(@RequestParam String servicoId, @RequestBody ServicoDto dto) {
        try {
            servicoService.update(dto, servicoId);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            JSONObject errorResponse = new JSONObject();
            errorResponse.put("Message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteServiceById(@RequestParam String servicoId) {
        servicoService.deleteById(servicoId);
        return ResponseEntity.ok().build();
    }
}
