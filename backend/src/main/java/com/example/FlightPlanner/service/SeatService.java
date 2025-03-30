package com.example.FlightPlanner.service;

import com.example.FlightPlanner.api.entities.Seat;
import com.example.FlightPlanner.api.repository.SeatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Seat> recommendSeats(Long flightId, int numberOfTickets, boolean window, boolean extraLegroom, boolean closeToExit, boolean sideBySide) {
        List<Seat> availableSeats = seatRepository.findByFlightId(flightId).stream()
            .filter(Seat::isAvailable)
            .filter(seat -> !window || seat.isWindow())
            .filter(seat -> !extraLegroom || seat.isExtraLegroom())
            .filter(seat -> !closeToExit || seat.isCloseToExit())
            .collect(Collectors.toList());

        // If side by side filter is requested and there is more than 1 ticket
        if (sideBySide && numberOfTickets > 1) {
            // Group seats by row
            Map<String, List<Seat>> seatsByRow = availableSeats.stream()
            // Separates row number and seat position
                .collect(Collectors.groupingBy(seat -> seat.getSeatNumber().substring(0, seat.getSeatNumber().length() - 1)));
        
            // Finds closest seat positions
            // AI helped me to make this logic work
            for (List<Seat> rowSeats : seatsByRow.values()) {
                List<Seat> sideBySideSeats = new ArrayList<>();
                for (int i = 0; i < rowSeats.size(); i++) {
                    // If list is empty or areSeatsSideBySide is true
                    if (sideBySideSeats.isEmpty() || areSeatsSideBySide(sideBySideSeats.get(sideBySideSeats.size() - 1), rowSeats.get(i))) {
                        sideBySideSeats.add(rowSeats.get(i));   // Adds seat to list if seats are side by side
                        if (sideBySideSeats.size() == numberOfTickets) {
                            return sideBySideSeats;
                        }
                    } else {
                        sideBySideSeats.clear(); // Reset if seats are not side by side
                    }
                }
            }
        }
            // Return the first available seats if side by side seats are not found
            return availableSeats.stream().limit(numberOfTickets).collect(Collectors.toList());
        }

    // Checks if seats are next to each other, if not returns false
    private boolean areSeatsSideBySide(Seat seat1, Seat seat2) {
        char seat1Column = seat1.getSeatNumber().charAt(seat1.getSeatNumber().length() - 1);
        char seat2Column = seat2.getSeatNumber().charAt(seat2.getSeatNumber().length() - 1);
        return seat2Column - seat1Column == 1;
    }
}