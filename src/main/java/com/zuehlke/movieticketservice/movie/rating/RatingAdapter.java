package com.zuehlke.movieticketservice.movie.rating;

import com.zuehlke.movieticketservice.movie.Rating;
import com.zuehlke.movieticketservice.movie.util.RestClientFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RatingAdapter {

    private final RatingApiClient ratingApiClient;

    public RatingAdapter(String url) {
        ratingApiClient = RestClientFactory.createClient(url, RatingApiClient.class);
    }

    public List<Rating> getRatingsById(long id) {
        List<RatingResponse> ratings = ratingApiClient.getRatingsById(id);

        return ratings.stream()
                .map(Rating::from)
                .collect(toList());
    }
}
