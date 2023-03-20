package com.videogame.gamesales.utils;

import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.model.response.Line;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

@Slf4j
public class LineUtil {
    public static ResponseEntity<?> formatLineData(List<GameSales> gameSalesList) {
        String responseBodyMessage;

        try {
            List<Line> outputList = new ArrayList<>();
            List<TreeMap<Integer, Float>> platformWiseYearSalesList = getPlatformWiseYearSalesList(gameSalesList);

            for (int i = 0; i < platformWiseYearSalesList.size(); i++) {
                TreeMap<Integer, Float> curPlatformHashMap = platformWiseYearSalesList.get(i);
                List<Integer> yearList = new ArrayList<>(curPlatformHashMap.keySet());
                List<Float> globalSalesList = new ArrayList<>(curPlatformHashMap.values());

                Line curLine = new Line(
                        yearList,
                        globalSalesList,
                        "lines+markers",
                        returnPlatformName(i)
                );
                outputList.add(curLine);
            }

            return ResponseEntity.ok(outputList);
        } catch (Exception exception) {
            responseBodyMessage = exception.getMessage();
            log.error(PieUtil.class.getSimpleName(), responseBodyMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBodyMessage);
        }
    }

    private static List<TreeMap<Integer, Float>> getPlatformWiseYearSalesList(List<GameSales> gameSalesList) {
        TreeMap<Integer, Float> pcSalesTreeMap = new TreeMap<>();
        TreeMap<Integer, Float> psSalesTreeMap = new TreeMap<>();
        TreeMap<Integer, Float> xboxSalesTreeMap = new TreeMap<>();
        TreeMap<Integer, Float> nintendoSalesTreeMap = new TreeMap<>();

        for (GameSales curGame : gameSalesList) {
            if (curGame.getPlatform() != null) {
                if (curGame.getPlatform().equals("PC")) {
                    if (!pcSalesTreeMap.containsKey(curGame.getYearOfRelease())) {
                        pcSalesTreeMap.put(curGame.getYearOfRelease(), curGame.getGlobalSales());
                    } else {
                        float oldValue = pcSalesTreeMap.get(curGame.getYearOfRelease());
                        pcSalesTreeMap.put(curGame.getYearOfRelease(), oldValue + curGame.getGlobalSales());
                    }
                } else if (curGame.getPlatform().equals("PS4")) {
                    if (!psSalesTreeMap.containsKey(curGame.getYearOfRelease())) {
                        psSalesTreeMap.put(curGame.getYearOfRelease(), curGame.getGlobalSales());
                    } else {
                        float oldValue = psSalesTreeMap.get(curGame.getYearOfRelease());
                        psSalesTreeMap.put(curGame.getYearOfRelease(), oldValue + curGame.getGlobalSales());
                    }
                } else if (curGame.getPlatform().equals("XOne")) {
                    if (!xboxSalesTreeMap.containsKey(curGame.getYearOfRelease())) {
                        xboxSalesTreeMap.put(curGame.getYearOfRelease(), curGame.getGlobalSales());
                    } else {
                        float oldValue = xboxSalesTreeMap.get(curGame.getYearOfRelease());
                        xboxSalesTreeMap.put(curGame.getYearOfRelease(), oldValue + curGame.getGlobalSales());
                    }
                } else if (curGame.getPlatform().equals("Wii")) {
                    if (!nintendoSalesTreeMap.containsKey(curGame.getYearOfRelease())) {
                        nintendoSalesTreeMap.put(curGame.getYearOfRelease(), curGame.getGlobalSales());
                    } else {
                        float oldValue = nintendoSalesTreeMap.get(curGame.getYearOfRelease());
                        nintendoSalesTreeMap.put(curGame.getYearOfRelease(), oldValue + curGame.getGlobalSales());
                    }
                }
            }
        }
        return new ArrayList<>(List.of(pcSalesTreeMap, psSalesTreeMap, xboxSalesTreeMap, nintendoSalesTreeMap));
    }

    private static String returnPlatformName(int counter) {
        String platformName;
        if (counter == 0) {
            platformName = "PC";
        } else if (counter == 1) {
            platformName = "Playstation 4";
        } else if (counter == 2) {
            platformName = "XBox One";
        } else {
            platformName = "Nintendo Wii";
        }
        return platformName;
    }

}
