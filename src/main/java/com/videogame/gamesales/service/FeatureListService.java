package com.videogame.gamesales.service;

import com.videogame.gamesales.model.Feature;
import com.videogame.gamesales.model.GameSales;
import com.videogame.gamesales.repository.FeatureListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FeatureListService {
    private static final String TAG = FeatureListService.class.getSimpleName();
    private final FeatureListRepository featureListRepository;

    @Autowired
    public FeatureListService(FeatureListRepository featureListRepository) {
        this.featureListRepository = featureListRepository;
    }

    private List<Feature> getAllFeatures() {
        try {
            return featureListRepository.findAll();
        } catch (Exception exception) {
            log.error(TAG, exception.getMessage());
            return new ArrayList<>();
        }
    }

    public ResponseEntity<?> getFeatureList() {
        String responseBodyMessage;
        List<Feature> featureList = getAllFeatures();

        if (featureList.size() == 0) {
            responseBodyMessage = "No data retrieved data for featureList API: Either no Data or Bad Query Grammar";
            log.debug(TAG, responseBodyMessage);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBodyMessage);
        } else {
            try {
                log.debug(FeatureListService.class.getSimpleName(), "Successfully retrieved data for featureList API");
                return ResponseEntity.ok(featureList);
            } catch (Exception exception) {
                responseBodyMessage = exception.getMessage();
                log.error(TAG, responseBodyMessage);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBodyMessage);
            }
        }
    }

}
