package br.com.fiap.tripcanvas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private String customerName;
    private int numberOfPeople;

    @ManyToOne
    private Restaurant restaurant;
    private String confirmationCode;

    public Reservation(String customerName, LocalDateTime dateTime, int numberOfPeople, Restaurant restaurant, String confirmationCode) {
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.numberOfPeople = numberOfPeople;
        this.restaurant = restaurant;
        this.confirmationCode = confirmationCode;
    }
}
