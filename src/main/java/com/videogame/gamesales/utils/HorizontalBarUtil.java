package com.videogame.gamesales.utils;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.model.response.Bar;
import com.videogame.gamesales.model.response.HorizontalBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class HorizontalBarUtil {
    public static ResponseEntity<?> formatHorizontalBarData(List<GameSales> gameSalesList) {
        String responseBodyMessage;

        try {
            HashMap<String, Integer> publishedGameCountHashMap = getpublishedGameCountHashMap(gameSalesList);
            List<String> publisherNameList = new ArrayList<>(publishedGameCountHashMap.keySet());
            List<Integer> gamesCountList = new ArrayList<>(publishedGameCountHashMap.values());
            HorizontalBar horizontalBar = new HorizontalBar(
                    "bar",
                    gamesCountList,
                    publisherNameList,
                    "h"
            );

            return ResponseEntity.ok(List.of(horizontalBar));
        } catch (Exception exception) {
            responseBodyMessage = exception.getMessage();
            log.error(PieUtil.class.getSimpleName(), responseBodyMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBodyMessage);
        }
    }

    private static HashMap<String, Integer> getpublishedGameCountHashMap(List<GameSales> gameSalesList) {
        HashMap<String, Integer> publishedGameCountHashMap = new HashMap<>();
        for (GameSales curGame : gameSalesList) {
            if (curGame.getPublisher() != null) {
                if (!publishedGameCountHashMap.containsKey(curGame.getPublisher())) {
                    publishedGameCountHashMap.put(curGame.getPublisher(), 1);
                } else {
                    int oldCount = publishedGameCountHashMap.get(curGame.getPublisher());
                    publishedGameCountHashMap.put(curGame.getPublisher(), oldCount + 1);
                }
            }
        }
        return publishedGameCountHashMap;
    }
}
