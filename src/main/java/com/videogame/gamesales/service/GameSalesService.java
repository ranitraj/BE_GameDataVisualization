package com.videogame.gamesales.service;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.model.response.Pie;
import com.videogame.gamesales.repository.GameSalesRepository;
import com.videogame.gamesales.utils.PieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public ResponseEntity<?> returnPieChart() {
        String responseBodyMessage;
        List<GameSales> gameSalesList = getAllGameSalesData();

        if (gameSalesList.size() == 0) {
            responseBodyMessage = "No data retrieved data for pieChart API";
            log.debug(TAG, responseBodyMessage);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBodyMessage);
        } else {
            try {
                return PieUtil.formatPieData(gameSalesList);
            } catch (Exception exception) {
                responseBodyMessage = exception.getMessage();
                log.error(TAG, responseBodyMessage);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBodyMessage);
            }
        }
    }

}
