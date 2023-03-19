package com.videogame.gamesales.controller;

import com.videogame.gamesales.service.GameSalesService;
import com.videogame.gamesales.utils.ApiUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrls.API_GAME_SALES_CONTROLLER)
public class GamesSalesController {
    private final GameSalesService gameSalesService;

    @Autowired
    public GamesSalesController(GameSalesService gameSalesService) {
        this.gameSalesService = gameSalesService;
    }


}
