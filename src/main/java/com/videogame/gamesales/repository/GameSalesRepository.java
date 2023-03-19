package com.videogame.gamesales.repository;

import com.videogame.gamesales.model.GameSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSalesRepository extends JpaRepository<GameSales, Long> {

}
