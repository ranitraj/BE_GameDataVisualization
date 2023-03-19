package com.videogame.gamesales.utils;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.model.response.Pie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

@Slf4j
public class PieUtil {
    public static ResponseEntity<?> formatPieData(List<GameSales> gameSalesList) {
        String responseBodyMessage;

        try {
            HashMap<String, Integer> genreWiseSalesHashMap = getAllGenreWiseSales(gameSalesList);
            List<String> genresList = new ArrayList<>(genreWiseSalesHashMap.keySet());
            List<Integer> salesValueList = new ArrayList<>(genreWiseSalesHashMap.values());

            Pie pie = new Pie(
                    salesValueList,
                    genresList,
                    "pie"
            );
            return ResponseEntity.ok(List.of(pie));
        } catch (Exception exception) {
            responseBodyMessage = exception.getMessage();
            log.error(PieUtil.class.getSimpleName(), responseBodyMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBodyMessage);
        }
    }

    private static HashMap<String, Integer> getAllGenreWiseSales(List<GameSales> gameSalesList) {
        HashMap<String, Integer> genreWiseSalesHashMap = new HashMap<>();
        for (GameSales curGame : gameSalesList) {
            if (curGame.getGenre() != null) {
                if (!genreWiseSalesHashMap.containsKey(curGame.getGenre())) {
                    genreWiseSalesHashMap.put(curGame.getGenre(), curGame.getGlobalSales().intValue());
                } else {
                    int oldValue = genreWiseSalesHashMap.get(curGame.getGenre());
                    genreWiseSalesHashMap.put(curGame.getGenre(), oldValue + curGame.getGlobalSales().intValue());
                }
            }
        }
        return genreWiseSalesHashMap;
    }


}
