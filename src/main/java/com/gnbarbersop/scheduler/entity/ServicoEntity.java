package com.gnbarbersop.scheduler.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "servico")
@Table(name = "servico")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = "id")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double price;
    private Integer duration;
    private String name;
}
