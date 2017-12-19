package com.paytoplay.entities.game;


import com.paytoplay.entities.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity, that contains all game information
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "games")
public class Game extends NamedEntity{
    public static final int GAME_SEQ = 100;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "description")
    private String description;

    public Game(){}

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
