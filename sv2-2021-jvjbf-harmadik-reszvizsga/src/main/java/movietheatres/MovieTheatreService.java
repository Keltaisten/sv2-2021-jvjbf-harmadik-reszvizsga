package movietheatres;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class MovieTheatreService {
    Map<String, List<Movie>> shows = new LinkedHashMap<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while (br.ready()) {
                String line = br.readLine();
                String[] fields1 = line.split("-");
                String theatre = fields1[0];
                String[] fields2 = fields1[1].split(";");
                String title = fields2[0];
                LocalTime startTime = LocalTime.parse(fields2[1]);
                List<Movie> temp = shows.computeIfAbsent(theatre, k -> new ArrayList<>());
                temp.add(new Movie(title, startTime));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file!", ioException);
        }
    }

//    public void addMovie(String theatre, Movie movie){
//        shows.get(theatre).add(movie);
//    }

    public Map<String, List<Movie>> getShows() {
        return shows;
    }

    public List<String> findMovie(String title) {
        Set<String> theatres = new TreeSet<>();
        for (String actual : shows.keySet()) {
            for (Movie movie : shows.get(actual)) {
                if (movie.getTitle().equals(title)) {
                    theatres.add(actual);
                }
            }
        }
        return new ArrayList<>(theatres);
    }

    public LocalTime findLatestShow(String movie) {
        LocalTime last = LocalTime.MIN;
        for (String actual : shows.keySet()) {
            for (Movie mov : shows.get(actual)) {
                if (mov.getTitle().equals(movie)) {
                    if(mov.getStartTime().isAfter(last)){
                        last = mov.getStartTime();
                    }
                }
            }
        }
        if(last == LocalTime.MIN){
            throw new IllegalArgumentException("No movie");
        }
        return last;
    }
}
