package org.softuni.exam.structures;

import org.softuni.exam.entities.Actor;
import org.softuni.exam.entities.Movie;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieDatabaseImpl implements MovieDatabase {

    Map<String, Actor> actors = new LinkedHashMap<>();
    Map<String, Actor> newbieActors = new LinkedHashMap<>();
    Map<String, Movie> movies = new LinkedHashMap<>();
    Map<String, Movie> moviesByActor = new LinkedHashMap<>();

    @Override
    public void addActor(Actor actor) {
        actors.put(actor.getId(), actor);
        newbieActors.put(actor.getId(), actor);
    }

    @Override
    public void addMovie(Actor actor, Movie movie) throws IllegalArgumentException {
        if (!contains(actor)) {
            throw new IllegalArgumentException();
        }

        newbieActors.remove(actor.getId());
        movies.put(movie.getId(), movie);
        moviesByActor.put(actor.getId(), movie);
    }

    @Override
    public boolean contains(Actor actor) {
        return actors.get(actor.getId()) != null;
    }

    @Override
    public boolean contains(Movie movie) {
        return movies.get(movie.getId()) != null;
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return movies.values();
    }

    @Override
    public Iterable<Actor> getNewbieActors() {
        return newbieActors.values();
    }

    @Override
    public Iterable<Movie> getMoviesOrderedByBudgetThenByRating() {
        return movies.values()
                .stream()
                .sorted(Comparator.comparing(Movie::getBudget).reversed()
                        .thenComparing(Movie::getRating).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Actor> getActorsOrderedByMaxMovieBudgetThenByMoviesCount() {
        return null;
    }

    @Override
    public Iterable<Movie> getMoviesInRangeOfBudget(double lower, double upper) {
        return movies.values()
                .stream()
                .filter(m -> m.getBudget() >= lower && m.getBudget() <= upper)
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .collect(Collectors.toList());
    }
}
