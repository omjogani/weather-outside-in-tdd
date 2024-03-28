package com.weather.com;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("https://api.weatherapi.com/v1/")
public interface WeatherApi {
  @Get("current.json?key=&aqi=no")
  Weather getWeather(@QueryValue("q") String param);
}
