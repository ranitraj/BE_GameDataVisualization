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
public class Line {
    private List<Integer> x;
    private List<Float> y;
    private String mode;
    private String name;

    @Override
    public String toString() {
        return "Line{" +
                "x=" + x +
                ", y=" + y +
                ", mode='" + mode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
