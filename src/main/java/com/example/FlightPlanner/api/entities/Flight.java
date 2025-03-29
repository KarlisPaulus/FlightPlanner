package com.example.FlightPlanner.api.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String destination;
    private LocalDate date;
    private String time;
    private Integer price;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Seat> seats;

    public Flight() {}

    public Flight(String destination, LocalDate date, String time, Integer price) {
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Long getId() {return id; }
    public String getDestination() {return destination; }
    public LocalDate getDate() {return date; }
    public String getTime() {return time; }
    public Integer getPrice() {return price; }
    public List<Seat> getSeats() {return seats; }
}