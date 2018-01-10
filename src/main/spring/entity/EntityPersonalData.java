package spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "personal_data", schema = "public", catalog = "postgres")
public class EntityPersonalData {
    private int id;
    private long idUser;
    private String data;
    private EntityPersonalDataParameter personalDataParameterByIdParameter;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_user")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityPersonalData that = (EntityPersonalData) o;

        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_parameter", referencedColumnName = "id", nullable = false)
    public EntityPersonalDataParameter getPersonalDataParameterByIdParameter() {
        return personalDataParameterByIdParameter;
    }

    public void setPersonalDataParameterByIdParameter(EntityPersonalDataParameter personalDataParameterByIdParameter) {
        this.personalDataParameterByIdParameter = personalDataParameterByIdParameter;
    }
}
