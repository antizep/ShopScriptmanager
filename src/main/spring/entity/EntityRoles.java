package spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class EntityRoles implements Serializable {
    private String name;
    private int idRole;
    private Integer chmod;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id_role")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "chmod")
    public Integer getChmod() {
        return chmod;
    }

    public void setChmod(Integer chmod) {
        this.chmod = chmod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityRoles that = (EntityRoles) o;
        return idRole == that.idRole &&
                Objects.equals(name, that.name) &&
                Objects.equals(chmod, that.chmod);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, idRole, chmod);
    }
}
