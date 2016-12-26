package by.bsu.kvach.autobase.model;

/**
 * Created by timme on 12.12.2016.
 */
public class Status {
    private int idStatus;
    private String status_name;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public Status(int idStatus, String status_name) {
        this.idStatus = idStatus;
        this.status_name = status_name;
    }

    public Status() {
    }

    @Override
    public String toString() {
        return "Status{" +
                "idStatus=" + idStatus +
                ", status_name='" + status_name + '\'' +
                '}';
    }
}
