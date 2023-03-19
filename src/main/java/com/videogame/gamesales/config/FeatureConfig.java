package com.videogame.gamesales.config;

import com.videogame.gamesales.model.Feature;
import com.videogame.gamesales.repository.FeatureListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FeatureConfig {
    @Bean
    CommandLineRunner commandLineRunner(FeatureListRepository featureListRepository) {
        return args -> {
            Feature showAllBrands = new Feature(
                    "Game device Manufactures",
                    "Test Description",
                    ""
            );

            Feature showAllYears = new Feature(
                    "All Years",
                    "Test Description 2",
                    ""
            );

            featureListRepository.saveAll(
                    List.of(showAllBrands, showAllYears)
            );
        };
    }
}
