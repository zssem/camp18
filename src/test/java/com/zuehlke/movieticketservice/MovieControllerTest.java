package com.zuehlke.movieticketservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getMovies() throws Exception {
        when()
                .get("/api/v1/movies")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[1].id", Matchers.equalTo(2))
                .body("[2].id", Matchers.equalTo(3));
    }

    @Test
    public void getMovieById() throws Exception {
        when()
                .get("/api/v1/movies/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Batman Begins"));
    }
}