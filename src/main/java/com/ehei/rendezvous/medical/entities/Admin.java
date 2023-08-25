package com.ehei.rendezvous.medical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    public Admin() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(@NotNull String login, @NotNull String password) {
        this.login = login;
        this.password = password;
    }
}
