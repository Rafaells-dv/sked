package com.gnbarbersop.scheduler.entity;

import com.gnbarbersop.scheduler.dto.ServicoDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity(name = "servico")
@Table(name = "servico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = "id")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double price;
    private Time duration;
    private String name;

    public ServicoEntity(ServicoDto dto) {
        this.duration = dto.duration();
        this.price = dto.price();
        this.name = dto.name();
    }
}
