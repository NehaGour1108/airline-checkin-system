package org.example;

import org.example.model.Flight;
import org.example.model.Passenger;
import org.example.service.BookingService;
import org.example.service.CheckInService;
import org.example.service.FlightService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();
        CheckInService checkInService = new CheckInService();

        Flight flight = flightService.createFlight("AI202", 5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Book Flight\n2. Check-in\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter passport number: ");
                String passport = scanner.nextLine();
                Passenger passenger = new Passenger(name, passport);

                executorService.submit(() -> bookingService.bookFlight(flight, passenger));
            } else if (choice == 2) {
                System.out.print("Enter passport number: ");
                String passport = scanner.nextLine();
                Passenger passenger = new Passenger("", passport);
                checkInService.checkInPassenger(passenger);
            } else {
                break;
            }
        }
        executorService.shutdown();
    }
}