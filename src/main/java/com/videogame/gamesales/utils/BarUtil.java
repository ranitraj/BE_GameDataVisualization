package com.videogame.gamesales.utils;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.model.response.Bar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class BarUtil {
    public static ResponseEntity<?> formatBarData(List<GameSales> gameSalesList) {
        String responseBodyMessage;

        try {
            HashMap<String, List<Float>> higestRatedGameHashMap = getHighestRatedGamesHashMap(gameSalesList);
            List<Bar> outputList = new ArrayList<>();
            List<String> barLabelList = new ArrayList<>(
                    List.of("User Score", "Critic Score")
            );

            int counter = 10;
            for (Map.Entry<String, List<Float>> entry : higestRatedGameHashMap.entrySet()) {
                String curKey = entry.getKey();
                List<Float> curValue = entry.getValue();
                Bar curBar = new Bar(
                        barLabelList,
                        curValue,
                        curKey,
                        "bar"
                );

                counter--;
                if (counter > 0) {
                    outputList.add(curBar);
                }
            }

            return ResponseEntity.ok(outputList);
        } catch (Exception exception) {
            responseBodyMessage = exception.getMessage();
            log.error(PieUtil.class.getSimpleName(), responseBodyMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBodyMessage);
        }
    }

    private static HashMap<String, List<Float>> getHighestRatedGamesHashMap(List<GameSales> gameSalesList) {
        HashMap<String, List<Float>> higestRatedGameHashMap = new HashMap<>();
        for (GameSales curGame : gameSalesList) {
            if (curGame.getUserScore() != null && curGame.getCriticScore() != null) {
                if (!higestRatedGameHashMap.containsKey(curGame.getName())) {
                    higestRatedGameHashMap.put(curGame.getName(), List.of(curGame.getUserScore(), curGame.getCriticScore()/10f));
                }
            }
        }
        return higestRatedGameHashMap;
    }
}
