package com.gnbarbersop.scheduler.service;

import com.gnbarbersop.scheduler.dto.AppointmentDto;
import com.gnbarbersop.scheduler.entity.AppointmentEntity;
import com.gnbarbersop.scheduler.entity.enums.AppointmentStatus;
import com.gnbarbersop.scheduler.repository.AppointmentRepository;
import com.gnbarbersop.scheduler.repository.ServicoRepository;
import com.gnbarbersop.scheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServicoRepository servicoRepository;


    //Criar novo horario
    public void create(AppointmentDto dto, String servicoId, String userId) {

        //Verificar se o horario desejado ja está marcado
        Optional<AppointmentEntity> alreadyBooked = appointmentRepository.findByDateScheduledAndSatus(dto.dateScheduled(), AppointmentStatus.valueOf("BOOKED"));
        if (alreadyBooked.isPresent()) {
            throw new RuntimeException("Appointment already been booked.");
        }

        //Setar nova entidade horario para salvar
        AppointmentEntity newAppointment = new AppointmentEntity(dto);
        newAppointment.setStatus(AppointmentStatus.valueOf("pending"));
        newAppointment.setCreationDate(LocalDateTime.now());
        newAppointment.setUser(userRepository.findById(userId).get());
        newAppointment.setServico(servicoRepository.findById(servicoId).get());

        //Salvar novo horario
        appointmentRepository.save(newAppointment);
    }
}
