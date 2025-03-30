package com.example.FlightPlanner.api.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.FlightPlanner.api.entities.Flight;
import com.example.FlightPlanner.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> filterFlights(
            @RequestParam(required = false) String destination, 
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Integer maxPrice, 
            @RequestParam(required = false) String departureTime,
            @RequestParam(required = false) String arrivalTime) {
        LocalDate flightDate = (date != null) ? LocalDate.parse(date) : null;
        LocalTime departTime = (departureTime != null) ? LocalTime.parse(departureTime) : null;
        LocalTime arrTime = (arrivalTime != null) ? LocalTime.parse(arrivalTime) : null;
        return flightService.findFlights(destination, flightDate, maxPrice, departTime, arrTime);
    }
}
