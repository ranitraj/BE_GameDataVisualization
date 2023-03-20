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
                    "Fantasy",
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
                    "PS4",
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


            GameSales gameSales5 = new GameSales(
                    "The Witcher 3: Wild Hunt",
                    "PS4",
                    2015,
                    "Role-Playing",
                    "Namco Bandai Games",
                    1.02f,
                    2.13f,
                    0.23f,
                    0.59f,
                    3.97f,
                    92f,
                    79f,
                    9.2f,
                    10179,
                    "CD Projekt Red Studio",
                    "M"
            );

            GameSales gameSales6 = new GameSales(
                    "Final Fantasy XV",
                    "Wii",
                    2016,
                    "Role-Playing",
                    "Sony Computer Entertainment",
                    2.91f,
                    2.07f,
                    2.73f,
                    0.33f,
                    8.05f,
                    94f,
                    53f,
                    8.5f,
                    1056,
                    "SquareSoft",
                    "T"

            );
            GameSales gameSales7 = new GameSales(
                    "Assassin's Creed: Unity",
                    "XBox",
                    2014,
                    "Action",
                    "Ubisoft",
                    1.19f,
                    2.07f,
                    0.08f,
                    0.62f,
                    3.96f,
                    70f,
                    40f,
                    4.9f,
                    2050,
                    "Nintendo",
                    "E"
            );

            GameSales gameSales8 = new GameSales(
                    "Fallout 3",
                    "PC",
                    2008,
                    "Role-Playing",
                    "Bethesda Softworks",
                    2.15f,1.13f,0.07f,0.59f,3.94f,90f,57f,8f,910,
                    "Bethesda Game Studios",
                    "M"
            );

            GameSales gameSales9 = new GameSales(
                    "Final Fantasy XI",
                    "PS4",
                    2014,
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

            GameSales gameSales10 = new GameSales(
                    "FIFA 19",
                    "PC",
                    2019,
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


            GameSales gameSales11 = new GameSales(
                    "The Witcher 2: Assassination of the Kings",
                    "PS4",
                    2010,
                    "Role-Playing",
                    "Namco Bandai Games",
                    1.02f,
                    2.13f,
                    0.23f,
                    0.59f,
                    3.97f,
                    92f,
                    79f,
                    9.4f,
                    10179,
                    "CD Projekt Red Studio",
                    "M"
            );

            GameSales gameSales12 = new GameSales(
                    "Final Fantasy XVI",
                    "Wii",
                    2017,
                    "Role-Playing",
                    "Sony Computer Entertainment",
                    2.91f,
                    2.07f,
                    2.73f,
                    0.33f,
                    8.05f,
                    94f,
                    53f,
                    8.5f,
                    1056,
                    "SquareSoft",
                    "T"

            );

            gameSalesRepository.saveAll(
                    List.of(gameSales1, gameSales2, gameSales3, gameSales4, gameSales5, gameSales6,
                            gameSales7, gameSales8, gameSales9, gameSales10, gameSales11, gameSales12)
            );
        };

    }
}
