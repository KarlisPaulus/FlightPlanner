package com.example.FlightPlanner.api.controller;

import org.springframework.web.bind.annotation.*;

import com.example.FlightPlanner.api.entities.Seat;
import com.example.FlightPlanner.service.SeatService;
import java.util.List;

@RestController
@RequestMapping("/seats")
@CrossOrigin(origins = "http://localhost:3000")
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{flightId}")
        public List<Seat> getSeatsForFlight(@PathVariable Long flightId) {
        return seatService.getSeatsForFlight(flightId);
    }

    @GetMapping("/filter/{flightId}")
        public List<Seat> recommendSeats(
        @PathVariable Long flightId,
        @RequestParam int numberOfTickets,
        @RequestParam(required = false, defaultValue = "false") boolean window,
        @RequestParam(required = false, defaultValue = "false") boolean extraLegroom,
        @RequestParam(required = false, defaultValue = "false") boolean closeToExit,
        @RequestParam(required = false, defaultValue = "false") boolean sideBySide)
        {
        return seatService.recommendSeats(flightId, numberOfTickets, window, extraLegroom, closeToExit, sideBySide);
    }
}
