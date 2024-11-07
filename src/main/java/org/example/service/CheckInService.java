package org.example.service;

import org.example.model.Passenger;

public class CheckInService {
    public void checkInPassenger(Passenger passenger) {
        if (passenger.getSeatNumber() != null) {
            System.out.println("Check-in successful for passenger with passport " + passenger.getPassportNumber());
        } else {
            System.out.println("Passenger not booked on flight.");
        }
    }
}