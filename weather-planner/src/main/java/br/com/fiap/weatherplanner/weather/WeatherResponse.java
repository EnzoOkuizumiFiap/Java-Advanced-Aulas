package br.com.fiap.weatherplanner.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(
        @JsonProperty("current_weather")
        CurrentWeather currentWeather
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CurrentWeather (
            double temperature,
            double windspeed,
            @JsonProperty("is_day")
            int isDay,
            int weathercode
    ) {}
}
