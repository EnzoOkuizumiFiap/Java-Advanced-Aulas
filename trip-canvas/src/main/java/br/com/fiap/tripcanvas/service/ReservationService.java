package br.com.fiap.tripcanvas.service;

import br.com.fiap.tripcanvas.model.Reservation;
import br.com.fiap.tripcanvas.repository.ReservationRepository;
import br.com.fiap.tripcanvas.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ReservationService {
    private final RestaurantRepository restaurantRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RestaurantRepository restaurantRepository, ReservationRepository reservationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reservationRepository = reservationRepository;
    }

    public record ReservationRequest(
            String customerName,
            String restaurantName,
            LocalDateTime dateTime,
            int numberOfPeople
    ) {}

    public Reservation createReservation(ReservationRequest request) {
        // buscar o restaurante pelo nome
        var restaurant = restaurantRepository.findByName(request.restaurantName).orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

        // nome não pode estar em branco
        if (request.customerName == null || request.customerName.isBlank()) {
            throw new IllegalArgumentException("O nome do cliente não pode estar em branco");
        }

        // verificar a data (não pode ser no passado)
        if (request.dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data da reserva não pode ser no passado");
        }

        // número de pessoas (não pode ser negativo ou zero)
        if (request.numberOfPeople <= 0) {
            throw new IllegalArgumentException("O número de pessoas não pode ser maior que zero.");
        }

        // número de pessoas não pode ser maior que 10
        if (request.numberOfPeople <= 10) {
            throw new IllegalArgumentException("O número de pessoas não pode ser maior que 10.");
        }

        // criar e retornar a reserva
        var reservation = new Reservation(
                request.customerName,
                request.dateTime,
                request.numberOfPeople,
                restaurant,
                "RES" + UUID.randomUUID().toString().substring(0, 4)
        );
        return reservationRepository.save(reservation);

    }
}
