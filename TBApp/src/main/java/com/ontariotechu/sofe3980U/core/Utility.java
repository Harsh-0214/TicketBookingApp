package com.ontariotechu.sofe3980U.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.ontariotechu.sofe3980U.core.restmodels.FlightSearchDTO;

public class Utility {

    //Utility method to parse dates from strings
    public static LocalDate parseDateString(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    //Method to validate the search parameters of a flight
    public static void validateFlightSearch(FlightSearchDTO searchParams) {
        checkAirportsDifferent(searchParams.getDepartureAirport(), searchParams.getArrivalAirport());
        checkDatesForRoundTrip(searchParams.isRoundTrip(), searchParams.getDepartureDateParsed(), searchParams.getReturnDateParsed());
    }

    //ensures departure and arrival airports are not the same
    private static void checkAirportsDifferent(int departureAirport, int arrivalAirport) {
        if (departureAirport == arrivalAirport) {
            throw new IllegalArgumentException("Departure and arrival airports must be different.");
        }
    }

    // Private method to validate dates based on the trip type
    private static void checkDatesForRoundTrip(boolean isRoundTrip, LocalDate departureDate, LocalDate returnDate) {

        if (isRoundTrip) {
            if (departureDate == null || returnDate == null) {
                throw new IllegalArgumentException("Both departure and return dates must be provided for round trips.");
            }
            if (departureDate.isAfter(returnDate)) {
                throw new IllegalArgumentException("Departure date must be before the return date for round trips.");
            }
        } else {
            // no return date for one-way trips
            if (returnDate != null) {
                throw new IllegalArgumentException("Return date must be null for one-way trips.");
            }
        }
    }

}
