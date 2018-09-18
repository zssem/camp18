package com.zuehlke.movieticketservice.movie;

import com.zuehlke.movieticketservice.movie.movieservice.MovieServiceAdapter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PrefixForHealthHealthIndicator implements HealthIndicator {


    private final MovieServiceAdapter movieServiceAdapter;

    public PrefixForHealthHealthIndicator(MovieServiceAdapter movieServiceAdapter) {
        this.movieServiceAdapter = movieServiceAdapter;
    }

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().withDetail("numberOfMovies", movieServiceAdapter.getAll().size()).build();
    }

    private int check() {
        return 0;
    }

}