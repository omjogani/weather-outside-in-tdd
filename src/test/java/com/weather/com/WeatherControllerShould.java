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
class WeatherControllerShould {
  @Mock WeatherService weatherService;
  private WeatherController weatherController;

  @BeforeEach
  void init() {
    weatherController = new WeatherController(weatherService);
  }

  @Test
  @DisplayName("call weather service get by zip method")
  void call_weather_service_get_by_zip_method() {
    weatherController.getByZip("01581");
    verify(weatherService).getByZip("01581");
  }

  @Test
  @DisplayName("call weather service get by city name")
  void call_weather_service_get_by_city_name() {
    weatherController.getByCityName("London");
    verify(weatherService).getByCityName("London");
  }

}
