package com.zuehlke.movieticketservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController {
    @RequestMapping("/api/v1/movies")
    @ResponseBody
    public String getMovies() {
        return "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"Batman Begins\",\n" +
                "    \"poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"Ted\",\n" +
                "    \"poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SX300.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"Inception\",\n" +
                "    \"poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg\"\n" +
                "  }\n" +
                "]";
    }

    @RequestMapping("/api/v1/movies/{id}")
    @ResponseBody
    public String getMovie() {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"Batman Begins\",\n" +
                "  \"poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg\",\n" +
                "  \"plot\": \"After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.\",\n" +
                "  \"year\": 2005,\n" +
                "  \"genre\": \"Action\",\n" +
                "  \"ratings\": [\n" +
                "    {\n" +
                "      \"source\": \"Internet Movie Database\",\n" +
                "      \"value\": \"8.3/10\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"source\": \"Rotten Tomatoes\",\n" +
                "      \"value\": \"84%\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}