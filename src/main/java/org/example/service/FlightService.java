package org.example.service;
import org.example.model.Flight;
import org.example.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class FlightService {
    public Flight createFlight(String flightNumber, int seatCount) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat("S" + i));
        }
        return new Flight(flightNumber, seats);
    }
}