package com.ontariotechu.sofe3980U.core;

import com.ontariotechu.sofe3980U.booking.Booking;
import com.ontariotechu.sofe3980U.core.restmodels.FlightSearchDTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class PathFinder {

    private PathFinder() {
    }

    public static List<Booking> buildBookings(FlightSearchDTO searchDTO) {
        var store = Memory.getInstance();
        Airport start = store.getAirportByID(searchDTO.getDepartureAirport());
        Airport end = store.getAirportByID(searchDTO.getArrivalAirport());
        LocalTime startTime = LocalTime.of(1, 0);
        int departureDayOfWeek = searchDTO.getDepartureDateParsed().getDayOfWeek().getValue();

        List<List<Flight>> departurePaths = findPaths(start, end, departureDayOfWeek, startTime);
        List<Booking> bookings = createBookingsFromPaths(departurePaths, searchDTO.getRoundTrip(), end, start, departureDayOfWeek, startTime);

        return sortBookingsByCriteria(bookings);
    }

    private static List<List<Flight>> findPaths(Airport start, Airport end, int dayOfWeek, LocalTime startTime) {
        List<List<Flight>> paths = new ArrayList<>();
        findPathsRecursive(start, end, new DowDate(dayOfWeek, startTime), new ArrayList<>(), paths);
        return paths;
    }

    private static void findPathsRecursive(Airport current, Airport end, DowDate departAfter, List<Flight> currentPath, List<List<Flight>> paths) {
        if (current.equals(end)) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        List<Flight> nextFlights = getNextFlights(current, departAfter);
        for (Flight flight : nextFlights) {
            currentPath.add(flight);
            findPathsRecursive(flight.getDestination(), end, flight.getArrivalDate(), currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    private static List<Flight> getNextFlights(Airport current, DowDate afterTime) {
        return Memory.getInstance().getFlightsFromAirport(current.getID()).stream()
                .filter(flight -> flight.getDepartDate().compareTo(afterTime) >= 0 && !currentPathContains(currentPath, flight.getDestination()))
                .collect(Collectors.toList());
    }

    private static boolean currentPathContains(List<Flight> currentPath, Airport destination) {
        return currentPath.stream().anyMatch(flight -> flight.getDestination().equals(destination));
    }

    private static List<Booking> createBookingsFromPaths(List<List<Flight>> departurePaths, boolean roundTrip, Airport end, Airport start, int dayOfWeek, LocalTime startTime) {
        List<Booking> bookings = new ArrayList<>();
        if (roundTrip) {
            List<List<Flight>> returnPaths = findPaths(end, start, dayOfWeek, startTime);
            for (int i = 0; i < Math.min(departurePaths.size(), returnPaths.size()); i++) {
                bookings.add(new Booking(new ArrayList<>(departurePaths.get(i)), new ArrayList<>(returnPaths.get(i)), UUID.randomUUID().toString()));
            }
        } else {
            departurePaths.forEach(path -> bookings.add(new Booking(new ArrayList<>(path), UUID.randomUUID().toString())));
        }
        return bookings;
    }

    private static List<Booking> sortBookingsByCriteria(List<Booking> bookings) {
        return bookings.stream()
                .sorted(Comparator.comparingInt(Booking::getTotalStops)
                        .thenComparing(Booking::getFinalArrivalDate))
                .collect(Collectors.toList());
    }

}
