package com.example.FlightPlanner.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    @JsonIgnore
    private Flight flight;

    private String seatNumber;
    private boolean isAvailable;

    public Seat() {}

    public Seat(Flight flight, String seatNumber, boolean isAvailable) {
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public Flight getFlight() { return flight; }
    public String getSeatNumber() { return seatNumber; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { isAvailable = available; }
}
