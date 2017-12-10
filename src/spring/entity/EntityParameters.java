package spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "parameters", schema = "public", catalog = "postgres")
public class EntityParameters {
    private int idParameter;
    private String nameParameter;
    private Boolean isRequired;

    @Id
    @Column(name = "id_parameter")
    public int getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }

    @Basic
    @Column(name = "name_parameter")
    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    @Basic
    @Column(name = "is_required")
    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityParameters that = (EntityParameters) o;

        if (idParameter != that.idParameter) return false;
        if (nameParameter != null ? !nameParameter.equals(that.nameParameter) : that.nameParameter != null)
            return false;
        if (isRequired != null ? !isRequired.equals(that.isRequired) : that.isRequired != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idParameter;
        result = 31 * result + (nameParameter != null ? nameParameter.hashCode() : 0);
        result = 31 * result + (isRequired != null ? isRequired.hashCode() : 0);
        return result;
    }
}
