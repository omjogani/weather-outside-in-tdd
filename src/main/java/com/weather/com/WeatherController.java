package com.weather.com;

import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.scheduling.TaskExecutors;

@ExecuteOn(TaskExecutors.IO)
@Controller("/weather")
public class WeatherController {

  private final WeatherService weatherService;

  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }


  @Get(uri = "/zip/{zipCode}")
  public Weather getByZip(String zipCode) {
    return weatherService.getByZip(zipCode);
  }

  @Get(uri = "/city/{cityName}")
  public Weather getByCityName(String cityName) {
    return weatherService.getByCityName(cityName);
  }


}
