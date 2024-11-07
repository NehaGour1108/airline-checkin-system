package org.example.service;

import org.example.model.Flight;
import org.example.model.Passenger;
import org.example.model.Seat;

public class BookingService {

    public boolean bookFlight(Flight flight, Passenger passenger) {
        Seat availableSeat = flight.findAvailableSeat();
        if (availableSeat != null) {
            flight.occupySeat(availableSeat);
            passenger.assignSeat(availableSeat.getSeatNumber());
            System.out.println("Booking confirmed for " + passenger.getName() + " on seat " + availableSeat.getSeatNumber());
            return true;
        } else {
            System.out.println("No available seats on flight " + flight.getFlightNumber());
            return false;
        }
    }
}