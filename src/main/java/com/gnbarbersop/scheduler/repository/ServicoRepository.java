package com.gnbarbersop.scheduler.repository;

import com.gnbarbersop.scheduler.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoRepository extends JpaRepository<ServicoEntity, String> {
    Optional<ServicoEntity> findByName(String name);
}
