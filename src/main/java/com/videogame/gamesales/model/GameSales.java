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
    private String genre;
    private String publisher;
    private Float naSales;
    private Float euSales;
    private Float jpSales;
    private Float otherSales;
    private Float globalSales;
    private Float criticScore;
    private Float criticCount;
    private Float userScore;
    private Integer userCount;
    private String developer;
    private String rating;

    public GameSales(String name, String platform, Integer yearOfRelease, String genre, String publisher, Float naSales, Float euSales, Float jpSales, Float otherSales, Float globalSales, Float criticScore, Float criticCount, Float userScore, Integer userCount, String developer, String rating) {
        this.name = name;
        this.platform = platform;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.publisher = publisher;
        this.naSales = naSales;
        this.euSales = euSales;
        this.jpSales = jpSales;
        this.otherSales = otherSales;
        this.globalSales = globalSales;
        this.criticScore = criticScore;
        this.criticCount = criticCount;
        this.userScore = userScore;
        this.userCount = userCount;
        this.developer = developer;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "GameSales{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", naSales=" + naSales +
                ", euSales=" + euSales +
                ", jpSales=" + jpSales +
                ", otherSales=" + otherSales +
                ", globalSales=" + globalSales +
                ", criticScore=" + criticScore +
                ", criticCount=" + criticCount +
                ", userScore=" + userScore +
                ", userCount=" + userCount +
                ", developer='" + developer + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
