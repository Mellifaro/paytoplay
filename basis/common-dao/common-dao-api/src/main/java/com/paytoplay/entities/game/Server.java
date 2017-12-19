package com.paytoplay.entities.game;

import com.paytoplay.entities.NamedEntity;
import com.paytoplay.utils.CommonUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
 * Entity, that contains all game server information
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "servers")
public class Server extends NamedEntity{
    public static final int SERVER_SEQ = 100;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "server_servertypes",
            joinColumns = @JoinColumn(name = "server_id"),
            inverseJoinColumns = @JoinColumn(name = "server_type_id")
    )
    @NotNull(message = "Set of server type can't be null. Use empty set instead")
    private Set<ServerType> setOfServerTypes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @NotNull(message = "Game can't be null")
    private Game game;

    public Server(){}

    public Server(String name, Set<ServerType> setOfServerTypes, Game game){
        super(null, name);
        Objects.requireNonNull(name, "Name can't be null or empty");
        Objects.requireNonNull(setOfServerTypes, "Set of server types can't be null");
        Objects.requireNonNull(setOfServerTypes, "Game can not be null. Server can't exist without game");
        this.setOfServerTypes = setOfServerTypes;
        this.game = game;
    }

    /**
     * @return unmodifiable set of server types
     */
    public Set<ServerType> getSetOfServerTypes() {
        return CommonUtil.getSafeSet(setOfServerTypes);
    }

    /**
     * @param setOfServerTypes
     * @throws NullPointerException if {@code setOfServerTypes} is null
     */
    public void setSetOfServerTypes(Set<ServerType> setOfServerTypes) {
        Objects.requireNonNull(setOfServerTypes, "Set of server types can't be null");
        this.setOfServerTypes = setOfServerTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game getGame() {
        return game;
    }

    /**
     * @throws NullPointerException if {@code game} is null
     * @param game
     */
    public void setGame(Game game) {
        Objects.requireNonNull(setOfServerTypes, "Game can not be null. Server can't exist without game");
        this.game = game;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", setOfServerTypes=" + setOfServerTypes +
                ", game=" + game +
                '}';
    }
}
