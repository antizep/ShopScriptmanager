package spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_parameter", schema = "public", catalog = "postgres")
public class EntityUserParameter {
    private String value;
    private int id;
    private EntityAuntification auntificationByUserId;
    private EntityParameters parametersByIdParemeter;

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityUserParameter that = (EntityUserParameter) o;

        if (id != that.id) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public EntityAuntification getAuntificationByUserId() {
        return auntificationByUserId;
    }

    public void setAuntificationByUserId(EntityAuntification auntificationByUserId) {
        this.auntificationByUserId = auntificationByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "id_paremeter", referencedColumnName = "id_parameter")
    public EntityParameters getParametersByIdParemeter() {
        return parametersByIdParemeter;
    }

    public void setParametersByIdParemeter(EntityParameters parametersByIdParemeter) {
        this.parametersByIdParemeter = parametersByIdParemeter;
    }
}
