package com.videogame.gamesales.repository;

import com.videogame.gamesales.model.GameSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameSalesRepository extends JpaRepository<GameSales, Long> {

    public List<GameSales> findAllByOrderByUserCountDesc();
}
