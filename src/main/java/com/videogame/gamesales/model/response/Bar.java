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
public class Bar {
    private List<String> x;
    private List<Float> y;
    private String name;
    private String type;

    @Override
    public String toString() {
        return "Bar{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
