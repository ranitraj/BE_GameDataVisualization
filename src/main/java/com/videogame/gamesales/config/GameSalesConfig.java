package com.videogame.gamesales.config;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.repository.GameSalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameSalesConfig {

    @Bean
    CommandLineRunner commandLineRunner2(GameSalesRepository gameSalesRepository) {
        return args -> {
            GameSales gameSales1 = new GameSales(
                    "Wii Sports",
                    "Wii",
                    2006,
                    "Sports",
                    "Nintendo",
                    41.36f,
                    28.96f,
                    3.77f,
                    8.45f,
                    82.53f,
                    76f,
                    51f,
                    8f,
                    322,
                    "Nintendo",
                    "E"
            );

            GameSales gameSales2 = new GameSales(
                    "FIFA 16",
                    "PS4",
                    2015,
                    "Sports",
                    "Electronic Arts",
                    1.12f,
                    6.12f,
                    0.06f,
                    1.28f,
                    8.57f,
                    82f,
                    42f,
                    4.3f,
                    896,
                    "EA Sports",
                    "E"
            );

            GameSales gameSales3 = new GameSales(
                    "Final Fantasy X",
                    "PS2",
                    2001,
                    "Role-Playing",
                    "Sony Computer Entertainment",
                    2.91f,
                    2.07f,
                    2.73f,
                    0.33f,
                    8.05f,
                    92f,
                    53f,
                    8.7f,
                    1056,
                    "SquareSoft",
                    "T"

            );

            GameSales gameSales4 = new GameSales(
                    "FIFA 16",
                    "PC",
                    2015,
                    "Sports",
                    "Electronic Arts",
                    1.12f,
                    6.12f,
                    0.06f,
                    1.28f,
                    8.57f,
                    82f,
                    42f,
                    4.3f,
                    896,
                    "EA Sports",
                    "E"
            );

            gameSalesRepository.saveAll(
                    List.of(gameSales1, gameSales2, gameSales3, gameSales4)
            );
        };

    }
}
