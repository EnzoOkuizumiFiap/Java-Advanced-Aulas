package br.com.fiap.tripcanvas.repository;

import br.com.fiap.tripcanvas.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
