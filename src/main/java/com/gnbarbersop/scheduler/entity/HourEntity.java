package com.gnbarbersop.scheduler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnbarbersop.scheduler.entity.enums.HourStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Entity(name = "horario")
@Table(name = "horario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class HourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer day;
    private Time hour;
    private Integer month;
    private Integer year;
    private Date creation_date;

    @Enumerated(EnumType.STRING)
    private HourStatus status;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="servico_id")
    @JsonIgnore
    private ServicoEntity servico;
}
