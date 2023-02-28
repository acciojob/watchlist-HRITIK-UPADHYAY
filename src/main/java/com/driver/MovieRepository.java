package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieHashMap;
    HashMap<String, Director> directorHashMap;
    HashMap<String, List<String>> movieDirectorHashMap;


    public MovieRepository(){
        movieHashMap = new HashMap<>();
        directorHashMap = new HashMap<>();
        movieDirectorHashMap = new HashMap<>();
    }

    public void addMovie(Movie movie){
        movieHashMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorHashMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        if(movieHashMap.containsKey(movieName) && directorHashMap.containsKey(directorName)){
            movieHashMap.put(movieName, movieHashMap.get(movieName));
            directorHashMap.put(directorName, directorHashMap.get(directorName));
            List<String> moviesList = new ArrayList<String>();
            if(movieDirectorHashMap.containsKey(directorName)) moviesList =  movieDirectorHashMap.get(directorName);
            moviesList.add(movieName);
            movieDirectorHashMap.put(directorName, moviesList);
        }
    }

    public Movie getMovieByName(String movieName){
        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName){
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String dirctorName){
        if(movieDirectorHashMap.containsKey(dirctorName)) return movieDirectorHashMap.get(dirctorName);
        else return null;
    }

    public List<String> findAllMovies(){
        List<String> moviesList = new ArrayList<>();
        for(String movieName : movieHashMap.keySet()){
            moviesList.add(movieName);
        }
        return moviesList;
    }

    public void deleteDirectorByName(String directorName){
        List<String> movies = new ArrayList<String>();
        if(movieDirectorHashMap.containsKey(directorName)){
            movies = movieDirectorHashMap.get(directorName);
            for(String movie: movies){
                if(movieHashMap.containsKey(movie)){
                    movieHashMap.remove(movie);
                }
            }

            movieDirectorHashMap.remove(directorName);
        }
        if(directorHashMap.containsKey(directorName)) directorHashMap.remove(directorName);
    }

    public void deleteAllDirectors(){
        HashSet<String> movieSet = new HashSet<>();

        for(String directorName : movieDirectorHashMap.keySet()){
            for(String movieName : movieDirectorHashMap.get(directorName)){
                movieSet.add(movieName);
            }
        }

        for(String movieName : movieSet){
            if(movieHashMap.containsKey(movieName)){
                movieHashMap.remove(movieName);
            }
        }
    }
}
