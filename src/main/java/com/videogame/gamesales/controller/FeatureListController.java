package com.videogame.gamesales.controller;

import com.videogame.gamesales.service.FeatureListService;
import com.videogame.gamesales.utils.ApiUrls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(ApiUrls.API_FEATURE_LIST_CONTROLLER)
@Slf4j
public class FeatureListController {
    private final FeatureListService featureListService;

    @Autowired
    public FeatureListController(FeatureListService featureListService) {
        this.featureListService = featureListService;
    }

    @GetMapping
    public ResponseEntity<?> getFeatureList() {
        return featureListService.getFeatureList();
    }

}
