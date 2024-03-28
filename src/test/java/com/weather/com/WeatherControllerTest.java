package com.weather.com;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.*;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
class WeatherControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    @DisplayName("retrieve weather data by zip code")
    void retrieve_weather_data_by_zip_code() {
        Weather weather = client.toBlocking().exchange("/weather/zip/01581", Weather.class).body();
        assertThat(weather.location().name()).isEqualTo("Westborough");
        assertThat(weather.location().region()).isEqualTo("Massachusetts");
    }

    @Test
    @DisplayName("retrieve weather data by city name")
    void retrieve_weather_data_by_city_name() {
        Weather weather = client.toBlocking().exchange("/weather/city/London", Weather.class).body();
        assertThat(weather.location().name()).isEqualTo("London");
        assertThat(weather.location().region()).isEqualTo("City of London, Greater London");
    }
}