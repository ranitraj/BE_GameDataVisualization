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
            Feature sunburstChart = new Feature(
                    "Which video game genres are the most popular?",
                    "Visualized using a Pie chart distribution to show the popularity of Video games based on their Global sales.",
                    "https://drive.google.com/file/d/10-qwX6VdwztYANwt4HEhACTeUkouHWF2/view?usp=share_link"
            );

            Feature barChart = new Feature(
                    "What are the highest-rated video games?",
                    "Visualized using a Bar chart or stacked bar chart to compare highest-rated video games based on the User and Critic Scores for games with highest unique ratings count.",
                    "https://drive.google.com/file/d/1u1yJ4xOGZliebpWqkkDTetAVbiOGVUxc/view?usp=share_link"
            );

            Feature lineChart = new Feature(
                    "How do sales vary across different gaming platforms and what are the trends over time?",
                    "Visualized using a Line chart to show the trend of sales across different gaming platforms over time.",
                    "https://drive.google.com/file/d/13KYEycpL9RyN2uyUHYbjcfo1ij_mgMK9/view?usp=share_link"
            );

            Feature scatterChart = new Feature(
                    "What is the Number of games developed by various publishers?",
                    "Visualized using a Horizontal Bar Chart to show the count of games developed by each Publisher over the years.",
                    "https://drive.google.com/file/d/1JP3FZlUlvYkPy4sr69Ixiw4Bm6hnBICQ/view?usp=share_link"
            );

            featureListRepository.saveAll(
                    List.of(sunburstChart, barChart, lineChart, scatterChart)
            );
        };
    }
}
