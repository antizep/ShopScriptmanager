package spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authentication", schema = "public", catalog = "postgres")
public class EntityAuthentication implements Serializable{

    private long id;
    private String login;
    private String password;
    private EntityRoles role;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    @JoinColumn(name = "role", referencedColumnName = "id_role")
    public EntityRoles getRole() {
        return role;
    }

    public void setRole(EntityRoles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityAuthentication that = (EntityAuthentication) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, role);
    }
}
