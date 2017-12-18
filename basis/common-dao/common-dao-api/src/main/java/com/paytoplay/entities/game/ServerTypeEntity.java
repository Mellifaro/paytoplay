package com.paytoplay.entities.game;

import com.paytoplay.entities.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Entity, that contains type of game server
 * @author v.skapoushchenko
 */
@Entity
@Table(name = "server_types")
public class ServerTypeEntity extends BaseEntity{
    public static final int SERVER_TYPE_SEQ = 100;

    @Column(name = "server_type")
    @NotBlank(message = "Server type can't be blank")
    @Size(min = 1, max = 10, message = "Length of server type must be between 1 and 10 characters")
    private String serverType;

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    @Override
    public String toString() {
        return "ServerTypeEntity{" +
                "id=" + id +
                ", serverType='" + serverType + '\'' +
                '}';
    }
}
