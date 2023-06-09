package com.videogame.gamesales.service;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.repository.GameSalesRepository;
import com.videogame.gamesales.utils.BarUtil;
import com.videogame.gamesales.utils.HorizontalBarUtil;
import com.videogame.gamesales.utils.LineUtil;
import com.videogame.gamesales.utils.PieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try {
            return gameSalesRepository.findAll();
        } catch (Exception exception) {
            log.error(TAG, exception.getMessage());
            return new ArrayList<>();
        }
    }

    private List<GameSales> getAllGameSaleOrderByUserCountDesc() {
        try {
            return gameSalesRepository.findAllByOrderByUserCountDesc();
        } catch (Exception exception) {
            log.error(TAG, exception.getMessage());
            return new ArrayList<>();
        }
    }

    public ResponseEntity<?> returnPieChart() {
        String responseBodyMessage;
        List<GameSales> gameSalesList = getAllGameSalesData();

        if (gameSalesList.size() == 0) {
            responseBodyMessage = "No data retrieved data for pieChart API: Either no Data or Bad Query Grammar";
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

    public ResponseEntity<?> returnBarChart() {
        String responseBodyMessage;
        List<GameSales> gameSalesList = getAllGameSaleOrderByUserCountDesc();

        if (gameSalesList.size() == 0) {
            responseBodyMessage = "No data retrieved data for barChart API: Either no Data or Bad Query Grammar";
            log.debug(TAG, responseBodyMessage);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBodyMessage);
        } else {
            try {
                return BarUtil.formatBarData(gameSalesList);
            } catch (Exception exception) {
                responseBodyMessage = exception.getMessage();
                log.error(TAG, responseBodyMessage);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBodyMessage);
            }
        }
    }

    public ResponseEntity<?> returnLineChart() {
        String responseBodyMessage;
        List<GameSales> gameSalesList = getAllGameSalesData();

        if (gameSalesList.size() == 0) {
            responseBodyMessage = "No data retrieved data for LineChart API: Either no Data or Bad Query Grammar";
            log.debug(TAG, responseBodyMessage);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBodyMessage);
        } else {
            try {
                return LineUtil.formatLineData(gameSalesList);
            } catch (Exception exception) {
                responseBodyMessage = exception.getMessage();
                log.error(TAG, responseBodyMessage);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBodyMessage);
            }
        }
    }

    public ResponseEntity<?> returnHorizontalBarChart() {
        String responseBodyMessage;
        List<GameSales> gameSalesList = getAllGameSalesData();

        if (gameSalesList.size() == 0) {
            responseBodyMessage = "No data retrieved data for horizontalBarChart API: Either no Data or Bad Query Grammar";
            log.debug(TAG, responseBodyMessage);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBodyMessage);
        } else {
            try {
                return HorizontalBarUtil.formatHorizontalBarData(gameSalesList);
            } catch (Exception exception) {
                responseBodyMessage = exception.getMessage();
                log.error(TAG, responseBodyMessage);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBodyMessage);
            }
        }
    }

}
