package by.bsu.kvach.autobase.model;

import java.util.Date;

/**
 * Created by timme on 12.12.2016.
 */
public class Trip {
    private int idTrip;
    private Date date;
    private String DriverName;
    private int idDriver_Users;
    private int quantity_trip;
    private String departure_from;
    private String destination_to;
    private int idStatus;

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDriverName() {
        Users users = new Users();
        return DriverName = users.getUsername();
    }

    public int getQuantity_trip() {
        return quantity_trip;
    }

    public void setQuantity_trip(int quantity_trip) {
        this.quantity_trip = quantity_trip;
    }

    public String getDeparture_from() {
        return departure_from;
    }

    public void setDeparture_from(String departure_from) {
        this.departure_from = departure_from;
    }

    public String getDestination_to() {
        return destination_to;
    }

    public void setDestination_to(String destination_to) {
        this.destination_to = destination_to;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdDriver_Users() {
        return idDriver_Users;
    }

    public void setIdDriver_Users(int idDriver_Users) {
        this.idDriver_Users = idDriver_Users;
    }

    public Trip(int idTrip, Date date, String driver, int idDriver_Users, int quantity_trip, String departure_from, String destination_to, int idStatus) {
        this.idTrip = idTrip;
        this.date = date;
        this.idDriver_Users = idDriver_Users;
        this.quantity_trip = quantity_trip;
        this.departure_from = departure_from;
        this.destination_to = destination_to;
        this.idStatus = idStatus;
    }

    public Trip() {
    }

    @Override
    public String toString() {
        return "Trip{" +
                "idTrip=" + idTrip +
                ", date=" + date +
                ", DriverName='" + DriverName + '\'' +
                ", idDriver_Users=" + idDriver_Users +
                ", quantity_trip=" + quantity_trip +
                ", departure_from='" + departure_from + '\'' +
                ", destination_to='" + destination_to + '\'' +
                ", idStatus=" + idStatus +
                '}';
    }
}
