package br.com.fiap.tripcanvas.tools;

import br.com.fiap.tripcanvas.model.Restaurant;
import br.com.fiap.tripcanvas.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantTools {
    private final RestaurantRepository restaurantRepository;

    @Tool(name ="getResturants", description = "Obtem a lista de restaurantes de um destino")
    public List<Restaurant> getRestaurants(
            @ToolParam(description = "A localização do restaurante") String location) {
        return restaurantRepository.findByLocation(location);
    }

    @Tool(name ="getAllResturants", description = "Obtem a lista de restaurantes")
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
