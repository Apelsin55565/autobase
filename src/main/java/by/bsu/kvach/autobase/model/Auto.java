package by.bsu.kvach.autobase.model;

/**
 * Created by timme on 12.12.2016.
 */
public class Auto {

    private int idAuto;
    private String mark;
    private String model;
    private boolean isOk;
    private int quantity_auto;
    private int idUsers;
    private Users userName;

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean getisOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public int getQuantity_auto() {
        return quantity_auto;
    }

    public void setQuantity_auto(int quantity_auto) {
        this.quantity_auto = quantity_auto;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public Users getUserName() {
        return userName;
    }

    public void setUserName(Users userName) {
        this.userName = userName;
    }

    public Auto(int idAuto, String mark, String model, boolean isOk, int quantity_auto, int idUsers, Users userName) {
        this.idAuto = idAuto;
        this.mark = mark;
        this.model = model;
        this.isOk = isOk;
        this.quantity_auto = quantity_auto;
        this.idUsers = idUsers;
        this.userName = userName;
    }

    public Auto() {
    }



    @Override
    public String toString() {
        return "Auto{" +
                "idAuto=" + idAuto +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", isOk=" + isOk +
                ", quantity_auto=" + quantity_auto +
                ", idUsers=" + idUsers +
                '}';
    }
}
