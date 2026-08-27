package br.com.fiap.criptoplanner.coin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CoinResponse(
    String id,

    @JsonProperty("market_data")
    MarketData marketData
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MarketData(
        @JsonProperty("price_change_percentage_24h")
        Double priceChange
    ) {}
}

