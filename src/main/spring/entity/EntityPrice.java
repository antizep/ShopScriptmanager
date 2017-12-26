package spring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "price", schema = "public", catalog = "postgres")
public class EntityPrice implements Serializable{
    private EntityProvider providerByProvider;
    private EntityProduct productByProduct;
    private long id;
    @ManyToOne
    @JoinColumn(name = "provider", referencedColumnName = "id", nullable = false)
    public EntityProvider getProviderByProvider() {
        return providerByProvider;
    }

    public void setProviderByProvider(EntityProvider providerByProvider) {
        this.providerByProvider = providerByProvider;
    }

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id", nullable = false)
    public EntityProduct getProductByProduct() {
        return productByProduct;
    }

    public void setProductByProduct(EntityProduct productByProduct) {
        this.productByProduct = productByProduct;
    }
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
