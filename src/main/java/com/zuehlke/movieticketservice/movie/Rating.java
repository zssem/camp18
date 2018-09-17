package com.zuehlke.movieticketservice.movie;

import com.zuehlke.movieticketservice.movie.rating.RatingResponse;

import java.util.Objects;

@SuppressWarnings("unused")
public class Rating {
    private final String source;
    private final String value;

    Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public static Rating from(RatingResponse response) {
        return new Rating(response.getSource(), response.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(source, rating.source) &&
                Objects.equals(value, rating.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, value);
    }
}
