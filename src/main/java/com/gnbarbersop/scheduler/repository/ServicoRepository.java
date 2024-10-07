package com.gnbarbersop.scheduler.repository;

import com.gnbarbersop.scheduler.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntity, String> {
}
