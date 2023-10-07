package org.softuni.exam.structures;

import org.softuni.exam.entities.Actor;
import org.softuni.exam.entities.Movie;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieDatabaseImpl implements MovieDatabase {

    Map<String, Actor> actors = new LinkedHashMap<>();
    Map<String, Actor> newbieActors = new LinkedHashMap<>();
    Map<String, Movie> movies = new LinkedHashMap<>();
    Map<String, List<Movie>> moviesByActor = new LinkedHashMap<>();

    @Override
    public void addActor(Actor actor) {
        actors.put(actor.getId(), actor);
        newbieActors.put(actor.getId(), actor);
        moviesByActor.put(actor.getId(), new ArrayList<>());
    }

    @Override
    public void addMovie(Actor actor, Movie movie) throws IllegalArgumentException {

        if (!contains(actor) || !contains(movie)) {
            throw new IllegalArgumentException();
        }

        moviesByActor.get(actor.getId()).add(movie);

        movies.put(movie.getId(), movie);

        newbieActors.remove(actor.getId());
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
        return actors.values()
                .stream()
                .sorted((a1, a2) -> {
                    List<Movie> firstBudget = moviesByActor.get(a1.getId()).stream().sorted(Comparator.comparing(Movie::getBudget).reversed()).collect(Collectors.toList());
                    List<Movie> secondBudget = moviesByActor.get(a2.getId()).stream().sorted(Comparator.comparing(Movie::getBudget).reversed()).collect(Collectors.toList());

                    return Double.compare(secondBudget.get(0).getBudget(), firstBudget.get(0).getBudget());
                })
                .sorted((a1, a2) -> {
                    int firstSize = moviesByActor.get(a1.getId()).size();
                    int secondSize = moviesByActor.get(a2.getId()).size();

                    return Integer.compare(secondSize, firstSize);
                })
                .collect(Collectors.toList());
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
