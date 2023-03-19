package com.videogame.gamesales.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pie {
    private List<Integer> values;
    private List<String> labels;
    private String type;

    @Override
    public String toString() {
        return "Pie{" +
                "values=" + values +
                ", labels=" + labels +
                ", type='" + type + '\'' +
                '}';
    }
}
