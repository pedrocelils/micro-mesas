package com.micro_mesas.micro_mesas.repository;

import com.micro_mesas.micro_mesas.entities.Reserva;
import com.micro_mesas.micro_mesas.entities.ReservaNew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaNew, Integer> {
    Reserva findById(Long id);
}
