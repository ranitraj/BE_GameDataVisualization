package com.videogame.gamesales.controller;

import com.videogame.gamesales.service.GameSalesService;
import com.videogame.gamesales.utils.ApiUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = ApiUrls.API_GAME_SALES_CONTROLLER)
public class GamesSalesController {
    private final GameSalesService gameSalesService;

    @Autowired
    public GamesSalesController(GameSalesService gameSalesService) {
        this.gameSalesService = gameSalesService;
    }

    @GetMapping(value = ApiUrls.API_PIE_CHART)
    public ResponseEntity<?> returnPieChart() {
        return gameSalesService.returnPieChart();
    }

    @GetMapping(value = ApiUrls.API_BAR_CHART)
    public ResponseEntity<?> returnBarChart() {
        return gameSalesService.returnBarChart();
    }

    @GetMapping(value = ApiUrls.API_LINE_CHART)
    public ResponseEntity<?> returnLineChart() {
        return gameSalesService.returnLineChart();
    }

    @GetMapping(value = ApiUrls.API_HORIZONTAL_BAR_CHART)
    public ResponseEntity<?> returnHorizontalBarChart() {
        return gameSalesService.returnHorizontalBarChart();
    }
}
