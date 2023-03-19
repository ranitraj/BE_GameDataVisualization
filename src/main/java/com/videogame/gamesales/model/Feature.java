package com.videogame.gamesales.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    @SequenceGenerator(name = "feature_sequence", sequenceName = "feature_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_sequence")
    private Long id;
    private String featureName;
    private String featureDescription;
    private String featureThumbnailUrl;

    // Constructor with limited arguments
    public Feature(String featureName, String featureDescription, String featureThumbnailUrl) {
        this.featureName = featureName;
        this.featureDescription = featureDescription;
        this.featureThumbnailUrl = featureThumbnailUrl;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", featureName='" + featureName + '\'' +
                ", featureDescription='" + featureDescription + '\'' +
                ", featureThumbnailUrl='" + featureThumbnailUrl + '\'' +
                '}';
    }
}
