package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        movieRepository.addMovieDirectorPair(movieName ,directorName);
    }

    public Movie getMovieByName(String movieName){
       return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String dirctiorName){
        return movieRepository.getDirectorByName(dirctiorName);
    }

    public List<String> getMoviesByDirectorName(String directiorName){
        return movieRepository.getMoviesByDirectorName(directiorName);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
