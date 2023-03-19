package com.videogame.gamesales.service;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.repository.GameSalesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GameSalesService {
    private static final String TAG = GameSalesService.class.getSimpleName();
    private final GameSalesRepository gameSalesRepository;

    @Autowired
    public GameSalesService(GameSalesRepository gameSalesRepository) {
        this.gameSalesRepository = gameSalesRepository;
    }

    private List<GameSales> getAllGameSalesData() {
        return gameSalesRepository.findAll();
    }
}
