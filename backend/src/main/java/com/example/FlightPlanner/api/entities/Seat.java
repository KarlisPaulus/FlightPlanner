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
    private boolean isWindow;
    private boolean isExtraLegroom;
    private boolean isCloseToExit;

    public Seat() {}

    public Seat(Flight flight, String seatNumber, boolean isAvailable, boolean isWindow, boolean isExtraLegroom, boolean isCloseToExit) {
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.isWindow = isWindow;
        this.isExtraLegroom = isExtraLegroom;
        this.isCloseToExit = isCloseToExit;
    }

    public Flight getFlight() { return flight; }
    public String getSeatNumber() { return seatNumber; }
    public boolean isAvailable() { return isAvailable; }
    public boolean isWindow() { return isWindow; }
    public boolean isExtraLegroom() { return isExtraLegroom; }
    public boolean isCloseToExit() { return isCloseToExit; }

    public void setAvailable(boolean available) { isAvailable = available; }
}
