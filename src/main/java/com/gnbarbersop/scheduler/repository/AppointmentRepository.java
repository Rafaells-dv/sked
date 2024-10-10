package com.gnbarbersop.scheduler.repository;

import com.gnbarbersop.scheduler.entity.AppointmentEntity;
import com.gnbarbersop.scheduler.entity.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String> {
    Optional<AppointmentEntity> findByBookedDateAndStatus(LocalDateTime bookedDate, AppointmentStatus status);
}
