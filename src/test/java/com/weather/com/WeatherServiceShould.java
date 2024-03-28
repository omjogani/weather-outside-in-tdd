package com.weather.com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherServiceShould {

  @Mock WeatherApi weatherApi;
  private WeatherService weatherService;

  @BeforeEach
  void setUp() {
    weatherService = new WeatherService(weatherApi);
  }

  @Test
  @DisplayName("call the http client to retrieve from service")
  void call_the_http_client_to_retrieve_from_service() {
    weatherService.getByZip("01581");
    verify(weatherApi).getWeather("01581");
  }

  @Test
  @DisplayName("call the http client to retrieve by city name")
  void call_the_http_client_to_retrieve_by_city_name() {
    weatherService.getByCityName("London");
    verify(weatherApi).getWeather("London");
  }

}
