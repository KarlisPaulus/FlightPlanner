package com.example.FlightPlanner.api.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.example.FlightPlanner.api.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query("SELECT f FROM Flight f WHERE " +
           "(:destination IS NULL OR f.destination = :destination) " +
           "AND (:date IS NULL OR f.date = :date)" +
           "AND (:maxPrice IS NULL OR f.price <= :maxPrice)" +
           "AND (:departureTime IS NULL OR f.departureTime >= :departureTime) " + 
           "AND (:arrivalTime IS NULL OR f.arrivalTime <= :arrivalTime)")
    List<Flight> findFilteredFlights(
        @Param("destination") String destination,
        @Param("date") LocalDate date,
        @Param("maxPrice") Integer maxPrice,
        @Param("departureTime") LocalTime departureTime,
        @Param("arrivalTime") LocalTime arrivalTime
    );
}
