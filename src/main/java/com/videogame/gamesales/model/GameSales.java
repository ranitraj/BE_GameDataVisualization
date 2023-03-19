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
public class GameSales {
    @Id
    @SequenceGenerator(name = "game_sales_sequence", sequenceName = "game_sales_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sales_sequence")
    private Long id;
    private String name;
    private String platform;
    private Integer yearOfRelease;
    private Integer genre;
    private String publisher;
    private Float naSales;
    private Float euSales;
    private Float jpSales;
    private Float otherSales;
    private Float globalSales;
    private Float criticScore;
    private Float userScore;
    private Integer userCount;
    private String developer;

    @Override
    public String toString() {
        return "GameSales{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", genre=" + genre +
                ", publisher='" + publisher + '\'' +
                ", naSales=" + naSales +
                ", euSales=" + euSales +
                ", jpSales=" + jpSales +
                ", otherSales=" + otherSales +
                ", globalSales=" + globalSales +
                ", criticScore=" + criticScore +
                ", userScore=" + userScore +
                ", userCount=" + userCount +
                ", developer='" + developer + '\'' +
                '}';
    }
}
