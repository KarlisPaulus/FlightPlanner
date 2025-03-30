package com.example.FlightPlanner.api.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String destination;
    private LocalDate date;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer price;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Seat> seats;

    public Flight() {}

    public Flight(String destination, LocalDate date, LocalTime departureTime, LocalTime arrivalTime, Integer price) {
        this.destination = destination;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public Long getId() {return id; }
    public String getDestination() {return destination; }
    public LocalDate getDate() {return date; }
    public LocalTime getDepartureTime() { return departureTime; }
    public LocalTime getArrivalTime() { return arrivalTime; }
    public Integer getPrice() {return price; }
    public List<Seat> getSeats() {return seats; }
}