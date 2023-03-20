package com.videogame.gamesales.utils;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.model.response.HorizontalBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Slf4j
public class HorizontalBarUtil {
    public static ResponseEntity<?> formatHorizontalBarData(List<GameSales> gameSalesList) {
        String responseBodyMessage;

        try {
            TreeMap<String, Integer> publishedGameCountTreeMap = getPublishedGameCountHashMap(gameSalesList);
            List<String> publisherNameList = new ArrayList<>(publishedGameCountTreeMap.keySet());
            List<Integer> gamesCountList = new ArrayList<>(publishedGameCountTreeMap.values());
            HorizontalBar horizontalBar = new HorizontalBar(
                    "bar",
                    gamesCountList.subList(0, 10),
                    publisherNameList.subList(0, 10),
                    "h"
            );

            return ResponseEntity.ok(List.of(horizontalBar));
        } catch (Exception exception) {
            responseBodyMessage = exception.getMessage();
            log.error(PieUtil.class.getSimpleName(), responseBodyMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBodyMessage);
        }
    }

    /**
     * Returns a treeMap which contains published games count per publisher
     * @param gameSalesList - queried data from Database
     * @return treeMap
     */
    private static TreeMap<String, Integer> getPublishedGameCountHashMap(List<GameSales> gameSalesList) {
        TreeMap<String, Integer> publishedGameCountHashMap = new TreeMap<>();
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
