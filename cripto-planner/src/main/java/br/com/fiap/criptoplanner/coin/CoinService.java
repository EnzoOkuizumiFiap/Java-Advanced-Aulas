package br.com.fiap.criptoplanner.coin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
        url = "https://api.coingecko.com/api/v3/coins",
        accept = "application/json"
)
public interface CoinService {

    @GetExchange("/{id}")
    CoinResponse getCoin(@PathVariable("id") String id);
}

