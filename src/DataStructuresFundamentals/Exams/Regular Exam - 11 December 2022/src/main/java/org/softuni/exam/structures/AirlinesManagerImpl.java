package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.LinkedHashMap;
import java.util.Map;

public class AirlinesManagerImpl implements AirlinesManager {

    Map<String, Airline> airlines = new LinkedHashMap<>();
    Map<String, Flight> flights = new LinkedHashMap<>();
    Map<String, Flight> flightsByAirlines = new LinkedHashMap<>();


    @Override
    public void addAirline(Airline airline) {
        airlines.put(airline.getId(), airline);
    }

    @Override
    public void addFlight(Airline airline, Flight flight) {

        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }

        flights.put(flight.getId(), flight);
        flightsByAirlines.put(airline.getId(), flight);

    }

    @Override
    public boolean contains(Airline airline) {
        return airlines.get(airline.getId()) != null;
    }

    @Override
    public boolean contains(Flight flight) {
        return flights.get(flight.getId()) != null;
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {

        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }

        Flight flight = flightsByAirlines.get(airline.getId());
        flights.remove(flight.getId());
        
        flightsByAirlines.remove(airline.getId());
        airlines.remove(airline.getId());

    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return flights.values();
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return null;
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        return null;
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return null;
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        return null;
    }
}
