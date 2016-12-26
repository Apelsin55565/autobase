package by.bsu.kvach.autobase.model;

/**
 * Created by timme on 12.12.2016.
 */
public class Role {
    private int idRole;
    private String name_role;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    public Role(int idRole, String name_role) {
        this.idRole = idRole;
        this.name_role = name_role;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", name_role='" + name_role + '\'' +
                '}';
    }

}
