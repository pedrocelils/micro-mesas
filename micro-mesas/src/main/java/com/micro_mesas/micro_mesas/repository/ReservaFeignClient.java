package com.micro_mesas.micro_mesas.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "micro-reservas", url = "http://localhost:8083/reservas")
public interface ReservaFeignClient {

    @GetMapping("/reservas/disponibilidade/{clienteId}")
    boolean verificarDisponibilidadeMesa(@PathVariable Long clienteId);
}