package by.bsu.kvach.autobase.model;

import java.util.List;

/**
 * Created by timme on 12.12.2016.
 */
public class Users {
    private int idUsers;
    private String username;
    private String password;
    private String name;
    private String surname;
    private int role;
    private int idauto;
    private List<Trip> trip;
    private Auto auto;

    public Users(int idUsers, String username, String password, String name, String surname, int role) {
        this.idUsers = idUsers;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public Users(int idUsers, String username, String password, String name, String surname, int role, int idauto, List<Trip> trip, Auto auto) {
        this.idUsers = idUsers;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.idauto = idauto;
        this.trip = trip;
        this.auto = auto;
    }

    public Users() {
    }


    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public List<Trip> getTrip() {
        return trip;
    }

    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getIdauto() {
        return idauto;
    }

    public void setIdauto(int idauto) {
        this.idauto = idauto;
    }
}

