package com.example.FlightPlanner.api.controller;

import org.springframework.web.bind.annotation.*;

import com.example.FlightPlanner.api.entities.Seat;
import com.example.FlightPlanner.service.SeatService;
import java.util.List;

@RestController
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats/{flightId}")
    public List<Seat> getSeatsForFlight(@PathVariable Long flightId) {
        return seatService.getSeatsForFlight(flightId);
    }
}
