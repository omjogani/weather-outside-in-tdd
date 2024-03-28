package com.weather.com;

import jakarta.inject.Singleton;

@Singleton
public class WeatherService {
  private WeatherApi weatherApi;

  public WeatherService(WeatherApi weatherApi) {
    this.weatherApi = weatherApi;
  }

  public Weather getByZip(String zipCode) {
    return weatherApi.getWeather(zipCode);
  }

  public Weather getByCityName(String cityName) {
    return weatherApi.getWeather(cityName);
  }

}
