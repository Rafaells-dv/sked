package com.gnbarbersop.scheduler.repository;

import com.gnbarbersop.scheduler.entity.HourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourRepository extends JpaRepository<HourEntity, String> {
}
