package com.weather.com;

import io.micronaut.http.annotation.*;

@Controller("/weather")
public class WeatherController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}