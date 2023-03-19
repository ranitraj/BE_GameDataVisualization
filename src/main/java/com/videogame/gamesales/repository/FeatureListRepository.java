package com.videogame.gamesales.repository;

import com.videogame.gamesales.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureListRepository extends JpaRepository<Feature, Long> {
}
