package com.example.FlightPlanner.service;

import java.time.LocalDate;
import java.util.List;

import com.example.FlightPlanner.api.entities.Flight;
import com.example.FlightPlanner.api.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> findFlights(String destination, LocalDate date, Integer maxPrice) {
        if (destination == null && maxPrice == null && date == null) {
            return flightRepository.findAll();
        }
        return flightRepository.findFilteredFlights(destination, date, maxPrice);
    }
}
