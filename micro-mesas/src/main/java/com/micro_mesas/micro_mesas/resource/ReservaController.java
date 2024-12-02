package com.micro_mesas.micro_mesas.resource;

import com.micro_mesas.micro_mesas.entities.ReservaNew;
import com.micro_mesas.micro_mesas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping
    public ReservaNew criarReserva(@RequestBody ReservaNew reserva) {
        // Lógica de reserva
        reserva.setDataReserva(LocalDateTime.now());
        return reservaRepository.save(reserva);
    }

    @GetMapping
    public List<ReservaNew> listarReservas() {
        return reservaRepository.findAll();
    }

    @GetMapping("/disponibilidade/{clienteId}")
    public boolean verificarDisponibilidade(@PathVariable Long clienteId) {
        // Aqui você pode verificar se o cliente já tem uma reserva ou se há mesas disponíveis
        // Vamos considerar uma regra simples: se o cliente já tem uma reserva, não podemos reservar outra mesa
        List<ReservaNew> reservas = reservaRepository.findAll();
        for (ReservaNew reserva : reservas) {
            if (reserva.getClienteId().equals(clienteId)) {
                return false; // Se já houver reserva para o cliente, retorna "false"
            }
        }
        return true; // Se não houver reservas para o cliente, retorna "true"
    }
}
