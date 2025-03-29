package com.example.FlightPlanner.service;

import com.example.FlightPlanner.api.entities.Seat;
import com.example.FlightPlanner.api.repository.SeatRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
     private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeatsForFlight(Long flightId) {
        return seatRepository.findByFlightId(flightId);
    }
}
