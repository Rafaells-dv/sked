package com.gnbarbersop.scheduler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnbarbersop.scheduler.dto.AppointmentDto;
import com.gnbarbersop.scheduler.entity.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Entity(name = "horario")
@Table(name = "horario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDateTime dateScheduled;
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="servico_id")
    @JsonIgnore
    private ServicoEntity servico;

    public AppointmentEntity(AppointmentDto appointmentDto) {
        BeanUtils.copyProperties(appointmentDto, this);
    }
}
