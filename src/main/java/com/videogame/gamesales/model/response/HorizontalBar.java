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
public class HorizontalBar {
    private String type;
    private List<Integer> x;
    private List<String> y;
    private String orientation;

    @Override
    public String toString() {
        return "HorizontalBar{" +
                "type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", orientation='" + orientation + '\'' +
                '}';
    }
}
