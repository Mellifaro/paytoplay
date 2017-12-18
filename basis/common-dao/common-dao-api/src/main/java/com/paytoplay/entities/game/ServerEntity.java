package com.paytoplay.entities.game;

import com.paytoplay.entities.NamedEntity;
import com.paytoplay.utils.CommonUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Entity, that contains all game server information
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "servers")
public class ServerEntity extends NamedEntity{
    public static final int SERVER_SEQ = 100;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "server_serverTypes",
            joinColumns = @JoinColumn("server_id"),
            inverseJoinColumns = @JoinColumn("server_type_id")
    )
    @NotNull(message = "Set of server type can't be null. Use empty set instead")
    private Set<ServerTypeEntity> setOfServerTypes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    @NotNull(message = "Game can't be null")
    private GameEntity gameEntity;

    public ServerEntity(){
        super();
        this.setOfServerTypes = Collections.emptySet();
    }

    public ServerEntity(String name, Set<ServerTypeEntity> setOfServerTypes, GameEntity gameEntity){
        super(null, name);
        Objects.requireNonNull(name, "Name can't be null or empty");
        this.setOfServerTypes = setOfServerTypes;
        this.gameEntity = gameEntity;
    }

    /**
     * @return unmodifiable set of server types
     */
    public Set<ServerTypeEntity> getSetOfServerTypes() {
        return CommonUtil.getSafeSet(setOfServerTypes);
    }

    /**
     * @param setOfServerTypes
     * @throws NullPointerException if {@code setOfServerTypes} is null
     */
    public void setSetOfServerTypes(Set<ServerTypeEntity> setOfServerTypes) {
        Objects.requireNonNull(setOfServerTypes, "Set of server types can't be null");
        this.setOfServerTypes = setOfServerTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameEntity getGameEntity() {
        return gameEntity;
    }

    /**
     * @throws NullPointerException if {@code gameEntity} is null
     * @param gameEntity
     */
    public void setGameEntity(GameEntity gameEntity) {
        Objects.requireNonNull(setOfServerTypes, "Game can not be null. Server can't exist without game");
        this.gameEntity = gameEntity;
    }

    @Override
    public String toString() {
        return "ServerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", setOfServerTypes=" + setOfServerTypes +
                ", gameEntity=" + gameEntity +
                '}';
    }
}
