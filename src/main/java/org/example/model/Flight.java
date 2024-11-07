package org.example.model;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Flight {
    private String flightNumber;
    private List<Seat> seats;
    private ReentrantLock lock = new ReentrantLock();

    public Flight(String flightNumber, List<Seat> seats) {
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Seat findAvailableSeat() {
        lock.lock();
        try {
            return seats.stream().filter(seat -> !seat.isOccupied()).findFirst().orElse(null);
        } finally {
            lock.unlock();
        }
    }

    public void occupySeat(Seat seat) {
        lock.lock();
        try {
            seat.occupy();
        } finally {
            lock.unlock();
        }
    }
}
