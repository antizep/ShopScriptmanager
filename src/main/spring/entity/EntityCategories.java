package spring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class EntityCategories {

    private long id;
    private String name;
    private long parent;
    private List<EntityPrice> prices;
    @Id
    @Column(name = "id")
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
    @Column(name = "parent")
    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "category_price",
            joinColumns = {
                    @JoinColumn(name = "category_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "price_id")
            }
    )

    public List<EntityPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<EntityPrice> prices) {
        this.prices = prices;
    }
}
