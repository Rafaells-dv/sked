package com.gnbarbersop.scheduler.controller;


import com.gnbarbersop.scheduler.dto.AppointmentDto;
import com.gnbarbersop.scheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hour")
public class AppointmentController {

    @Autowired
    private static AppointmentService appointmentService;

    @PostMapping("/create")
    public static ResponseEntity<?> createHour(@RequestBody AppointmentDto hour, @RequestBody String servicoId, @RequestBody String usuarioId) {
        appointmentService.create(hour, servicoId, usuarioId);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
