package org.example.model;

public class Seat {
    private String seatNumber;
    private boolean occupied;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        this.occupied = true;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}
