package com.example.FlightPlanner.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FlightPlanner.api.entities.Seat;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByFlightId(Long flightId);
}
