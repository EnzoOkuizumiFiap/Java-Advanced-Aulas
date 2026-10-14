package br.com.fiap.tripcanvas.tools;

import br.com.fiap.tripcanvas.model.Reservation;
import br.com.fiap.tripcanvas.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ReservationTool {
    private final ReservationService reservationService;

    @Tool(name = "makeReservation", description = "Faz uma reserva em um restaurante")
    public Reservation makeReservation(
            @ToolParam(description = "Nome do cliente que está fazendo a reserva") String customerName,
            @ToolParam(description = "Nome do restaurante onde a reserva será feita") String restaurantName,
            @ToolParam(description = "Data e hora da reserva") LocalDateTime dateTime,
            @ToolParam(description = "Números de pessoas para a reserva") int numberOfPeople
    ) {
        return reservationService.createReservation(new ReservationService.ReservationRequest(
                customerName,
                restaurantName,
                dateTime,
                numberOfPeople
        ));
    }
}
