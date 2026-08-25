package br.com.fiap.weatherplanner.weather;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
        url = "https://api.open-meteo.com/v1/forecast?latitude=-23.5505&longitude=-46.6333&current_weather=true",
        accept = "application/json"
)
public interface WeatherService {

    @GetExchange
    public WeatherResponse getWeather();

}
