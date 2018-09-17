package com.zuehlke.movieticketservice.movie;

import com.zuehlke.movieticketservice.movie.movieservice.MovieServiceResponse;

import java.util.Objects;

@SuppressWarnings("unused")
public class Movie {
    private final long id;
    private final String title;
    private final String poster;

    public Movie(long id, String title, String poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public static Movie from(MovieServiceResponse movieServiceResponse) {
        return new Movie(movieServiceResponse.getId(), movieServiceResponse.getTitle(), movieServiceResponse.getPoster());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(title, movie.title) &&
                Objects.equals(poster, movie.poster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, poster);
    }
}
