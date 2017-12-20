package spring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product", schema = "public", catalog = "postgres")
public class EntityProduct implements Serializable {
    private long id;
    private String name;
    private Integer purchase;
    private Integer selling;
    private String description;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "purchase")
    public Integer getPurchase() {
        return purchase;
    }

    public void setPurchase(Integer purchase) {
        this.purchase = purchase;
    }

    @Basic
    @Column(name = "selling")
    public Integer getSelling() {
        return selling;
    }

    public void setSelling(Integer selling) {
        this.selling = selling;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityProduct that = (EntityProduct) o;

        return id == that.id
                && (name != null ? name.equals(that.name) : that.name == null)
                && (purchase != null ? purchase.equals(that.purchase) : that.purchase == null)
                && (selling != null ? selling.equals(that.selling) : that.selling == null)
                && (description != null ? description.equals(that.description) : that.description == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (purchase != null ? purchase.hashCode() : 0);
        result = 31 * result + (selling != null ? selling.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
