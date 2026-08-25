package br.com.fiap.weatherplanner.planner;

import br.com.fiap.weatherplanner.log.LogService;
import br.com.fiap.weatherplanner.weather.WeatherResponse;
import br.com.fiap.weatherplanner.weather.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final WeatherService weatherService;
    private final LogService logService;

    public String getPlannerFromActivity(String activity) {
        var weather = weatherService.getWeather().currentWeather();
        var result = switch (activity) {
            case "Viajar de Balão" -> shouldFlyByBallon(weather);
            case "Ver as estrelas" -> shouldViewStars(weather);
            case "Ir a praia" -> shouldGoToBeach(weather);
            default -> "Atividade não reconhecida";
        };

        logService.create(activity, result);

        return result;
    }

    private String shouldFlyByBallon(WeatherResponse.CurrentWeather weather) {
        if (weather.isDay() == 0) {
            return "Não recomendo viajar de balão a noite";
        }
        if (weather.windspeed() > 15) {
            return "Não recomendo viajar de balão com vento forte";
        }
        return "Sim, recomendo viajar de balão!";
    }

    private String shouldViewStars(WeatherResponse.CurrentWeather weather) {
        if (weather.isDay() == 1) {
            return "Não recomendo ver as estrelas durante o dia";
        }
        if (weather.weathercode() > 1) {
            return "Não recomendo ver as estrelas com nuvens no céu";
        }
        return "Sim, recomendo ver as estrelas";
    }

    private String shouldGoToBeach(WeatherResponse.CurrentWeather weather) {
        return "Sim, sempre dá para ir a praia, mas lembre-se de se proteger do sol e se hidratar!";
    }
}
