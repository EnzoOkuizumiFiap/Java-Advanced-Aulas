package br.com.fiap.criptoplanner.planner;

import br.com.fiap.criptoplanner.coin.CoinResponse;
import br.com.fiap.criptoplanner.coin.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final CoinService coinService;

    public String getPlannerFromActivity(String activity) {
        if (activity == null || activity.isBlank()) {
            throw new IllegalArgumentException("Atividade não informada.");
        }

        return switch (activity.trim()) {
            case "Comprar Bitcoin" -> evaluateBuyBitcoin();
            case "Vender Ethereum" -> evaluateSellEthereum();
            case "Investir em Dogecoin" -> evaluateInvestDogecoin();
            default -> throw new IllegalArgumentException("Atividade desconhecida: " + activity);
        };
    }

    private String evaluateBuyBitcoin() {
        CoinResponse coin = coinService.getCoin("bitcoin");
        double change = getPriceChange(coin);
        if (change > 5.0) {
            return String.format(Locale.US, "Não recomendado (pode estar supervalorizado). O preço subiu %.1f%% nas últimas 24h.", change);
        } else if (change < -5.0) {
            return String.format(Locale.US, "Bom momento para comprar Bitcoin, o preço caiu %.1f%% nas últimas 24h.", Math.abs(change));
        } else {
            return String.format(Locale.US, "Preço estável, sem sinal forte. A variação foi de %.1f%% nas últimas 24h.", change);
        }
    }

    private String evaluateSellEthereum() {
        CoinResponse coin = coinService.getCoin("ethereum");
        double change = getPriceChange(coin);
        if (change < -5.0) {
            return String.format(Locale.US, "Não recomendado vender, espere recuperação. O preço caiu %.1f%% nas últimas 24h.", Math.abs(change));
        } else if (change > 5.0) {
            return String.format(Locale.US, "Bom momento para vender Ethereum, o preço subiu %.1f%% nas últimas 24h.", change);
        } else {
            return String.format(Locale.US, "Preço estável, sem sinal forte. A variação foi de %.1f%% nas últimas 24h.", change);
        }
    }

    private String evaluateInvestDogecoin() {
        CoinResponse coin = coinService.getCoin("dogecoin");
        double change = getPriceChange(coin);
        if (change > 10.0) {
            return String.format(Locale.US, "Cuidado, alta volatilidade, risco elevado. O preço variou %.1f%% nas últimas 24h.", change);
        } else {
            return String.format(Locale.US, "Volatilidade normal, mas é ativo de altíssimo risco. A variação foi de %.1f%% nas últimas 24h.", change);
        }
    }

    private double getPriceChange(CoinResponse coin) {
        return coin.marketData().priceChange();
    }
}