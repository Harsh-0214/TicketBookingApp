package com.ontariotechu.sofe3980U.core;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ontariotechu.sofe3980U.booking.Booking;

public class Memory {
    private static Memory instance = null;
    private List<Airport> airportsList;
    private List<Flight> flightNetworkList;

//Bookings 
    private HashMap<String, List<Booking>> SESS_UUID_Browsed_bookings = new HashMap<>();
    private HashMap<String, List<Booking>> UUID_Booked_bookings = new HashMap<>();

    public Airport getAirportByID(int id) {
        for (Airport airport : airportsList) {
            if (airport.getID() == id) {
                return airport;
            }
        }
        return null;
    }
    private Memory() {
        airportsList = new ArrayList<>();
        flightNetworkList = new ArrayList<>();

        airportsList.add(new Airport("JFK - John F. Kennedy International Airport", "America/New_York", 1));
        airportsList.add(new Airport("LAX - Los Angeles International Airport", "America/Los_Angeles", 2));
        airportsList.add(new Airport("ORD - Chicago O'Hare International Airport", "America/Chicago", 3));
        airportsList.add(new Airport("LHR - Heathrow Airport", "Europe/London", 4));
        airportsList.add(new Airport("YYZ - Toronto Pearson International Airport", "America/Toronto", 5));
        airportsList.add(new Airport("YVR - Vancouver International Airport", "America/Vancouver", 6));   
        airportsList.add(new Airport("SYD - Sydney Airport", "Australia/Sydney", 7));
        airportsList.add(new Airport("YTZ - Billy Bishop Toronto City Airport", "America/Toronto", 8));
        airportsList.add(new Airport("HKG - Hong Kong International Airport", "Asia/Hong_Kong", 9));
        airportsList.add(new Airport("DXB - Dubai International Airport", "Asia/Dubai", 10));
        airportsList.add(new Airport("FRA - Frankfurt Airport", "Europe/Berlin", 11));        
        airportsList.add(new Airport("CDG - Charles de Gaulle Airport", "Europe/Paris", 12));
        airportsList.add(new Airport("PRG - Vaclav Havel Airport Prague", "Europe/Prague", 13)); 
        airportsList.add(new Airport("ZRH - Zurich Airport", "Europe/Zurich", 14));
        airportsList.add(new Airport("BOM - Chatrapati Shivaji International Airport", "Asia/Kolkata", 15)); 
        airportsList.add(new Airport("MRU - Sr. Seewoosagur Ramgoolam International Airport", "Indian/Mauritius", 16));        
        airportsList.add(new Airport("VIE - Vienna International Airport", "Europe/Vienna", 17));
        airportsList.add(new Airport("PEK - Beijing Capital International Airport", "Asia/Shanghai", 18)); 
        airportsList.add(new Airport("EDI - Edinburgh Airport", "Europe/London", 19));     
        airportsList.add(new Airport("BTS - Bratislava Airport", "Europe/Bratislava", 20));         
        airportsList.add(new Airport("HAM - Hamburg Airport", "Europe/Berlin", 21)); 
        airportsList.add(new Airport("MUC - Munich Airport", "Europe/Berlin", 22));
        airportsList.add(new Airport("ZAG - Zagreb Airport", "Europe/Zagreb", 23)); 
        airportsList.add(new Airport("BRQ - Brno-Turany Airport", "Europe/Prague", 24)); 

        //Flight paths
        LocalTime time1530 = LocalTime.of(15, 30);
        LocalTime time1730 = LocalTime.of(17, 30);

        LocalTime time0615 = LocalTime.of(6, 15);
        LocalTime time0930 = LocalTime.of(9, 30);

        DowDate departDateSunAM = new DowDate(7,time0615);
        DowDate arrivalDate2SunAM = new DowDate(7, time0930);

        DowDate departDateSunPM = new DowDate(7,time1530);
        DowDate arrivalDateSunPM = new DowDate(7, time1730);

        DowDate departDateMonAM =  new DowDate(1, time0615);
        DowDate arrivalDateMonAM = new DowDate(1, time0930);

        DowDate departDateMonPM = new DowDate(1,time1530);
        DowDate arrivalDateMonPM = new DowDate(1, time1730);

        DowDate departDateTueAM =  new DowDate(2, time0615);
        DowDate arrivalDateTueAM = new DowDate(2, time0930);

        DowDate departDateTuePM = new DowDate(2,time1530);
        DowDate arrivalDateTuePM = new DowDate(2, time1730);

        DowDate departDateWedAM =  new DowDate(3, time0615);
        DowDate arrivalDateWedAM = new DowDate(3, time0930);

        DowDate departDateWedPM = new DowDate(3,time1530);
        DowDate arrivalDateWedPM = new DowDate(3, time1730);

        DowDate departDateThuAM =  new DowDate(4, time0615);
        DowDate arrivalDateThuAM = new DowDate(4, time0930);

        DowDate departDateThuPM = new DowDate(4,time1530);
        DowDate arrivalDateThuPM = new DowDate(4, time1730);

        DowDate departDateFriAM =  new DowDate(5, time0615);
        DowDate arrivalDateFriAM = new DowDate(5, time0930);

        DowDate departDateFriPM = new DowDate(5,time1530);
        DowDate arrivalDateFriPM = new DowDate(5, time1730);

        DowDate departDateSatAM =  new DowDate(6, time0615);
        DowDate arrivalDateSatAM = new DowDate(6, time0930);

        DowDate departDateSatPM = new DowDate(6,time1530);
        DowDate arrivalDateSatPM = new DowDate(6, time1730);

        //TOR to NYC
        flightNetworkList.add(new Flight(getAirportByID(5), getAirportByID(1), departDateSunPM,arrivalDateSunPM));

        //NYC to LA
        flightNetworkList.add(new Flight(getAirportByID(1), getAirportByID(2), departDateSunPM,arrivalDate2SunAM));

        //LA to NYC
        flightNetworkList.add(new Flight(getAirportByID(2), getAirportByID(1), departDateTueAM,arrivalDateTueAM));

        //NYC to TOR   
        flightNetworkList.add(new Flight(getAirportByID(1), getAirportByID(5), departDateTuePM,arrivalDateTuePM));

        //TOR to CHI
        flightNetworkList.add(new Flight(getAirportByID(5), getAirportByID(3), departDateMonAM,arrivalDateMonAM));

        //CHI to LA
        flightNetworkList.add(new Flight(getAirportByID(3), getAirportByID(2), departDateMonPM,arrivalDateMonPM));

        //NYC to Dubai
        flightNetworkList.add(new Flight(getAirportByID(1), getAirportByID(8), departDateWedAM, arrivalDateWedPM));

        //Tokyo to Hong Kong
        flightNetworkList.add(new Flight(getAirportByID(99), getAirportByID(9), departDateFriAM, arrivalDateFriPM));

        //Hong Kong to Sydney
        flightNetworkList.add(new Flight(getAirportByID(9), getAirportByID(7), departDateSatAM, arrivalDateSatPM));

        //Sydney to Frankfurt
        flightNetworkList.add(new Flight(getAirportByID(7), getAirportByID(11), departDateSunAM, arrivalDateSunPM));

        //Frankfurt to London
        flightNetworkList.add(new Flight(getAirportByID(11), getAirportByID(10), departDateMonAM, arrivalDateMonPM));

        //London to Toronto
        flightNetworkList.add(new Flight(getAirportByID(10), getAirportByID(5), departDateTueAM, arrivalDateTuePM));

        //Toronto to Paris
        flightNetworkList.add(new Flight(getAirportByID(5), getAirportByID(12), departDateWedAM, arrivalDateWedPM));

        // London to Vienna
        flightNetworkList.add(new Flight(getAirportByID(10), getAirportByID(17), departDateThuAM, arrivalDateThuPM));

        // Vienna to Prague
        flightNetworkList.add(new Flight(getAirportByID(17), getAirportByID(13), departDateFriAM, arrivalDateFriPM));

        // Prague to Brno
        flightNetworkList.add(new Flight(getAirportByID(13), getAirportByID(24), departDateSatAM, arrivalDateSatPM));

        // Brno to Bratislava
        flightNetworkList.add(new Flight(getAirportByID(24), getAirportByID(20), departDateSunAM, arrivalDateSunPM));

        // Bratislava to Zagreb
        flightNetworkList.add(new Flight(getAirportByID(20), getAirportByID(23), departDateMonAM, arrivalDateMonPM));

        // Zagreb to Munich
        flightNetworkList.add(new Flight(getAirportByID(23), getAirportByID(22), departDateTueAM, arrivalDateTuePM));

        // Munich to Hamburg
        flightNetworkList.add(new Flight(getAirportByID(22), getAirportByID(21), departDateWedAM, arrivalDateWedPM));

        // Hamburg to Zurich
        flightNetworkList.add(new Flight(getAirportByID(21), getAirportByID(14), departDateThuAM, arrivalDateThuPM));

        // Toronto to Mumbai
        flightNetworkList.add(new Flight(getAirportByID(5), getAirportByID(14), departDateFriAM, arrivalDateFriPM));

        // Mumbai to Dubai
        flightNetworkList.add(new Flight(getAirportByID(14), getAirportByID(8), departDateSatAM, arrivalDateSatPM));

        // Dubai to Paris
        flightNetworkList.add(new Flight(getAirportByID(8), getAirportByID(12), departDateSunAM, arrivalDateSunPM));

        // Paris to Berlin
        flightNetworkList.add(new Flight(getAirportByID(12), getAirportByID(11), departDateMonAM, arrivalDateMonPM));

        // Berlin to Sydney
        flightNetworkList.add(new Flight(getAirportByID(11), getAirportByID(7), departDateTueAM, arrivalDateTuePM));

        // Sydney to Chicago
        flightNetworkList.add(new Flight(getAirportByID(7), getAirportByID(3), departDateWedAM, arrivalDateWedPM));

        // Chicago to Vienna
        flightNetworkList.add(new Flight(getAirportByID(3), getAirportByID(17), departDateThuAM, arrivalDateThuPM));

        // Vienna to London
        flightNetworkList.add(new Flight(getAirportByID(17), getAirportByID(10), departDateFriAM, arrivalDateFriPM));

        // NYC to Chicago
        flightNetworkList.add(new Flight(getAirportByID(1), getAirportByID(3), departDateThuPM, arrivalDateThuPM));

        // LA to Toronto
        flightNetworkList.add(new Flight(getAirportByID(2), getAirportByID(5), departDateFriPM, arrivalDateFriPM));

        // Dubai to Paris
        flightNetworkList.add(new Flight(getAirportByID(8), getAirportByID(12), departDateMonPM, arrivalDateMonPM));

        // Tokyo to Sydney
        flightNetworkList.add(new Flight(getAirportByID(99), getAirportByID(7), departDateTuePM, arrivalDateTuePM));

        // Hong Kong to London
        flightNetworkList.add(new Flight(getAirportByID(9), getAirportByID(10), departDateWedPM, arrivalDateWedPM));

        // Sydney to Vienna
        flightNetworkList.add(new Flight(getAirportByID(7), getAirportByID(17), departDateThuPM, arrivalDateThuPM));

        // Chicago to Dubai
        flightNetworkList.add(new Flight(getAirportByID(3), getAirportByID(8), departDateFriPM, arrivalDateFriPM));

        // Vienna to Mumbai
        flightNetworkList.add(new Flight(getAirportByID(17), getAirportByID(14), departDateSatPM, arrivalDateSatPM));

        // Paris to Tokyo
        flightNetworkList.add(new Flight(getAirportByID(12), getAirportByID(99), departDateSunPM, arrivalDateSunPM));

        // Toronto to Dubai
        flightNetworkList.add(new Flight(getAirportByID(5), getAirportByID(8), departDateMonPM, arrivalDateMonPM));

        // Toronto to Hong Kong
        flightNetworkList.add(new Flight(getAirportByID(5), getAirportByID(9), departDateSatAM, arrivalDateSatPM));

        // Hong Kong to Dubai
        flightNetworkList.add(new Flight(getAirportByID(9), getAirportByID(8), departDateSunAM, arrivalDateSunPM));

        // Dubai to London
        flightNetworkList.add(new Flight(getAirportByID(8), getAirportByID(10), departDateMonAM, arrivalDateMonPM));

        // London to Paris
        flightNetworkList.add(new Flight(getAirportByID(10), getAirportByID(12), departDateTueAM, arrivalDateTuePM));

        // Paris to Frankfurt
        flightNetworkList.add(new Flight(getAirportByID(12), getAirportByID(11), departDateWedAM, arrivalDateWedPM));

        // Frankfurt to Munich
        flightNetworkList.add(new Flight(getAirportByID(11), getAirportByID(22), departDateThuAM, arrivalDateThuPM));

        // Munich to Zurich
        flightNetworkList.add(new Flight(getAirportByID(22), getAirportByID(14), departDateFriAM, arrivalDateFriPM));

        // Zurich to Vienna
        flightNetworkList.add(new Flight(getAirportByID(14), getAirportByID(17), departDateSatAM, arrivalDateSatPM));

        // Vienna to Berlin
        flightNetworkList.add(new Flight(getAirportByID(17), getAirportByID(11), departDateSunAM, arrivalDateSunPM));

        // Berlin to Prague
        flightNetworkList.add(new Flight(getAirportByID(11), getAirportByID(13), departDateMonAM, arrivalDateMonPM));

    }
    public static synchronized Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    //Booking Getters and Setters

    public void addBookingToBookedList(String uuid, Booking booking) {
        if (UUID_Booked_bookings.containsKey(uuid)) {
            UUID_Booked_bookings.get(uuid).add(booking);
        } else {
            List<Booking> newList = new ArrayList<>();
            newList.add(booking);
            UUID_Booked_bookings.put(uuid, newList);
        }
    }
    public List<Booking> getBookedListByUUID(String uuid) {
        if (UUID_Booked_bookings.containsKey(uuid)) {
            return UUID_Booked_bookings.get(uuid);
        } else {
            return new ArrayList<>();

        }
    }
    public void setBookingBrowseList(String sessionID, List<Booking> bookingList) {
        SESS_UUID_Browsed_bookings.put(sessionID, bookingList);
    }
    public List<Booking> getBookingBrowseList(String sessionID) {
       return SESS_UUID_Browsed_bookings.getOrDefault(sessionID, new ArrayList<>());
    }

    //Getters and Setters
    public List<Airport> getAirportList() {
        return airportsList;
    }

    public List<Flight> getFlightsList() {
        return flightNetworkList;
    }

    public Map<Integer, List<Flight>> getSortedFlights() {
        
        Map<Integer, List<Flight>> outputMap = new HashMap<Integer, List<Flight>>();
        for (Flight flight : flightNetworkList) {
            if (outputMap.containsKey(flight.getStart().getID())) {
                outputMap.get(flight.getStart().getID()).add(flight);
            }
            else {
                List<Flight> new_key_list = new ArrayList<>();
                new_key_list.add(flight);
                outputMap.put(flight.getStart().getID(), new_key_list);
            }
        }
        for (Map.Entry<Integer, List<Flight>> flightListEntry : outputMap.entrySet()) {
            List<Flight> flightList = flightListEntry.getValue();
            Collections.sort(flightList, new Comparator<Flight>() {
                @Override
                public int compare(Flight f1, Flight f2) {
                    return f1.getDepartDate().compareTo(f2.getDepartDate());
                }
            });
        }

        return outputMap;
    }

}
